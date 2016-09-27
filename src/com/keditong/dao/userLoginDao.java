package com.keditong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keditong.util.DbUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class userLoginDao {
	public JSONArray getAccount(Connection con,String userCode){
		JSONArray resultAccount = null;
		JSONObject jo = new JSONObject();
		resultAccount = new JSONArray();
		String sql = "SELECT code,shortname FROM Sys_Account WHERE usesign=1 AND code IN (SELECT DISTINCT accountcode FROM Sys_UserfunclistView WHERE usercode=?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userCode);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
			jo.put("accountCode", rst.getString("code")) ;
			jo.put("accountName", rst.getString("shortname"));
			resultAccount.add(jo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("database seach error!");
		}
		return resultAccount;
		
	}
	public static void main(String[] args) {
		DbUtil dbu = new DbUtil();
		Connection con = dbu.getConnection("perpsys");
		userLoginDao use = new userLoginDao();
		JSONArray accountCode = use.getAccount(con, "yld");
		JSONObject jsono = accountCode.getJSONObject(1);
		System.out.println(jsono.get("accountName"));
	}
}
