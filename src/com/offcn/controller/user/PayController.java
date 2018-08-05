package com.offcn.controller.user;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.Orders;
import com.offcn.pojo.PayInfo;
import com.offcn.pojo.UserAddresses;
import com.offcn.pojo.Users;
import com.offcn.service.CartService;
import com.offcn.service.ItemService;
import com.offcn.service.OrderService;
import com.offcn.util.PayUtil;
import com.offcn.util.SessionUtil;

/**
 * 支付控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/pay")
public class PayController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 对订单下立支付请求
	 * @param json
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/ajax/order")
	@ResponseBody
	public HashMap<String, Object> ajaxOrderPay(@RequestBody HashMap<String, Object> json) throws IOException {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		SessionUtil sessionUtil = new SessionUtil(session);
		Users current_user = sessionUtil.getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//订单归属校验
		int order_id = (Integer) json.get("order_id");
		Orders order = this.orderService.getOrderById(order_id);
		if(order.getUserId() != current_user.getId()) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//订单状态校验
		if(order.getStatus() != orderService.STATUS_ORDER_UNPAID) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//获取选定的支付方式
		String pay_method = (String) json.get("pay_method");
		
		//创建支付请求
		PayUtil payUtils = new PayUtil();
		PayInfo payInfo = payUtils.createPay(order.getPrice().doubleValue(), pay_method);
		//往线程里存支付信息
		sessionUtil.setPayInfoToSession(order_id, payInfo);
		//设置返回信息
		return_hashmap.put("result", 1);
		//传递订单信息
		HashMap<String, Object> sub_data_hashmap = new HashMap<String, Object>();
		if(!payInfo.getLink().equals("")) {
			sub_data_hashmap.put("type", 1);//type=1,跳转式支付
			sub_data_hashmap.put("link", payInfo.getLink());
		} else {
			sub_data_hashmap.put("type", 2);//type=2，扫码支付
			sub_data_hashmap.put("qrcode", payInfo.getQrcode());
			sub_data_hashmap.put("tips", payInfo.getTips());
		}
		
		return_hashmap.put("data", sub_data_hashmap);
		
		return return_hashmap;
	}
	
	/**
	 * 对订单的支付请求进行检测
	 * @param json
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/ajax/order/check")
	@ResponseBody
	public HashMap<String, Object> ajaxOrderCheck(@RequestBody HashMap<String, Object> json) throws IOException {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		SessionUtil sessionUtil = new SessionUtil(session);
		Users current_user = sessionUtil.getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//订单归属校验
		int order_id = (Integer) json.get("order_id");
		Orders order = this.orderService.getOrderById(order_id);
		if(order.getUserId() != current_user.getId()) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//订单状态校验
		if(order.getStatus() != orderService.STATUS_ORDER_UNPAID) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//从线程里拉取支付信息
		PayInfo pay_info = sessionUtil.getPayInfoToSession(order_id);
		
		//判断支付信息是否存在
		if(pay_info == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//创建支付查询
		PayUtil payUtils = new PayUtil();
		Boolean result = payUtils.checkPay(pay_info);
		
		//如果已经支付，那么就要更新订单的状态
		if(result) {
			order.setStatus(OrderService.STATUS_ORDER_PAID);
			this.orderService.updateOrderById(order);
			
			//清空线程里的数据
			sessionUtil.removePayInfoFromSession(order_id);
		}
		
		//传递查询结果
		HashMap<String, Object> sub_data_hashmap = new HashMap<String, Object>();
		sub_data_hashmap.put("is_paid", result);
		
		return_hashmap.put("result", 1);
		return_hashmap.put("data", sub_data_hashmap);
		
		return return_hashmap;
	}
}
