package com.offcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * @author Administrator
 *
 */
@Controller
public class IndexController {
	
	/**
	 * 展示首页
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "public/index";
	}

}
