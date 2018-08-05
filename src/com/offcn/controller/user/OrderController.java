package com.offcn.controller.user;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.UserAddresses;
import com.offcn.pojo.Users;
import com.offcn.service.AddressService;
import com.offcn.service.CartService;
import com.offcn.service.ItemService;
import com.offcn.service.OrderItemService;
import com.offcn.service.OrderService;
import com.offcn.util.SessionUtil;

/**
 * 订单控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/order")
public class OrderController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * 展示结算页面
	 * @return
	 */
	@RequestMapping("/checkout")
	public String checkout() {
		return "/user/checkout";
	}
	
	/**
	 * 展示用户订单页
	 * @return
	 */
	@RequestMapping("")
	public String orderList() {
		return "/user/order";
	}
	
	/**
	 * ajax 进行下单操作
	 * @param json
	 * @return
	 */
	@RequestMapping("/ajax/checkout")
	@ResponseBody
	public HashMap<String, Object> AjaxCheckOut(@RequestBody HashMap<String, Object> json) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//地址归属校验
		int address_id = (Integer) json.get("address_id");
		UserAddresses address = this.addressService.getAddressByUserAndAddressId(address_id, current_user.getId());
		if(address == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		SessionUtil session_util = new SessionUtil(session);
		List<Integer> selected_item_list = session_util.getUserCheckoutListFromSession();
		//下单操作
		int order_id = this.orderService.putOrder(current_user, address, selected_item_list);
		
		//传递订单信息
		HashMap<String, Object> sub_data_hashmap = new HashMap<String, Object>();
		sub_data_hashmap.put("order_id", order_id);
		return_hashmap.put("data", sub_data_hashmap);
		
		return_hashmap.put("result", 1);
		
		
		//清理购物车以及线程
		session_util.removeUserCheckoutListFromSession();
		for (Integer item_id : selected_item_list) {
			this.cartService.deleteItemCartByUser(current_user.getId(), item_id);
		}
		
		return return_hashmap;
	}
	
	/**
	 * Ajax 获取订单列表
	 * @return
	 */
	@RequestMapping("/ajax/list")
	@ResponseBody
	public HashMap<String, Object> AjaxOrderList() {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		return_hashmap.put("result", 1);
		return_hashmap.put("data", this.orderService.getOrdersByUserId(current_user.getId()));
		
		return return_hashmap;
	}
	
	/**
	 * Ajax获取订单中的商品
	 * @param json
	 * @return
	 */
	@RequestMapping("/ajax/item")
	@ResponseBody
	public HashMap<String, Object> AjaxOrderItem(@RequestBody HashMap<String, Object> json) {
		int order_id = (Integer) json.get("order_id");
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		if(!this.orderService.isOrderByUser(order_id, current_user.getId())) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		return_hashmap.put("result", 1);
		return_hashmap.put("data", this.orderItemService.getOrderItemByOrderId(order_id));
		
		return return_hashmap;
	}
}
