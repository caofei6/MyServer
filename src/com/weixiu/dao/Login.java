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
			System.out.println("���̻�δע�ᣬδ��ѯ������");
			return null;
		} else {
			if (psw.equals(password)) {
				System.out.println("��������" + password + ", ƥ��ɹ�,��½�ɹ�!");
				String storeID = Select.getStoreIdByPhone(phone);
				list = Select.getStoreFromId(storeID);
				return list;
			} else {
				System.out.println("��������" + password + ", ƥ��ʧ��,��½ʧ��!");
				return null;
			}
		}
	}

}
