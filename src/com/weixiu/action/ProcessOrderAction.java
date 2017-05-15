package com.weixiu.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.weixiu.jdbc.Update;
import com.weixiu.model.Message;

public class ProcessOrderAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2046103566432879183L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private String StoreID;
	private String OrderID;
	private String Status;
	private String AcceptTime;
	
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
		
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}
	
	
	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public String getAcceptTime() {
		return AcceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		AcceptTime = acceptTime;
	}

	/***
	 * [1:接受订单][2:拒绝订单][3:完成订单]
	 */
	public void order() {
		
		try {
			Gson gson = new Gson();
			Message mess = new Message();
			String res = null;
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			System.out.println("--------------------------------------------------");
			if(Status.equals("1")){
				Status = "正在处理";
			}else if(Status.equals("2")){
				Status = "未解决";
			}else if(Status.equals("3")){
				Status = "已解决";
			}
			Boolean isRequest = Update.updateOrderStatus(OrderID, Status);
			if(!isRequest){
				mess.setIsRequest(isRequest);
				mess.setMessage("StoreID:" + StoreID + "order was update status failed");
			}else{
				mess.setIsRequest(isRequest);
				mess.setMessage("StoreID:" + StoreID + "order was update status Succeed");
			}
			res = gson.toJson(mess);
			this.response.getWriter().write(res);
			System.out.println(res);
			System.out.println("--------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
