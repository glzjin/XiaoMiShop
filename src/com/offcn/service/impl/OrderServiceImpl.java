package com.offcn.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.offcn.mapper.OrdersMapper;
import com.offcn.pojo.CartInfos;
import com.offcn.pojo.ItemsWithBLOBs;
import com.offcn.pojo.OrderItems;
import com.offcn.pojo.Orders;
import com.offcn.pojo.OrdersExample;
import com.offcn.pojo.UserAddresses;
import com.offcn.pojo.Users;
import com.offcn.service.AddressService;
import com.offcn.service.CartService;
import com.offcn.service.ItemService;
import com.offcn.service.OrderItemService;
import com.offcn.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private AddressService addressService;
	
	@Override
	public int insertOrder(Orders order) {
		return this.ordersMapper.insert(order);
	}

	@Override
	@Transactional
	public int putOrder(Users current_user, UserAddresses address, List<Integer> selected_item_list) {
		List<CartInfos> cart_list = this.cartService.getCartInfosByUserId(current_user.getId());
		
		//订单总价
		Double total_price = 0.0;
		
		//订单列表
		ArrayList<OrderItems> order_item_list = new ArrayList<OrderItems>();
		
		for (CartInfos cart_info : cart_list) {
			//没选中的就不要下单
			if(!selected_item_list.contains(cart_info.getItemId())) {
				continue;
			}
			
			ItemsWithBLOBs item = itemService.getItemById(cart_info.getItemId());
			
			//库存判断与处理，和前端统一
			if(item.getItemSku() == 0) {
				continue;
			}
			
			if(item.getItemSku() < cart_info.getItemAmount()) {
				cart_info.setItemAmount(item.getItemSku());
			}
			
			//创建分单
			OrderItems order_item = new OrderItems();
			order_item.setItemAmount(cart_info.getItemAmount());
			order_item.setItemCurrentPrice(item.getItemPrice());
			order_item.setItemId(item.getId());
			//不直接插入而是先存 List 是为了先计算订单总价
			order_item_list.add(order_item);
			//计算总价
			total_price += cart_info.getItemAmount() * item.getItemPrice().doubleValue();
			
			//变动商品库存和销量
			item.setItemSold(item.getItemSold() + cart_info.getItemAmount());
			item.setItemSku(item.getItemSku() - cart_info.getItemAmount());
			this.itemService.updateItemById(item);
		}
		
		//下总单
		Orders order = new Orders();
		order.setDatetime(new Date());
		order.setPrice(new BigDecimal(total_price));
		order.setStatus(OrderService.STATUS_ORDER_UNPAID);
		order.setUserId(current_user.getId());
		order.setUserRealName(address.getUserRealName());
		order.setUserPhone(address.getUserPhone());
		order.setUserAddress(address.getUserAddress());
		this.insertOrder(order);
		//获取订单 ID
		int order_id = order.getId();
		
		//下分单
		for (OrderItems order_item : order_item_list) {
			order_item.setOrderId(order_id);
			this.orderItemService.insertOrderItem(order_item);
		}
		
		return order_id;
	}

	@Override
	public List<Orders> getOrdersByUserId(int user_id) {
		OrdersExample example = new OrdersExample();
		example.createCriteria().andUserIdEqualTo(user_id);
		return this.ordersMapper.selectByExample(example);
	}

	@Override
	public Boolean isOrderByUser(int order_id, int user_id) {
		Orders order = this.ordersMapper.selectByPrimaryKey(order_id);
		if(order.getUserId() == user_id) {
			return true;
		}
		
		return false;
	}

	@Override
	public Orders getOrderById(int order_id) {
		return this.ordersMapper.selectByPrimaryKey(order_id);
	}

	@Override
	public void updateOrderById(Orders order) {
		this.ordersMapper.updateByPrimaryKey(order);
	}

}
