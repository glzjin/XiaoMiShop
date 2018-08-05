package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Items;
import com.offcn.pojo.ItemsWithBLOBs;

/**
 * 商品服务类
 * @author Administrator
 *
 */
public interface ItemService {
	/**
	 * 获取该分类里的所有商品
	 * @param category_id
	 * @return
	 */
	public abstract List<ItemsWithBLOBs> queryAllItemsByCategoryId(int category_id);
	
	/**
	 * 以商品ID获取商品
	 * @param item_id
	 * @return
	 */
	public abstract ItemsWithBLOBs getItemById(int item_id);
	
	/**
	 * 以商品ID更新商品信息
	 * @param item
	 */
	public abstract void updateItemById(Items item);
}
