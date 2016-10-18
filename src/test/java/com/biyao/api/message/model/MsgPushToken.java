package com.biyao.api.message.model;

import java.io.Serializable;

public class MsgPushToken implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int platform;
	private String customerId;
	// 为空则表示用户是否已经退出登录
	private String pushToken = "";
	private boolean orderPush = true;
	private boolean openPush = true;
	private int mobileType;
	public int getPlatform() {
		return platform;
	}
	public void setPlatform(int platform) {
		this.platform = platform;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPushToken() {
		return pushToken;
	}
	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}
	public boolean isOrderPush() {
		return orderPush;
	}
	public void setOrderPush(boolean orderPush) {
		this.orderPush = orderPush;
	}
	public boolean isOpenPush() {
		return openPush;
	}
	public void setOpenPush(boolean openPush) {
		this.openPush = openPush;
	}
	public int getMobileType() {
		return mobileType;
	}
	public void setMobileType(int mobileType) {
		this.mobileType = mobileType;
	}
	
}
