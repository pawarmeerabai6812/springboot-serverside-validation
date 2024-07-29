package com.infy.entity;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
	
	
	@NotBlank(message="User name can not be empty!!")
	
	@Size(min=3,max=12,message="user name must be 3-12 character")
	private String userName;
	
	//@Pattern(regexp = " ^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]", message="Invalid Email !!")
	private String email;
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}
	

}
