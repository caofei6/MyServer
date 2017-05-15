package com.weixiu.action;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.weixiu.model.Message;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.weixiu.dao.Register;
import com.weixiu.jdbc.Select;

public class RegisterAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237297828546535456L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	public String StorePhone;
	public String StorePassword;

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;

	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String getStorePhone() {
		return StorePhone;
	}

	public void setStorePhone(String storePhone) {
		StorePhone = storePhone;
	}

	public String getStorePassword() {
		return StorePassword;
	}

	public void setStorePassword(String storePassword) {
		StorePassword = storePassword;
	}

	public void register() {
		
		try {
			Gson gson = new Gson();
			Message mess = new Message();
			String str = null;
			String res = null;
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			System.out.println("--------------------------------------------------");
			if (StorePhone == null || StorePassword == null || StorePhone.equals("") || StorePassword.equals("")) {
				str = "Username or password is empty!";
				System.out.println(str);
				mess.setIsRegister(false);
				mess.setMessage("Username or password is empty!");
				res = gson.toJson(mess);
			}else{
				Boolean isRegister = Register.register(StorePhone, StorePassword);
				if(isRegister == false){
					mess.setMessage("The phone has been registered!");
				}else{
					mess.setMessage("Successfully registered!");
					String storeID = Select.getStoreIdByPhone(StorePhone);
					mess.setStoreID(storeID);
				}
				mess.setIsRegister(isRegister);
				res = gson.toJson(mess);
			}
			
			this.response.getWriter().write(res);
			System.out.println(res);
			System.out.println("--------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
