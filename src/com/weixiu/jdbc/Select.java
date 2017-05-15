package com.weixiu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weixiu.model.Comment;
import com.weixiu.model.Order;
import com.weixiu.model.Store;
import com.weixiu.model.StoreAllInfor;
import com.weixiu.model.StoreInfo;



public class Select {

	public static List<StoreAllInfor> getStoreFromId(String Id) {
		Connection con = Connect_mysql.getConnection();
		PreparedStatement pstmt;
		String sql = "SELECT * FROM Store a join StoreInfor b on a.StoreID = b.StoreID WHERE a.StoreID = " + Id;
		try {
			List<StoreAllInfor> list = new ArrayList<StoreAllInfor>();
			pstmt = con.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			int col = res.getMetaData().getColumnCount();
			System.out.println("我是列col" + col);
			System.out.println("--------------------------------------------");
			while (res.next()) {
				for (int i = 1; i <= col; i++) {				
					System.out.print(res.getString(i) + "   ");
					if (i % col == 0) {
						System.out.println("\n");
					}
				}
				Store store  = new Store();
				StoreInfo storeInfo = new StoreInfo();
				StoreAllInfor storeAllInfor = new StoreAllInfor(store, storeInfo);
				
				storeAllInfor.setIsLogin(true);
				storeAllInfor.getStore().setStoreID(res.getString(1));
				storeAllInfor.getStore().setStoreName(res.getString(2));
				storeAllInfor.getStore().setStorePersonName(res.getString(3));
				storeAllInfor.getStore().setStoreImage(res.getString(4));
				storeAllInfor.getStore().setStoreContactInfor(res.getString(5));
				storeAllInfor.getStore().setStoreType(res.getString(6));
				storeAllInfor.getStore().setStoreAddress(res.getString(7));
				storeAllInfor.getStore().setStoreLatitude(res.getString(8));
				storeAllInfor.getStore().setStoreLongitude(res.getString(9));
				
				storeAllInfor.getStoreInfo().setStoreAttentionNum(res.getString(11));
				storeAllInfor.getStoreInfo().setStoreReservationNum(res.getString(12));
				storeAllInfor.getStoreInfo().setStoreGrade(res.getString(13));
				storeAllInfor.getStoreInfo().setStoreInformation(res.getString(14));
			
				list.add(storeAllInfor);
			}

			System.out.println("---------------------------------------------");
			con.close();
			pstmt.close();
			res.close();
			return list;
		} catch (SQLException e) {
			System.out.println("查询商户信息失败" + e.getMessage());
		}
		return null;
		
	}
	
