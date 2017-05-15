package com.weixiu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class Delete {
	public static Boolean deleteStoreFormID(String storeID){
		Connection con = Connect_mysql.getConnection();
		String sql = "DELETE FROM StoreLogin WHERE StoreID = ?";
		
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, storeID);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			System.out.println("删除商户" + storeID + "成功");
			return true;
		}catch(SQLException e){
			System.out.println("删除商户失败" + e.getMessage());
		}
		return false;
		
	}

}
