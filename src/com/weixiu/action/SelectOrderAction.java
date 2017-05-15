package com.weixiu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.weixiu.jdbc.Select;
import com.weixiu.model.Message;
import com.weixiu.model.Order;

public class SelectOrderAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2046103566432879183L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private String StoreID;
	private String Status;

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
	/***
	 * [0: 所有订单][1：未解决][2：已解决][3：正在处理]
	 */
	public void order() {
		
		List<Order> orderList = null;
		
		try {
			Gson gson = new Gson();
			Message mess = new Message();
			String res = null;
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			System.out.println("--------------------------------------------------");
			if (StoreID == null || Status == null || Status.equals("") || StoreID.equals("")) {
				mess.setIsRequest(false);
				mess.setMessage("StoreID or Status is empty!");
				res = gson.toJson(mess);
			}else{
				if(Status.equals("1")){
					Status = "未解决";
				}else if(Status.equals("2")){
					Status = "已解决";
				}else if(Status.equals("3")){
					Status = "正在处理";
				}
				orderList = Select.getOrder(StoreID, Status);
				System.out.println(orderList);
				if(orderList.size() == 0){
					mess.setIsRequest(false);
					mess.setMessage("StoreID:" + StoreID + "," + Status + "订单 is null");
					res = gson.toJson(mess);
				}else{
					res = gson.toJson(orderList);
				}
			}
			
			this.response.getWriter().write(res);
			System.out.println(res);
			System.out.println("--------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}