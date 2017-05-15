package com.weixiu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weixiu.model.Store;



public class Update {

	/**
	 * Name:updateShop(Shop shop) 
	 * Function:�����̻�����
	 * @param shop(shop����)
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
			System.out.println("�޸ļ�¼��" + i);
			pstmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("�̻���Ϣ����ʧ��" + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Function:�޸��̻�����
	 * @param shop(shop����)
	 * @param newpassword(������)
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
			System.out.println("��ϲ�㣬�޸�����ɹ�");
			pstmt.close();
			con.close();	
			return true;
		}catch(SQLException e){
			System.out.println("�̻������޸�ʧ��" + e.getMessage());
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
			System.out.println("��ϲ�㣬����״̬�ɹ�");
			pstmt.close();
			con.close();	
			return true;
		}catch(SQLException e){
			System.out.println("��������״̬ʧ�� " + e.getMessage());
		}
		return false;
	}
}
