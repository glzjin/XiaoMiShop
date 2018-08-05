package com.offcn.pojo;

/**
 * 支付信息类
 * @author Administrator
 *
 */
public class PayInfo {
	private int orderId;
	private String orderCheckToken;
	private String qrcode;
	private String checkUrl;
	private String link;
	private String tips;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderCheckToken() {
		return orderCheckToken;
	}
	public void setOrderCheckToken(String orderCheckToken) {
		this.orderCheckToken = orderCheckToken;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getCheckUrl() {
		return checkUrl;
	}
	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "PayInfo [orderId=" + orderId + ", orderCheckToken="
				+ orderCheckToken + ", qrcode=" + qrcode + ", checkUrl="
				+ checkUrl + ", link=" + link + ", tips=" + tips + "]";
	}
	
	
	
}
