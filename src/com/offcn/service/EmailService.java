package com.offcn.service;

import com.offcn.pojo.Users;

/**
 * 电子邮件服务，发送验证邮件之类的，做成服务是为了异步任务
 * @author Administrator
 *
 */
public interface EmailService {
	/**
	 * 发送验证邮件
	 */
	public void sendVerifyEmail(Users user);
}
