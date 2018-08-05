package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.ItemsMapper;
import com.offcn.pojo.Items;
import com.offcn.pojo.ItemsExample;
import com.offcn.pojo.ItemsWithBLOBs;
import com.offcn.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsWithBLOBs> queryAllItemsByCategoryId(int category_id) {
		ItemsExample example = new ItemsExample();
		example.createCriteria().andItemCategoryIdEqualTo(category_id).andStatusEqualTo(Byte.valueOf("1"));
		return this.itemsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public ItemsWithBLOBs getItemById(int item_id) {
		return this.itemsMapper.selectByPrimaryKey(item_id);
	}

	@Override
	public void updateItemById(Items item) {
		this.itemsMapper.updateByPrimaryKey(item);
	}

}