	public static List<Order> getOrder(String StoreID, String Status) {
		Connection con = Connect_mysql.getConnection();
		PreparedStatement pstmt;
		try {
			if(Status.equals("0")){
				String sql1 = "SELECT * FROM Orders WHERE StoreID = ?";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, StoreID);
			}else{
				String sql2 = "SELECT * FROM Orders WHERE StoreID = ? and OrderStat = ?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, StoreID);
				pstmt.setString(2, Status);
			}
			List<Order> list = new ArrayList<Order>();
			ResultSet res = pstmt.executeQuery();
			int col = res.getMetaData().getColumnCount();
			System.out.println("我是列col" + col);
			System.out.println("--------------------------------------------");
			while (res.next()) {
				Order order  = new Order();
				order.setIsRequest(true);
				order.setOrderId(res.getString("OrderID"));
				order.setOrderName(Select.getNameByUserID(res.getString("UserID")));
				order.setOrderAddress(res.getString("UserAddress"));
				order.setOrderType(res.getString("OrderInfor"));
				order.setOrderPhone(Select.getPhoneByUserID(res.getString("UserID")));
				order.setOrderLatitude(res.getString("UserLatitude"));
				order.setOrderLongitude(res.getString("UserLongitude"));
				list.add(order);
			}
			System.out.println("---------------------------------------------");
			con.close();
			pstmt.close();
			res.close();
			return list;
		} catch (SQLException e) {
			System.out.println("查询商户信息失败" + e.getMessage());
		}
		return null;
	}
	
	public static String getNameByUserID(String UserID){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT UserName FROM UserInfor WHERE UserID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, UserID);
			rs = preparedStatement.executeQuery();
			rs.next();
			String Name = rs.getString("UserName");
			System.out.println("用户ID: " + UserID + ", 数据库Name: " + Name);
			connection.close();
			preparedStatement.close();
			rs.close();
			return Name;
			
		} catch (SQLException e) {
			System.out.println("查询密码失败, " + e.getMessage());
		}
		return null;

	}
	
	public static String getPhoneByUserID(String UserID){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT UserPhone FROM UserLogin WHERE UserID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, UserID);
			rs = preparedStatement.executeQuery();
			rs.next();
			String Phone = rs.getString("UserPhone");
			System.out.println("用户ID: " + UserID + ", 数据库Phone: " + Phone);
			connection.close();
			preparedStatement.close();
			rs.close();
			return Phone;
			
		} catch (SQLException e) {
			System.out.println("查询密码失败, " + e.getMessage());
		}
		return null;

	}

	public static String getPasswordByPhone(String phone){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT StorePasswd FROM StoreLogin WHERE StorePhone = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			rs = preparedStatement.executeQuery();
			rs.next();
			String password = rs.getString("StorePasswd");
			System.out.println("用户手机: " + phone + ", 数据库password: " + password);
			connection.close();
			preparedStatement.close();
			rs.close();
			return password;
			
		} catch (SQLException e) {
			System.out.println("查询密码失败, " + e.getMessage());
		}
		return null;

	}
	
	public static String getPasswordByID(String storeID){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT StorePasswd FROM StoreLogin WHERE StoreID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, storeID);
			rs = preparedStatement.executeQuery();
			rs.next();
			String password = rs.getString("StorePasswd");
			System.out.println("ID: " + storeID + ", 数据库password: " + password);
			connection.close();
			preparedStatement.close();
			rs.close();
			return password;
			
		} catch (SQLException e) {
			System.out.println("查询密码失败, " + e.getMessage());
		}
		return null;

	}
	
	public static String getStoreIdByPhone(String phone){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT StoreID FROM StoreLogin WHERE StorePhone = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			rs = preparedStatement.executeQuery();
			rs.next();
			String storeID = rs.getString("StoreID");
			System.out.println("用户手机: " + phone + ", 数据库storeID: " + storeID);
			connection.close();
			preparedStatement.close();
			rs.close();
			return storeID;
		} catch (SQLException e) {
			System.out.println("查询id失败, " + e.getMessage());
		}
		return null;

	}
	
	public static String getOrderTimeByOrderID(String orderID){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT OrderTime FROM Orders WHERE OrderID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderID);
			rs = preparedStatement.executeQuery();
			rs.next();
			String OrderTime = rs.getString("OrderTime");
			System.out.println("订单ID: " + orderID + ", OrderTime: " + OrderTime);
			connection.close();
			preparedStatement.close();
			rs.close();
			return OrderTime;
		} catch (SQLException e) {
			System.out.println("查询id失败, " + e.getMessage());
		}
		return null;
	}
	
	public static Boolean isEffectivePhone(String phone){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Boolean isEffective = false;
		ResultSet rs = null;
		int count = 0;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT COUNT(StorePhone) AS count FROM StoreLogin WHERE StorePhone = " + phone;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				count = rs.getInt("count");
			}
			System.out.println("count:" + count);
			if(count >= 1){
				isEffective = false;
			}else{
				isEffective = true;
			}
			connection.close();
			preparedStatement.close();
			rs.close();
			return isEffective;
			
		} catch (SQLException e) {
			System.out.println("查询密码失败, " + e.getMessage());
		}
		return null;

	}
	
	//存在：true   不存在：false
	public static Boolean isEffectiveStoreID(String storeID){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Boolean isEffective = false;
		ResultSet rs = null;
		int count = 0;
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT COUNT(StoreID) AS count FROM StoreLogin WHERE StoreID = " + storeID;
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				count = rs.getInt("count");
			}
			System.out.println("count:" + count);
			if(count >= 1){
				isEffective = true;
			}else{
				isEffective = false;
			}
			connection.close();
			preparedStatement.close();
			rs.close();
			return isEffective;
			
		} catch (SQLException e) {
			System.out.println("查询密码失败, " + e.getMessage());
		}
		return null;

	}
	
	public static List<Comment> getCommentByStoreID(String storeID){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Comment> list = new ArrayList<Comment>();
		try{
			connection = Connect_mysql.getConnection();
			String sql = "SELECT * FROM StoreComment WHERE StoreID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, storeID);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setIsRequest(true);
				comment.setMarkTime(rs.getString("CommentTime"));
				comment.setMarkName(Select.getNameByUserID(rs.getString("UserID")));
				comment.setMarkContent(rs.getString("OrderComment"));
				list.add(comment);
			}
			connection.close();
			preparedStatement.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			System.out.println("查询id失败, " + e.getMessage());
		}
		return null;
	}
	
	
}
