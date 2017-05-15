package com.weixiu.model;

public class Order {
	private Boolean isRequest;
	private String orderId;
	private String orderName;
	private String orderAddress;
	private String orderType;
	private String orderPhone;
	private String orderLatitude;
	private String orderLongitude;

	public Order() {

	}

	public Order(String orderId, String orderName, String orderAddress, String orderType, String orderPhone,
			String orderLatitude, String orderLongitude) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderType = orderType;
		this.orderPhone = orderPhone;
		this.orderLatitude = orderLatitude;
		this.orderLongitude = orderLongitude;
	}
	
	

	public Boolean getIsRequest() {
		return isRequest;
	}

	public void setIsRequest(Boolean isRequest) {
		this.isRequest = isRequest;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderLatitude() {
		return orderLatitude;
	}

	public void setOrderLatitude(String orderLatitude) {
		this.orderLatitude = orderLatitude;
	}

	public String getOrderLongitude() {
		return orderLongitude;
	}

	public void setOrderLongitude(String orderLongitude) {
		this.orderLongitude = orderLongitude;
	}

}
