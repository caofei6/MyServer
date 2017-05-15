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
import com.weixiu.jdbc.Select;
import com.weixiu.jdbc.Update;
import com.weixiu.model.Message;
import com.weixiu.model.Store;

public class UpdateStoreAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9197830607203953064L;
	protected ServletRequest request;
	protected ServletResponse response;

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;

	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void updateStore() {
		try {
			String res = null;
			Gson gson = new Gson();
			Store store = new Store();
			Message mess = new Message();
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			String info = this.request.getParameter("store");
			Store httpStore = gson.fromJson(info, Store.class);
			
			if (info == null) {
				mess.setIsUpdateStore(false);
				mess.setMessage("httpStore is empty!");
				res = gson.toJson(mess);

			} else {
				store.setStoreID(httpStore.getStoreID());
				store.setStoreName(httpStore.getStoreName());
				store.setStoreContactInfor(httpStore.getStoreAddress());
				store.setStoreType(httpStore.getStoreType());
				store.setStoreAddress(httpStore.getStoreAddress());
				store.setStoreLatitude(httpStore.getStoreLatitude());
				store.setStoreLongitude(httpStore.getStoreLongitude());
				
				Boolean isEffective = Select.isEffectiveStoreID(httpStore.getStoreID());
				if (isEffective){
					Boolean isUpdateStore = Update.updateStore(store);
					if (isUpdateStore == false) {
						mess.setMessage("Store information changed failed ");
					}else{
						mess.setMessage("Store information changed successfully");
					}
					mess.setIsUpdateStore(isUpdateStore);
				}else{
					mess.setMessage("The StoreID has not existed!");
					mess.setIsUpdateStore(false);
				}
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

