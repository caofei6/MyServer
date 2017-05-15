package com.weixiu.model;


public class StoreInfo {
	private String StoreID;
	private String StoreAttentionNum;
	private String StoreReservationNum;
	private String StoreGrade;
	private String StoreInformation;

	public StoreInfo() {

	}

	public StoreInfo(String storeID, String storeAttentionNum, String storeReservationNum, String storeGrade,
			String storeInformation) {
		super();
		StoreID = storeID;
		StoreAttentionNum = storeAttentionNum;
		StoreReservationNum = storeReservationNum;
		StoreGrade = storeGrade;
		StoreInformation = storeInformation;
	}

	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	public String getStoreAttentionNum() {
		return StoreAttentionNum;
	}

	public void setStoreAttentionNum(String storeAttentionNum) {
		StoreAttentionNum = storeAttentionNum;
	}

	public String getStoreReservationNum() {
		return StoreReservationNum;
	}

	public void setStoreReservationNum(String storeReservationNum) {
		StoreReservationNum = storeReservationNum;
	}

	public String getStoreGrade() {
		return StoreGrade;
	}

	public void setStoreGrade(String storeGrade) {
		StoreGrade = storeGrade;
	}

	public String getStoreInformation() {
		return StoreInformation;
	}

	public void setStoreInformation(String storeInformation) {
		StoreInformation = storeInformation;
	}

	@Override
	public String toString() {
		return "StoreInfo [StoreID=" + StoreID + ", StoreAttentionNum=" + StoreAttentionNum + ", StoreReservationNum="
				+ StoreReservationNum + ", StoreGrade=" + StoreGrade + ", StoreInformation=" + StoreInformation + "]";
	}

}
