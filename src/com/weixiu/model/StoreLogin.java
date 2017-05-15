package com.weixiu.model;

public class StoreLogin {
	private String StoreID;
	private String StorePhone;
	private String StorePasswd;
	private String StoreStat;

	public StoreLogin() {

	}

	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	public String getStorePhone() {
		return StorePhone;
	}

	public void setStorePhone(String storePhone) {
		StorePhone = storePhone;
	}

	public String getStorePasswd() {
		return StorePasswd;
	}

	public void setStorePasswd(String storePasswd) {
		StorePasswd = storePasswd;
	}

	public String getStoreStat() {
		return StoreStat;
	}

	public void setStoreStat(String storeStat) {
		StoreStat = storeStat;
	}

	@Override
	public String toString() {
		return "StoreLogin [StoreID=" + StoreID + ", StorePhone=" + StorePhone + ", StorePasswd=" + StorePasswd
				+ ", StoreStat=" + StoreStat + "]";
	}
	

}
