package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.CartInfosMapper;
import com.offcn.pojo.CartInfos;
import com.offcn.pojo.CartInfosExample;
import com.offcn.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartInfosMapper cartInfosMapper;
	
	@Override
	public List<CartInfos> getCartInfosByUserId(int user_id) {
		CartInfosExample example = new CartInfosExample();
		example.createCriteria().andUserIdEqualTo(user_id);
		return this.cartInfosMapper.selectByExample(example);
	}

	@Override
	public void addItemToUserCart(int user_id, int item_id) {
		CartInfos cart_info = new CartInfos();
		cart_info.setItemId(item_id);
		cart_info.setUserId(user_id);
		cart_info.setItemAmount(1);
		this.cartInfosMapper.insert(cart_info);
	}

	@Override
	public Boolean isItemCartByUser(int user_id, int item_id) {
		CartInfosExample example = new CartInfosExample();
		example.createCriteria().andUserIdEqualTo(user_id).andItemIdEqualTo(item_id);
		if(this.cartInfosMapper.selectByExample(example).size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void deleteItemCartByUser(int user_id, int item_id) {
		CartInfosExample example = new CartInfosExample();
		example.createCriteria().andUserIdEqualTo(user_id).andItemIdEqualTo(item_id);
		if(this.cartInfosMapper.selectByExample(example).size() > 0) {
			this.cartInfosMapper.deleteByExample(example);
		}
	}

	@Override
	public void modifyItemCartByUser(int user_id, int item_id, Boolean is_add) {
		// TODO Auto-generated method stub
		//查找已有记录
		CartInfosExample example = new CartInfosExample();
		example.createCriteria().andUserIdEqualTo(user_id).andItemIdEqualTo(item_id);
		List<CartInfos> result_list = this.cartInfosMapper.selectByExample(example);
		if(result_list.size() > 0) {
			CartInfos cart_info = result_list.get(0);
			//判断是增加还是减少
			if(is_add) {
				cart_info.setItemAmount(cart_info.getItemAmount() + 1);
				
				this.cartInfosMapper.updateByPrimaryKey(cart_info);
			} else {
				//如果到1了就直接删了吧
				if(cart_info.getItemAmount() == 1) {
					this.cartInfosMapper.deleteByExample(example);
				} else {
					cart_info.setItemAmount(cart_info.getItemAmount() - 1);
					
					this.cartInfosMapper.updateByPrimaryKey(cart_info);
				}
			}
		}
	}

}
