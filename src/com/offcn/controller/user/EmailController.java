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
import com.offcn.service.EmailService;
import com.offcn.service.UsersService;

/**
 * 邮件控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/email")
public class EmailController {
	@Autowired
	private UsersService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 检测邮箱地址有没有被注册
	 * @param json
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajax/check")
	@ResponseBody
	public HashMap<String, Object> email_check(@RequestBody HashMap<String, Object> json, Model model) {
		String email = (String) json.get("email");
		
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		if(this.userService.findUserByEmail(email) == null) {
			return_hashmap.put("result", 0);
		} else {
			return_hashmap.put("result", 1);
		}
		
		return return_hashmap;
	}
	
	/**
	 * Ajax 发送邮件
	 * @param json
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajax/send")
	@ResponseBody
	public HashMap<String, Object> send(@RequestBody HashMap<String, Object> json, Model model) {
		String email = (String) json.get("email");
		
		HashMap<String, Object> return_hashmap = new HashMap<String, Object>();
		Users user = this.userService.findUserByEmail(email);
		if(user == null) {
			return_hashmap.put("result", 0);
		} else {
			this.emailService.sendVerifyEmail(user);
			return_hashmap.put("result", 1);
		}
		
		return return_hashmap;
	}
	
}
