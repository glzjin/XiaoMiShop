package com.offcn.controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.UserAddresses;
import com.offcn.pojo.Users;
import com.offcn.service.AddressService;
import com.offcn.util.SessionUtil;

/**
 * 用户地址控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/address")
public class AddressController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * ajax 拉取用户地址列表
	 * @return json 封装的地址数据
	 */
	@RequestMapping("/ajax/list")
	@ResponseBody
	public HashMap<String, Object> ajaxList() {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		return_hashmap.put("data", this.addressService.queryAllAddressByUser(current_user.getId()));
		return_hashmap.put("result", 1);
		return return_hashmap;
	}
	
	/**
	 * ajax 添加地址
	 * @return json 封装的地址数据
	 */
	@RequestMapping("/ajax/add")
	@ResponseBody
	public HashMap<String, Object> ajaxAdd(@RequestBody UserAddresses address) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		address.setUserId(current_user.getId());
		this.addressService.addAddressByUser(address);
		
		return_hashmap.put("result", 1);
		return return_hashmap;
	}
	
	/**
	 * ajax 更新地址
	 * @return json 封装的结果
	 */
	@RequestMapping("/ajax/update")
	@ResponseBody
	public HashMap<String, Object> ajaxUpdate(@RequestBody UserAddresses address) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//判断地址是否属于这个用户
		if(!this.addressService.isAddressByUser(address, current_user.getId())) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		address.setUserId(current_user.getId());
		this.addressService.updateAddressByUser(address);
		
		return_hashmap.put("result", 1);
		return return_hashmap;
	}
	
	/**
	 * ajax 删除地址
	 * @return json 封装的结果
	 */
	@RequestMapping("/ajax/delete")
	@ResponseBody
	public HashMap<String, Object> ajaxDelete(@RequestBody UserAddresses address) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		
		Users current_user = new SessionUtil(session).getUserFromSession();
		if(current_user == null) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		//判断地址是否属于这个用户
		if(!this.addressService.isAddressByUser(address, current_user.getId())) {
			return_hashmap.put("result", 0);
			return return_hashmap;
		}
		
		address.setUserId(current_user.getId());
		this.addressService.deleteAddressById(address);
		
		return_hashmap.put("result", 1);
		return return_hashmap;
	}
}
