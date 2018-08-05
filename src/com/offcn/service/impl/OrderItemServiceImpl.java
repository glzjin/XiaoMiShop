package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.OrderItemsMapper;
import com.offcn.pojo.OrderItems;
import com.offcn.pojo.OrderItemsExample;
import com.offcn.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemsMapper orderItemsMapper;

	@Override
	public void insertOrderItem(OrderItems item) {
		this.orderItemsMapper.insert(item);
	}

	@Override
	public List<OrderItems> getOrderItemByOrderId(int order_id) {
		OrderItemsExample example = new OrderItemsExample();
		example.createCriteria().andOrderIdEqualTo(order_id);
		return this.orderItemsMapper.selectByExample(example);
	}

}
