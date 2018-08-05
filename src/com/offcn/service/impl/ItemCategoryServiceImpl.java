package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.ItemCategoriesMapper;
import com.offcn.pojo.ItemCategories;
import com.offcn.pojo.ItemCategoriesExample;
import com.offcn.service.ItemCategoryService;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

	@Autowired
	private ItemCategoriesMapper itemCategoriesMapper;
	
	@Override
	public List<ItemCategories> queryAllItemCategories() {
		ItemCategoriesExample example = new ItemCategoriesExample();
		example.setOrderByClause("sort");//排个顺序
		return itemCategoriesMapper.selectByExample(example);
	}

}
