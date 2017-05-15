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
import com.weixiu.model.Comment;
import com.weixiu.model.Message;

public class SelectCommentAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2046103566432879183L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private String StoreID;

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
		
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	
	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	public void getComment() {
		
		List<Comment> commentList = null;
		
		try {
			Gson gson = new Gson();
			Message mess = new Message();
			String res = null;
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			System.out.println("--------------------------------------------------");
			if (StoreID == null || StoreID.equals("")) {
				mess.setIsRequest(false);
				mess.setMessage("StoreID is empty!");
				res = gson.toJson(mess);
			}else{
				commentList = Select.getCommentByStoreID(StoreID);
				if(commentList.size() == 0){
					mess.setIsRequest(false);
					mess.setMessage("StoreID:" + StoreID + " Comments is null");
					res = gson.toJson(mess);
				}else{
					res = gson.toJson(commentList);
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