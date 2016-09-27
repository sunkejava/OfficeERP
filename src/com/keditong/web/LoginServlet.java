package com.keditong.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keditong.dao.userLoginDao;
import com.keditong.util.DbUtil;
import com.keditong.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbU = new DbUtil();
	userLoginDao usd = new userLoginDao();
	StringUtil util = new StringUtil();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userCode = request.getParameter("userCode");
		String ServerAddress = request.getParameter("serverName");
		String jsoncallback=request.getParameter("jsoncallback"); 
		if (StringUtil.isEmpty(userCode) || StringUtil.isEmpty(ServerAddress)) {
			request.setAttribute("error", "请输入要搜索的内容！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} else {
			Connection con = null;
			con = dbU.getConnection(ServerAddress);
			JSONArray result =usd.getAccount(con, userCode);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println(jsoncallback+"("+result.toString()+")");
			out.flush();
			out.close();
			}
		
 	}
	
	
}
