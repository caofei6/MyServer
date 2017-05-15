package com.weixiu.model;

public class Message {
	private Boolean isLogin;
	private Boolean isRegister;
	private Boolean isUpdateStore;
	private Boolean isUnRegister;
	private Boolean isUpatePassword;
	private Boolean isRequest;
	private String StoreID;
	private String message;
	
	

	public Boolean getIsUpatePassword() {
		return isUpatePassword;
	}
	public void setIsUpatePassword(Boolean isUpatePassword) {
		this.isUpatePassword = isUpatePassword;
	}
	public Boolean getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}
	public Boolean getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}
	public Boolean getIsUpdateStore() {
		return isUpdateStore;
	}
	public void setIsUpdateStore(Boolean isUpdateStore) {
		this.isUpdateStore = isUpdateStore;
	}
	public Boolean getIsUnRegister() {
		return isUnRegister;
	}
	public void setIsUnRegister(Boolean isUnRegister) {
		this.isUnRegister = isUnRegister;
	}
	public String getStoreID() {
		return StoreID;
	}
	public void setStoreID(String storeID) {
		StoreID = storeID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getIsRequest() {
		return isRequest;
	}
	public void setIsRequest(Boolean isRequest) {
		this.isRequest = isRequest;
	}
	
	
	
	
}
