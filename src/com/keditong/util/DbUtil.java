package com.keditong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Sqlserve数据库连接
 * @author Administrator
 *
 */
public class DbUtil {
	
	static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=perpsys";
	static final String USER = "sa";
	static final String PWD = "123456";
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER,PWD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("success");
			return con;
			
		}
	
	/**
	 * 数据库连接关闭
	 * @param con
	 */
	public void closeCon(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbutil = new DbUtil();
		try {
			Connection con = dbutil.getConnection();
			System.out.println("数据库连接成功！！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败！！");
		}
	}
}
