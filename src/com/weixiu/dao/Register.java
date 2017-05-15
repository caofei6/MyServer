package com.weixiu.dao;

import com.weixiu.jdbc.Insert;
import com.weixiu.jdbc.Select;
import com.weixiu.model.StoreLogin;

public class Register {
	public static Boolean register(String phone, String passwd){
		Boolean isRegister;
		StoreLogin store = new StoreLogin();
		if(phone == null || phone.equals("") || passwd == null || passwd.equals("")){
			System.out.println("输入的密码或者手机号为空！");
			isRegister = false;
			return isRegister;
		}
		//验证手机号在数据库是否存在
		Boolean isEffective = Select.isEffectivePhone(phone);
		if(isEffective == false){
			isRegister = false;
		}else{
			System.out.println("phone" + phone);
			System.out.println("passwd" + passwd);
			store.setStorePhone(phone);
			store.setStorePasswd(passwd);
			Insert.resigistStore(store);
			System.out.println("手机号为" + phone + "的用户注册成功");
			isRegister = true;
		}
		return isRegister;
	}
}
