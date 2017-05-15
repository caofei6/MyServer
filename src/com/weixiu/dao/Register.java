package com.weixiu.dao;

import com.weixiu.jdbc.Insert;
import com.weixiu.jdbc.Select;
import com.weixiu.model.StoreLogin;

public class Register {
	public static Boolean register(String phone, String passwd){
		Boolean isRegister;
		StoreLogin store = new StoreLogin();
		if(phone == null || phone.equals("") || passwd == null || passwd.equals("")){
			System.out.println("�������������ֻ���Ϊ�գ�");
			isRegister = false;
			return isRegister;
		}
		//��֤�ֻ��������ݿ��Ƿ����
		Boolean isEffective = Select.isEffectivePhone(phone);
		if(isEffective == false){
			isRegister = false;
		}else{
			System.out.println("phone" + phone);
			System.out.println("passwd" + passwd);
			store.setStorePhone(phone);
			store.setStorePasswd(passwd);
			Insert.resigistStore(store);
			System.out.println("�ֻ���Ϊ" + phone + "���û�ע��ɹ�");
			isRegister = true;
		}
		return isRegister;
	}
}
