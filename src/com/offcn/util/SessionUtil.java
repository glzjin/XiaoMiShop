package com.offcn.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.offcn.pojo.PayInfo;
import com.offcn.pojo.Users;

/**
 * 线程工具类
 * @author Administrator
 *
 */
public class SessionUtil {
	private HttpSession session;
	
	/**
	 * 构造方法，把当前的线程传入
	 * @param session
	 */
	public SessionUtil(HttpSession session) {
		super();
		this.session = session;
	}

	/**
	 * 把用户存入线程
	 * @param user
	 */
	public void setUserToSession(Users user) {
		session.setAttribute("user", user);
	}
	
	/**
	 * 从线程里拉取用户
	 * @return
	 */
	public Users getUserFromSession() {
		return (Users) session.getAttribute("user");
	}
	
	/**
	 * 从线程里移除用户
	 */
	public void removeUserFromSession() {
		session.removeAttribute("user");
	}
	
	/**
	 * 把用户的结算清单放到线程
	 * @param checkout_list
	 */
	public void setUserCheckoutListToSession(ArrayList<Integer> checkout_list) {
		session.setAttribute("checkout_list", checkout_list);
	}
	
	/**
	 * 从线程里拉取用户的结算清单
	 * @return
	 */
	public List<Integer> getUserCheckoutListFromSession() {
		return (List<Integer>) session.getAttribute("checkout_list");
	}
	
	/**
	 * 从线程里移除用户的结算清单
	 */
	public void removeUserCheckoutListFromSession() {
		session.removeAttribute("checkout_list");
	}
	
	/**
	 * 在线程里存订单的支付信息
	 */
	public void setPayInfoToSession(int order_id, PayInfo pay_info) {
		session.setAttribute("pay_info_" + order_id, pay_info);
	}
	
	/**
	 * 从线程里拉取订单的支付信息
	 */
	public PayInfo getPayInfoToSession(int order_id) {
		return (PayInfo) session.getAttribute("pay_info_" + order_id);
	}
	
	/**
	 * 从线程里移除订单的支付信息
	 */
	public void removePayInfoFromSession(int order_id) {
		session.removeAttribute("pay_info_" + order_id);
	}
}
