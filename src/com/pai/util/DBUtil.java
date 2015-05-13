package com.pai.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

  public static Connection getConnection() throws Exception{	
	  Connection conn = null;
	   	String url="jdbc:mysql://192.168.10.27:3306/paimai";
	   	String userName = "dio";
	   	String userPass = "lizhinan163";
	    	try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,userName,userPass); 
			System.out.println("	连接成功	"); 
	    	} catch (Exception e) {
	    		e.printStackTrace(); 
	    		throw e;
	    	}      	 
	    	return conn;
		  
  }
  
  public static void close(Connection conn) throws Exception {
	  if(conn!= null){
		  try{
			  conn.close();	  
		  }catch(SQLException e){
			  e.printStackTrace(); 
			  throw e;
		  }
		  
	  }  
  }
}
