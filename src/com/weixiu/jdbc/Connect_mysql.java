package com.weixiu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connect_mysql {
	
	public static Connection getConnection(){
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://123.206.71.89:3306/WeiXiu?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
		String username = "root";
		String password = "";
		Connection con = null;
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
