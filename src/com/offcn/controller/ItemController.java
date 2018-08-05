package com.offcn.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.ItemsWithBLOBs;
import com.offcn.service.ItemService;

/**
 * 公共部分，商品展示器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * ajax 拉分类里的商品
	 * @param json 里带着分类
	 * @return ajax 格式的商品信息
	 */
	@RequestMapping("/ajax/category/list")
	@ResponseBody
	public List<ItemsWithBLOBs> ajaxCategoryList(@RequestBody HashMap<String, Object> json) {
		int category_id = (Integer) json.get("category_id");
		
		return this.itemService.queryAllItemsByCategoryId(category_id);
	}
	
	/**
	 * 单个商品详情页
	 * @param 商品ID
	 */
	@RequestMapping("/detail")
	public String itemList(int item_id, Model model) {
		model.addAttribute("item_id", item_id);
		return "public/detail";
	}
	
	/**
	 * ajax 拉单个商品详情
	 * @param json 里带着商品ID
	 * @return ajax 格式的商品信息
	 */
	@RequestMapping("/ajax/detail")
	@ResponseBody
	public ItemsWithBLOBs ajaxItemList(@RequestBody HashMap<String, Object> json) {
		int item_id = (Integer) json.get("item_id");
		return this.itemService.getItemById(item_id);
	}
}
