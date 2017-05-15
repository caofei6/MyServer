package com.weixiu.dao;



import java.util.ArrayList;
import java.util.List;

import com.weixiu.jdbc.Select;
import com.weixiu.model.StoreAllInfor;



public class Login {

	public static List<StoreAllInfor> login(String phone, String password) {

		String psw = Select.getPasswordByPhone(phone);
		List<StoreAllInfor> list = new ArrayList<StoreAllInfor>();
		if (psw.equals("") || psw == null) {
			System.out.println("该商户未注册，未查询出密码");
			return null;
		} else {
			if (psw.equals(password)) {
				System.out.println("输入密码" + password + ", 匹配成功,登陆成功!");
				String storeID = Select.getStoreIdByPhone(phone);
				list = Select.getStoreFromId(storeID);
				return list;
			} else {
				System.out.println("输入密码" + password + ", 匹配失败,登陆失败!");
				return null;
			}
		}
	}

}
