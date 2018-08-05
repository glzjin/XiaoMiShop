package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.UsersMapper;
import com.offcn.pojo.Users;
import com.offcn.pojo.UsersExample;
import com.offcn.service.UsersService;
import com.offcn.util.ConfigUtil;
import com.offcn.util.EncryptUtil;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public Users findUserByEmail(String email) {
		UsersExample example = new UsersExample();
		example.createCriteria().andEmailEqualTo(email);
		List<Users> result = this.usersMapper.selectByExample(example);
		if(result.size() == 0) {
			return null;
		}
		return this.usersMapper.selectByExample(example).get(0);
	}

	@Override
	public void regUser(String email, String password, String username) {
		Users user = new Users();
		user.setEmail(email);
		user.setUsername(username);
		try {
			user.setPassword(EncryptUtil.getMD5Str(password));//密码加密
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;//加密不了就告辞吧
		}
		user.setUserRoleType(UsersService.USER_ROLE_NORMAL);
		user.setIsEmailAuth(UsersService.USER_AUTH_STATUS_UNAUTH);
		this.usersMapper.insert(user);
	}

	@Override
	public String getUserVerifyToken(String email, long t) {
		try {
			//读配置文件
			ConfigUtil mailConfig = new ConfigUtil("mail");
			//获取配置文件里的随机串
			String random_key = mailConfig.getConfig("random_key");
			//MD5后返回
			return EncryptUtil.getMD5Str(email + t + random_key);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@Override
	public void updateUser(Users user) {
		this.usersMapper.updateByPrimaryKey(user);
	}
	
	@Override
	public Boolean verifyUserVerifyToken(String email, long t, String token) {
		try {
			Users user = this.findUserByEmail(email);
			if(user == null) {
				return false;
			}
			
			//判断状态
			if(!user.getIsEmailAuth().equals(UsersService.USER_AUTH_STATUS_UNAUTH)) {
				return false;
			}
			
			//校验时间
			long unixTime = System.currentTimeMillis() / 1000L;
			if(unixTime > t + 3600 * 3) {
				return false;
			}
			
			//验证 token 是否正确
			if(this.getUserVerifyToken(email, t).equals(token)) {
				//更新状态
				user.setIsEmailAuth(UsersService.USER_AUTH_STATUS_AUTHED);
				this.updateUser(user);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Users userLogin(String email, String password) {
		Users user = this.findUserByEmail(email);
		if(user == null) {
			return null;
		}
		
		try {
			if(!user.getPassword().equals(EncryptUtil.getMD5Str(password))) {//和加密后的密码比对
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;//加密不了就请回吧
		}
		
		return user;
	}
	
}
