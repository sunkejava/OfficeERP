package com.keditong.model;

/**
 * µÇÂ¼model
 * @author Administrator
 *
 */
public class UserLogin {
	private String userName;
	private String accountName;
	
	
	public UserLogin(String userName, String accountName) {
		super();
		this.userName = userName;
		this.accountName = accountName;
	}
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
}
