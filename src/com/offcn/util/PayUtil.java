package com.offcn.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import com.offcn.pojo.PayInfo;

/**
 * 支付工具类
 * @author Administrator
 *
 */
public class PayUtil {
	
	private ConfigUtil payConfig;

	public PayUtil() throws IOException {
		payConfig = new ConfigUtil("pay");
	}
	
	/**
	 * 创建支付请求
	 * @return 
	 * @throws IOException
	 */
	public PayInfo createPay(double amount, String pay_method) throws IOException {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("AppId", this.payConfig.getConfig("app_id"));
		//为了简便就直接构造 json
		Map<String, Object> response = RequestUtil.sendPost("https://accounts.extstars.com/api/v2/donation/create", "{\"device_id\":\"web\", \"amount\":" + amount + ", \"pay_method\":\"" + pay_method + "\"}", headers);
		
		//获取子数据 Map
		Map<String, Object> data = (Map<String, Object>)response.get("data");
		//构造返回的支付信息
		PayInfo pay_info = new PayInfo();
		pay_info.setOrderId((Integer)data.get("order_id"));
		pay_info.setOrderCheckToken((String)data.get("order_check_token"));
		pay_info.setLink((String)data.get("link"));
		pay_info.setQrcode((String)data.get("qrcode"));
		pay_info.setTips((String)data.get("tips"));
		pay_info.setCheckUrl((String)data.get("check_url"));
		return pay_info;
	}
	
	/**
	 * 检测支付状态
	 * @param pay_info
	 * @return
	 * @throws IOException
	 */
	public Boolean checkPay(PayInfo pay_info) throws IOException {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("AppId", this.payConfig.getConfig("app_id"));
		//为了简便就直接构造 json
		Map<String, Object> response = RequestUtil.sendPost("https://accounts.extstars.com/api/v2/order/check", "{\"order_id\": \"" + pay_info.getOrderId() + "\", \"order_check_token\":\"" + pay_info.getOrderCheckToken() + "\"}", headers);
		//获取支付状态
		Integer is_paid = (Integer)((Map<String, Object>)response.get("data")).get("is_paid");
		return is_paid == 1;
	}
	
	/**
	 * 测试方法
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		PayUtil pay_ins = new PayUtil();
		PayInfo pay_info = pay_ins.createPay(0.01, "alipay");
		System.out.println(pay_info);
		System.out.println(checkPay(pay_info));
	}
}
