package com.pai.entity;

import org.springframework.stereotype.Repository;

 
public class User implements java.io.Serializable {
	
	 private int userId;  
	 private String userName;  
	 private String passWord;
	 private String admin;
	 
     public User(){}
     public User(int userId,String userName,String passWord){
    	 this.userId = userId;
    	 this.userName = userName;
    	 this.passWord = passWord;	 
     }
     
     
     public User(    String userName,String passWord){
    	 this.userName = userName;
    	 this.passWord = passWord;	 
     }
	 
	 public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public int getUserId() {
		return userId;
	}
	 
	 public String getPassWord() {
     	return passWord;
    }
		
	public String getUserName() {
		return userName;
	}  
	
	 public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
}
