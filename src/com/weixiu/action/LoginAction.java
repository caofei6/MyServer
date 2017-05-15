package com.weixiu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.weixiu.dao.Login;
import com.weixiu.model.Message;
import com.weixiu.model.StoreAllInfor;

public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9197830607203953064L;
	protected ServletRequest request;
	protected ServletResponse response;
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

	public void login() {
		
		List<StoreAllInfor> list = null;
		

		try {
			String str = null;
			String res = null;
			Gson gson = new Gson();
			Message mess = new Message();
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			if (StorePhone == null || StorePassword == null || StorePhone.equals("") || StorePassword.equals("")) {
				str = "Username or password is empty!";
				System.out.println(str);
				mess.setIsLogin(false);
				mess.setMessage("Username or password is empty!");
				res = gson.toJson(mess);
				
			} else {	
				list = Login.login(StorePhone, StorePassword);
				if(list.size() == 0){
					str = "Username and password do not match!";
					System.out.println(str);
					mess.setIsLogin(false);
					mess.setMessage("Username and password do not match!");
					res = gson.toJson(mess);
				}
				else{
					res = gson.toJson(list);
				}					
			}
			
			this.response.getWriter().write(res);
			System.out.println("list:" + list);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
