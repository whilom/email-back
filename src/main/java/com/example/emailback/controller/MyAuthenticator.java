package com.example.emailback.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MyAuthenticator extends Authenticator {
	private String userName;
	private String password;
	public MyAuthenticator(){

	}

	public MyAuthenticator(String userName, String password){
		this.userName = userName;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName, password);
	}
}
