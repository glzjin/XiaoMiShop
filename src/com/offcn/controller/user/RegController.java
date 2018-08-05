package com.offcn.controller.user;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.service.UsersService;

/**
 * 注册控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/reg")
public class RegController {
	@Autowired
	private UsersService userService;

	/**
	 * 展示用户注册页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "")
	public String hello(Model model) {
		return "reg/index";
	}
	
	/**
	 * 进行用户验证操作，并跳转展示验证结果
	 * @param email
	 * @param t 时间戳
	 * @param token
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/verify")
	public String verify(@RequestParam("email")String email, 
						@RequestParam("t")String t,
						@RequestParam("token")String token,
						Model model) {
		//验证
		if(this.userService.verifyUserVerifyToken(email, Long.valueOf(t), token)) {
			model.addAttribute("Msg", "验证完成，您现在可以登录了！");
		} else {
			model.addAttribute("Msg", "验证失败，悟空别闹！");
		}
		return "reg/msg";
	}
	
	/**
	 * Ajax 进行注册操作
	 * @param json
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajax")
	@ResponseBody
	public HashMap<String, Object> reg(@RequestBody HashMap<String, Object> json, Model model) {
		String email = (String) json.get("email");
		String password = (String) json.get("password");
		String username = (String) json.get("username");
		
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		try {
			this.userService.regUser(email, password, username);
			return_hashmap.put("result", 1);
		} catch (Exception e){
			return_hashmap.put("result", 0);
		}
		
		return return_hashmap;
	}
}
