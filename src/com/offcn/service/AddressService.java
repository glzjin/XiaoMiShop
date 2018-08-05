package com.offcn.service;

import java.util.List;

import com.offcn.pojo.UserAddresses;

/**
 * 地址服务类
 * @author Administrator
 *
 */
public interface AddressService {
	/**
	 * 获取该用户所有地址
	 * @param user_id
	 * @return
	 */
	public abstract List<UserAddresses> queryAllAddressByUser(int user_id);
	
	/**
	 * 以用户为依据添加地址
	 * @param address
	 */
	public abstract void addAddressByUser(UserAddresses address);
	
	/**
	 * 以用户为依据更新地址
	 * @param address
	 */
	public abstract void updateAddressByUser(UserAddresses address);
	
	/**
	 * 以用户为依据判断该地址是否属于该用户
	 * @param address
	 */
	public abstract Boolean isAddressByUser(UserAddresses address, int user_id);
	
	/**
	 * 以地址ID为依据删除地址
	 * @param address
	 */
	public abstract void deleteAddressById(UserAddresses address);
	
	/**
	 * 以用户和地址信息为依据添加地址
	 * @param address
	 */
	public abstract UserAddresses getAddressByUserAndAddressId(int address_id, int user_id);
}
