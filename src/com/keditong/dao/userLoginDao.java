package com.keditong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keditong.util.DbUtil;


public class userLoginDao {
	public String[] getAccount(Connection con,String userCode){
		String[] resultAccount = null;
		String sql = "select distinct accountcode from Sys_Userfunclist where usercode = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userCode);
			ResultSet rst = pstmt.executeQuery();
			int i = 0;
			while(rst.next()){
			resultAccount[i] = rst.getString("accountcode");
			System.out.println(resultAccount[i]);
			i++;
			}
			return resultAccount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("database seach error!");
		}
		return resultAccount;
		
	}
	public static void main(String[] args) {
		DbUtil dbu = new DbUtil();
		Connection con = dbu.getConnection();
		System.out.println("dabase connect success");
		userLoginDao use = new userLoginDao();
		String[] accountCode = use.getAccount(con, "yld");
		int i = 1;
		while(i<accountCode.length){
			System.out.println(accountCode[i]);
			i++;
		}
		System.out.println(accountCode);
	}
}
