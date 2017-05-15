package com.weixiu.action;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.weixiu.dao.UpdatePassword;
import com.weixiu.jdbc.Select;
import com.weixiu.model.Message;

public class UpdatePasswordAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9197830607203953064L;
	protected ServletRequest request;
	protected ServletResponse response;
	private String StoreID;
	private String OldPassword;
	private String NewPassword;

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;

	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String getOldPassword() {
		return OldPassword;
	}

	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}

	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	public String getNewPassword() {
		return NewPassword;
	}

	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}

	public void updatePassword() {
		try {
			String res = null;
			Gson gson = new Gson();
			Message mess = new Message();
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			if (OldPassword == null || NewPassword == null || OldPassword.equals("") || NewPassword.equals("")) {
				mess.setIsUpatePassword(false);
				mess.setMessage("NewPassword or OldPassword is empty!");
				res = gson.toJson(mess);
			}
			Boolean isEffective = Select.isEffectiveStoreID(StoreID);
			if(isEffective == false){
				mess.setIsUpatePassword(false);
				mess.setMessage("The StoreID has not existed!");
				res = gson.toJson(mess);
			} else {
				Boolean isUpatePassword = UpdatePassword.update(StoreID, OldPassword, NewPassword);
				if (isUpatePassword == false) {
					mess.setMessage("Original password input error!");
				}else{
					mess.setMessage("Change password successfully!");
				}
				mess.setIsUpatePassword(isUpatePassword);
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
