package com.weixiu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weixiu.model.Store;
import com.weixiu.model.StoreInfo;
import com.weixiu.model.StoreLogin;



public class Insert {
	
	// ע���̻���Ϣ����storeLogin���в�������
	public static void resigistStore(StoreLogin store){
		Connection con = Connect_mysql.getConnection();
		String sql = "INSERT INTO StoreLogin(StorePhone, StorePasswd)" + "VALUES(?,?)";
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getStorePhone());
			pstmt.setString(2, store.getStorePasswd());
			pstmt.executeUpdate();
			System.out.println("�ֻ���Ϊ" + store.getStorePhone() + "����ע��ɹ�");
			pstmt.close();
			con.close();
		}catch(SQLException e){
			System.out.println("ע��ʧ�ܣ�ʧ��ԭ��" + e.getMessage());
		}
	}

	//��ȫ�̻���Ϣ����store�в�������
	public static Boolean completeStore(Store store) {
		Connection con = Connect_mysql.getConnection();
		int i = 0;
		String sql = "INSERT INTO Store(StoreID, StoreName, StorePersonName, StoreImage, StoreContactInfor, StoreType, StoreAddress, StoreLatitude, StoreLongitude)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		
//		Date dt = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = sdf.format(dt);
//		System.out.println("��ǰע��ʱ��" + time);
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getStoreID());
			pstmt.setString(2, store.getStoreName());
			pstmt.setString(3, store.getStorePersonName());
			pstmt.setString(4, store.getStoreImage());
			pstmt.setString(5, store.getStoreContactInfor());
			pstmt.setString(6, store.getStoreType());
			pstmt.setString(7, store.getStoreAddress());
			pstmt.setString(8, store.getStoreLatitude());
			pstmt.setString(9, store.getStoreLongitude());
			i = pstmt.executeUpdate();
			System.out.println("��ȫ��Ϣ�ɹ�����store���������" + i + "������");
			System.out.println("IDΪ" + store.getStoreID() + "����ע��ɹ�");
			pstmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("��ȫ����ʧ�� " + e.getMessage());
			return false;
		}

	}
	
	public static void updateSpecificInfor(StoreInfo storeInfor){
		
		Connection con = Connect_mysql.getConnection();
		String sql = "INSERT INTO StoreInfor(StoreAttentionNum, StoreReservationNum, StoreGrade, StoreInformation)" + "VALUES(?,?,?,?)";
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, storeInfor.getStoreAttentionNum());
			pstmt.setString(2, storeInfor.getStoreReservationNum());
			pstmt.setString(3, storeInfor.getStoreGrade());
			pstmt.setString(4, storeInfor.getStoreInformation());
			pstmt.executeUpdate();
			System.out.println("IDΪ" + storeInfor.getStoreID() + "����ע��ɹ�");
			pstmt.close();
			con.close();
		}catch(SQLException e){
			System.out.println("ע��ʧ�ܣ�ʧ��ԭ��" + e.getMessage());
		}
		
	}

}
