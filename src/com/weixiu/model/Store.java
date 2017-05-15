package com.weixiu.model;

public class Store {

	private String StoreID;
	private String StoreName;
	private String StorePersonName;
	private String StoreImage;
	private String StoreContactInfor;
	private String StoreType;
	private String StoreAddress;
	private String StoreLatitude;
	private String StoreLongitude;

	public Store() {

	}

	public Store(String storeID, String storeName, String storePersonName, String storeImage, String storeContactInfor,
			String storeType, String storeAddress, String storeLatitude, String storeLongitude) {
		super();
		StoreID = storeID;
		StoreName = storeName;
		StorePersonName = storePersonName;
		StoreImage = storeImage;
		StoreContactInfor = storeContactInfor;
		StoreType = storeType;
		StoreAddress = storeAddress;
		StoreLatitude = storeLatitude;
		StoreLongitude = storeLongitude;
	}

	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String getStorePersonName() {
		return StorePersonName;
	}

	public void setStorePersonName(String storePersonName) {
		StorePersonName = storePersonName;
	}

	public String getStoreImage() {
		return StoreImage;
	}

	public void setStoreImage(String storeImage) {
		StoreImage = storeImage;
	}

	public String getStoreContactInfor() {
		return StoreContactInfor;
	}

	public void setStoreContactInfor(String storeContactInfor) {
		StoreContactInfor = storeContactInfor;
	}

	public String getStoreType() {
		return StoreType;
	}

	public void setStoreType(String storeType) {
		StoreType = storeType;
	}

	public String getStoreAddress() {
		return StoreAddress;
	}

	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}

	public String getStoreLatitude() {
		return StoreLatitude;
	}

	public void setStoreLatitude(String storeLatitude) {
		StoreLatitude = storeLatitude;
	}

	public String getStoreLongitude() {
		return StoreLongitude;
	}

	public void setStoreLongitude(String storeLongitude) {
		StoreLongitude = storeLongitude;
	}

	@Override
	public String toString() {
		return "Store [StoreID=" + StoreID + ", StoreName=" + StoreName + ", StorePersonName=" + StorePersonName
				+ ", StoreImage=" + StoreImage + ", StoreContactInfor=" + StoreContactInfor + ", StoreType=" + StoreType
				+ ", StoreAddress=" + StoreAddress + ", StoreLatitude=" + StoreLatitude + ", StoreLongitude="
				+ StoreLongitude + "]";
	}

}
