package com.weixiu.model;

public class StoreAllInfor {
	
	public Boolean isLogin;
	public Store store;
	public StoreInfo storeInfo;
	
	public StoreAllInfor(){
		
	}
	
	
	public StoreAllInfor(Store store, StoreInfo storeInfo) {
		super();
		this.store = store;
		this.storeInfo = storeInfo;
	}
	
	
	public Boolean getIsLogin() {
		return isLogin;
	}


	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}


	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public StoreInfo getStoreInfo() {
		return storeInfo;
	}
	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	
	@Override
	public String toString() {
		return "StoreAllInfor [store=" + store + ", storeInfo=" + storeInfo + "]";
	}
}
