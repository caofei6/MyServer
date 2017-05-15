package com.weixiu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weixiu.model.Store;



public class Update {

	/**
	 * Name:updateShop(Shop shop) 
	 * Function:更新商户密码
	 * @param shop(shop对象)
	 */
	public static Boolean updateStore(Store store) {
		Connection con = Connect_mysql.getConnection();
		String sql = "UPDATE Store SET StoreName = ?, StoreContactInfor = ?, StoreType = ?, StoreAddress = ? WHERE StoreID = ?";
		int i = 0;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getStoreContactInfor());
			pstmt.setString(3, store.getStoreType());
			pstmt.setString(4, store.getStoreAddress());
			pstmt.setString(5, store.getStoreID());
			i = pstmt.executeUpdate();
			System.out.println("修改记录数" + i);
			pstmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("商户信息更新失败" + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Function:修改商户密码
	 * @param shop(shop对象)
	 * @param newpassword(新密码)
	 */
	public static Boolean updateStorePassword(String storeId, String newpassword) {
		Connection con = Connect_mysql.getConnection();
		String sql = "UPDATE StoreLogin SET StorePasswd = ? WHERE StoreID = ?";
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newpassword);
			pstmt.setString(2, storeId);
			pstmt.executeUpdate();
			System.out.println("恭喜你，修改密码成功");
			pstmt.close();
			con.close();	
			return true;
		}catch(SQLException e){
			System.out.println("商户密码修改失败" + e.getMessage());
		}
		return false;
	}
	
	public static Boolean updateOrderStatus(String OrderID, String Status, String AcceptTime) {
		Connection con = Connect_mysql.getConnection();
		String sql = "UPDATE Orders SET OrderStat = ?, OrderTime = ? WHERE OrderID = ?";
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Status);
			pstmt.setString(2, AcceptTime);				
			pstmt.setString(3, OrderID);
			pstmt.executeUpdate();
			System.out.println("恭喜你，更新状态成功");
			pstmt.close();
			con.close();	
			return true;
		}catch(SQLException e){
			System.out.println("订单更新状态失败 " + e.getMessage());
		}
		return false;
	}
}
