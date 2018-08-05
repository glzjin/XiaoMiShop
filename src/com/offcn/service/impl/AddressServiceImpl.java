package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.UserAddressesMapper;
import com.offcn.pojo.UserAddresses;
import com.offcn.pojo.UserAddressesExample;
import com.offcn.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private UserAddressesMapper userAddressesMapper;

	@Override
	public List<UserAddresses> queryAllAddressByUser(int user_id) {
		UserAddressesExample example = new UserAddressesExample();
		example.createCriteria().andUserIdEqualTo(user_id);
		return this.userAddressesMapper.selectByExample(example);
	}

	@Override
	public void addAddressByUser(UserAddresses address) {
		this.userAddressesMapper.insert(address);
	}

	@Override
	public void updateAddressByUser(UserAddresses address) {
		this.userAddressesMapper.updateByPrimaryKey(address);
	}

	@Override
	public Boolean isAddressByUser(UserAddresses address, int user_id) {
		UserAddresses get_address = this.userAddressesMapper.selectByPrimaryKey(address.getId());
		return get_address.getUserId() == user_id;
	}

	@Override
	public void deleteAddressById(UserAddresses address) {
		this.userAddressesMapper.deleteByPrimaryKey(address.getId());	
	}

	@Override
	public UserAddresses getAddressByUserAndAddressId(int address_id,
			int user_id) {
		UserAddressesExample example = new UserAddressesExample();
		example.createCriteria().andUserIdEqualTo(user_id).andIdEqualTo(address_id);
		List<UserAddresses> list = this.userAddressesMapper.selectByExample(example);
		if(list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
