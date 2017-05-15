package com.weixiu.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.weixiu.jdbc.Insert;
import com.weixiu.model.Message;
import com.weixiu.model.Store;

public class CompleteStoreInfoAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;

	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void updateInfo() {
		
		Gson gson = new Gson();
		Message mess = new Message();
		Store store = new Store();
		

		try {
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("utf-8");
			
			String storeInfo = this.request.getParameter("store");
			Store httpStore = gson.fromJson(storeInfo, Store.class);
			System.out.println("httpStore" + httpStore);

			
			if(storeInfo == null){
				mess.setIsUpdateStore(false);
				mess.setMessage("There are some space!");
			}else{
				store.setStoreID(httpStore.getStoreID());
				store.setStoreName(httpStore.getStoreName());
			    store.setStorePersonName(httpStore.getStorePersonName());
				store.setStoreContactInfor(httpStore.getStoreAddress());
				store.setStoreType(httpStore.getStoreType());
				store.setStoreAddress(httpStore.getStoreAddress());
				store.setStoreLatitude(httpStore.getStoreLatitude());
				store.setStoreLongitude(httpStore.getStoreLongitude());
				
				Boolean isUpdateStore = Insert.completeStore(store);
				mess.setIsUpdateStore(isUpdateStore);
				mess.setMessage("CompleteStoreInfor " + isUpdateStore);
			}

			String res = gson.toJson(mess);
			this.response.getWriter().write(res);
			System.out.println(res);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
