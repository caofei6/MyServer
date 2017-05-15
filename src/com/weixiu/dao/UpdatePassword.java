package com.weixiu.dao;

import com.weixiu.jdbc.Select;
import com.weixiu.jdbc.Update;

public class UpdatePassword {
	
	public static Boolean update(String storeID, String oldPassowrd, String newPassword){
		//查询该ID正确的密码
		Boolean isUpdate = null;
		String password = Select.getPasswordByID(storeID);
		if(password.equals(oldPassowrd)){
			isUpdate = Update.updateStorePassword(storeID, newPassword);	
			if(isUpdate == false){
				System.out.println("密码修改失败，数据库原因！");				
			}else{
				System.out.println("恭喜你，密码修改成功！");
			}
		}else{
			isUpdate = false;
			System.out.println("密码修改失败，原密码输入错误！");
		}
		return isUpdate;
	}
}
