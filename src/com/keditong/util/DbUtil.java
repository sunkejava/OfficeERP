package com.keditong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Sqlserve���ݿ�����
 * @author Administrator
 *
 */
public class DbUtil {
	
	static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=perpsys";
	static final String USER = "sa";
	static final String PWD = "123456";
	
	/**
	 * ��ȡ���ݿ�����
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
	 * ���ݿ����ӹر�
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
			System.out.println("���ݿ����ӳɹ�����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ���");
		}
	}
}
