package com.offcn.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.CartInfos;
import com.offcn.pojo.Users;
import com.offcn.service.CartService;
import com.offcn.util.SessionUtil;

/**
 * 购物车控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 展示购物车页面
	 * @return
	 */
	@RequestMapping("")
	public String cartShow() {
		return "user/cart";
	}
	
	/**
	 * ajax 添加到购物车
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/ajax/add", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> ajaxAdd(@RequestBody HashMap<String, Object> json) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		int item_id = (Integer) json.get("item_id");
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		try {
			this.cartService.addItemToUserCart(current_user.getId(), item_id);
			return_hashmap.put("result", 1);
		} catch (Exception e) {
			return_hashmap.put("result", 0);
		}
		
		return return_hashmap;
	}
	
	/**
	 * ajax列出购物车信息
	 * @return json封装的购物车信息
	 */
	@RequestMapping(value = "/ajax/list", method = RequestMethod.POST)
	@ResponseBody
	public List<CartInfos> ajaxList() {
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return new ArrayList<CartInfos>();
		}
		
		return this.cartService.getCartInfosByUserId(current_user.getId());
	}
	
	/**
	 * ajax 判断商品是否在购物车里
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/ajax/item/is_in", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> ajaxItemIn(@RequestBody HashMap<String, Object> json) {
		int item_id = (Integer) json.get("item_id");
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		
		if(this.cartService.isItemCartByUser(current_user.getId(), item_id)) {
			return_hashmap.put("result", 1);
		} else {
			return_hashmap.put("result", 0);
		}
		
		return return_hashmap;
	}
	
	/**
	 * ajax 删除购物车里的商品
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/ajax/item/delete", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> ajaxItemDelete(@RequestBody HashMap<String, Object> json) {
		int item_id = (Integer) json.get("item_id");
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		this.cartService.deleteItemCartByUser(current_user.getId(), item_id);
		return_hashmap.put("result", 1);
		
		return return_hashmap;
	}
	
	/**
	 * ajax 修改购物车里商品信息
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/ajax/item/modify", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> ajaxItemModify(@RequestBody HashMap<String, Object> json) {
		int item_id = (Integer) json.get("item_id");
		Boolean is_add = (Boolean) json.get("is_add");
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		this.cartService.modifyItemCartByUser(current_user.getId(), item_id, is_add);
		return_hashmap.put("result", 1);
		
		return return_hashmap;
	}
	
	@RequestMapping(value = "/ajax/checkout", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> ajaxCheckOut(@RequestBody ArrayList<Integer> json) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		new SessionUtil(session).setUserCheckoutListToSession(json);
		return_hashmap.put("result", 1);
		
		return return_hashmap;
	}
	
	/**
	 * ajax 将购物车内选中的信息进行结账
	 * @return
	 */
	@RequestMapping(value = "/ajax/checkout", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> ajaxCheckoutGet() {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		List<Integer> data = new SessionUtil(session).getUserCheckoutListFromSession();
		return_hashmap.put("result", 1);
		return_hashmap.put("data", data);
		
		return return_hashmap;
	}
}
