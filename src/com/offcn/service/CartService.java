package com.offcn.service;

import java.util.List;

import com.offcn.pojo.CartInfos;

/**
 * 购物车服务类
 * @author Administrator
 *
 */
public interface CartService {
	/**
	 * 以用户ID为依据获取购物车信息
	 * @param user_id
	 * @return
	 */
	public abstract List<CartInfos> getCartInfosByUserId(int user_id);
	
	/**
	 * 添加商品到用户购物车
	 * @param user_id
	 * @param item_id
	 */
	public abstract void addItemToUserCart(int user_id, int item_id);
	
	/**
	 * 判断商品是否在用户的购物车里
	 * @param user_id
	 * @param item_id
	 * @return
	 */
	public abstract Boolean isItemCartByUser(int user_id, int item_id);
	
	/**
	 * 从用户购物车里删除信息
	 * @param user_id
	 * @param item_id
	 */
	public abstract void deleteItemCartByUser(int user_id, int item_id);
	
	/**
	 * 修改用户购物车里的商品数量
	 * @param user_id
	 * @param item_id
	 * @param is_add
	 */
	public abstract void modifyItemCartByUser(int user_id, int item_id, Boolean is_add);
}
