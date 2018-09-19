package com.demo.entity;

public class UserInfo {
	private String UserName;
	private String PassWord;

	public UserInfo() {
		super();		
	}

	public UserInfo(String userName, String passWord) {
		super();
		UserName = userName;
		PassWord = passWord;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

}
