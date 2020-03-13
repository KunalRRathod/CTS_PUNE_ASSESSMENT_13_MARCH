package com.cognizant;

//POJO Model JavaBean
public class LoginBean {
	private String userName, password;

	public LoginBean() {

	}

	public String getUserName() {
		System.out.println("from getUserName()");
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println("from setUserName ()");
	}

	public String getPassword() {
		System.out.println("from getPassword");
		return password;

	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("from setPassword()");
	}
}
