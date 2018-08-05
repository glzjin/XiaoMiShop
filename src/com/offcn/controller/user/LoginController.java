package com.offcn.controller.user;


import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.Users;
import com.offcn.service.UsersService;
import com.offcn.util.SessionUtil;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/login")
public class LoginController {
	@Autowired
	private UsersService userService;
	
	@Autowired
	private HttpSession session;

	/**
	 * 展示登录页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "")
	public String hello(Model model) {
		return "login/index";
	}
	
	/**
	 * 进行登出操作，并跳转到首页
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		SessionUtil sessionUtil = new SessionUtil(session);
		//从线程里抹除用户
		sessionUtil.removeUserFromSession();
		return "redirect:/";
	}
	
	/**
	 * ajax进行登录操作
	 * @param json
	 * @param model
	 * @return 0 = 登录失败，1=登录成功，2=登陆成功，但未验证邮箱
	 */
	@RequestMapping(value = "/ajax")
	@ResponseBody
	public HashMap<String, Object> login(@RequestBody HashMap<String, Object> json, Model model) {
		String email = (String) json.get("email");
		String password = (String) json.get("password");
		
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		try {
			//查找用户，验证用户密码
			Users user = this.userService.userLogin(email, password);
			if(user != null) {
				//判断用户状态
				if(user.getIsEmailAuth() == UsersService.USER_AUTH_STATUS_UNAUTH) {
					return_hashmap.put("result", 2);
				} else {
					new SessionUtil(session).setUserToSession(user);
					return_hashmap.put("result", 1);
				}
			} else {
				return_hashmap.put("result", 0);
			}
		} catch (Exception e){
			return_hashmap.put("result", 0);
		}
		
		return return_hashmap;
	}
	
	/**
	 * Ajax进行登出操作
	 * @param json
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajax/logout")
	@ResponseBody
	public HashMap<String, Object> logout_ajax(@RequestBody HashMap<String, Object> json, Model model) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		SessionUtil sessionUtil = new SessionUtil(session);
		Users user = sessionUtil.getUserFromSession();
		if(user == null) {
			return_hashmap.put("result", 0);
		} else {
			//从线程里抹除用户
			sessionUtil.removeUserFromSession();
			return_hashmap.put("result", 1);
		}
		
		return return_hashmap;
	}
	
	/**
	 * Ajax 判断用户登录态
	 * @param json
	 * @param model
	 * @return 0 = 未登录，1 = 已登录
	 */
	@RequestMapping(value = "/ajax/is_login")
	@ResponseBody
	public HashMap<String, Object> is_login_ajax(@RequestBody HashMap<String, Object> json, Model model) {
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		SessionUtil sessionUtil = new SessionUtil(session);
		Users user = sessionUtil.getUserFromSession();
		if(user == null) {
			return_hashmap.put("result", 0);
		} else {
			return_hashmap.put("result", 1);
		}
		
		return return_hashmap;
	}
}
