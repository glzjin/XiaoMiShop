package com.offcn.service;

import com.offcn.pojo.Users;

/**
 * 用户服务类
 * @author Administrator
 *
 */
public interface UsersService {
	//用户状态
	public static byte USER_AUTH_STATUS_UNAUTH = 0;
	public static byte USER_AUTH_STATUS_AUTHED = 1;
	
	//用户角色
	public static byte USER_ROLE_ADMIN = 1;
	public static byte USER_ROLE_NORMAL = 2;
	
	/**
	 * 以Email搜索用户
	 * @param email
	 * @return
	 */
	public abstract Users findUserByEmail(String email);
	
	/**
	 * 注册用户
	 * @param email
	 * @param password
	 * @param username
	 */
	public abstract void regUser(String email, String password, String username); 
	
	/**
	 * 获取用户邮箱验证 token
	 * @param email
	 * @param t
	 * @return
	 */
	public abstract String getUserVerifyToken(String email, long t);
	
	/**
	 * 验证用户邮箱验证token
	 * @param email
	 * @param t
	 * @param token
	 * @return
	 */
	public abstract Boolean verifyUserVerifyToken(String email, long t, String token);
	
	/**
	 * 更新用户
	 * @param user
	 */
	public abstract void updateUser(Users user);
	
	/**
	 * 用户登录
	 * @param email
	 * @param password
	 * @return
	 */
	public abstract Users userLogin(String email, String password);
}
