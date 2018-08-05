package com.offcn.service;

import java.util.List;

import com.offcn.pojo.OrderItems;

/**
 * 订单商品服务类
 * @author Administrator
 *
 */
public interface OrderItemService {
	/**
	 * 插入订单里的商品，用于记录商品里有什么商品
	 * @param item
	 */
	public abstract void insertOrderItem(OrderItems item);
	
	/**
	 * 以订单ID为依据获取订单商品
	 * @param order_id
	 * @return
	 */
	public abstract List<OrderItems> getOrderItemByOrderId(int order_id);
}
