package com.weixiu.jdbc;


public class Test {
	public static void main(String[] args) {
		//同时删除Store、StoreLogin、StoreInfor表的中的关于ID的所有信息
		//Delete.deleteStoreFormID("4");
//		Login.login("1", "123456");
//		Select.getPasswordByPhone("18824545125");
//		Select.getStoreIdByPhone("18824545125");
//		Update.updateShopPassword("18824545125", "962464", "12345678");
//		Select.isEffectivePhone("188254474");
//		Select.getNameByUserID("3");
//		Select.getPhoneByUserID("1");
		Select.getOrder("2", "正在处理");
		
   
	}
}
