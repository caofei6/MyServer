package com.weixiu.dao;

import com.weixiu.jdbc.Select;
import com.weixiu.jdbc.Update;

public class UpdatePassword {
	
	public static Boolean update(String storeID, String oldPassowrd, String newPassword){
		//��ѯ��ID��ȷ������
		Boolean isUpdate = null;
		String password = Select.getPasswordByID(storeID);
		if(password.equals(oldPassowrd)){
			isUpdate = Update.updateStorePassword(storeID, newPassword);	
			if(isUpdate == false){
				System.out.println("�����޸�ʧ�ܣ����ݿ�ԭ��");				
			}else{
				System.out.println("��ϲ�㣬�����޸ĳɹ���");
			}
		}else{
			isUpdate = false;
			System.out.println("�����޸�ʧ�ܣ�ԭ�����������");
		}
		return isUpdate;
	}
}
