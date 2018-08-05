package com.offcn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.ItemCategories;
import com.offcn.service.ItemCategoryService;

/**
 * 公共部分分类展示页
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item/category")
public class ItemCategoryController {
	
	@Autowired
	private ItemCategoryService itemCategoryService;
	
	/**
	 * Ajax 展示分类列表
	 * @return json 格式的分类信息
	 */
	@RequestMapping("/ajax/list")
	@ResponseBody
	public List<ItemCategories> categoryList() {
		return itemCategoryService.queryAllItemCategories();
	}
}
