package com.offcn.service;

import java.util.List;

import com.offcn.pojo.ItemCategories;

/**
 * 商品分类服务类
 * @author Administrator
 *
 */
public interface ItemCategoryService {
	/**
	 * 获取所有商品分类
	 * @return
	 */
	public abstract List<ItemCategories> queryAllItemCategories();
}
