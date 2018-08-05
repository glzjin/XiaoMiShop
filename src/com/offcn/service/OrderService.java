package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Orders;
import com.offcn.pojo.UserAddresses;
import com.offcn.pojo.Users;

/**
 * 订单服务类
 * @author Administrator
 *
 */
public interface OrderService {

	//两种订单状态
	public static final byte STATUS_ORDER_UNPAID = 0;
	public static final byte STATUS_ORDER_PAID = 1;
	
	/**
	 * 新增订单
	 * @param order
	 * @return
	 */
	public abstract int insertOrder(Orders order);
	
	/**
	 * 综合新增订单
	 * @param current_user
	 * @param address
	 * @param selected_item_list
	 * @return
	 */
	public abstract int putOrder(Users current_user, UserAddresses address, List<Integer> selected_item_list);
	
	/**
	 * 以用户ID为依据获取用户订单
	 * @param user_id
	 * @return
	 */
	public abstract List<Orders> getOrdersByUserId(int user_id);
	
	/**
	 * 判断订单是否归属该用户
	 * @param order_id
	 * @param user_id
	 * @return
	 */
	public abstract Boolean isOrderByUser(int order_id, int user_id);
	
	/**
	 * 根据订单ID获取订单
	 * @param order_id
	 * @return
	 */
	public abstract Orders getOrderById(int order_id);
	
	/**
	 * 以订单ID为依据更新订单
	 */
	public abstract void updateOrderById(Orders order);
}
