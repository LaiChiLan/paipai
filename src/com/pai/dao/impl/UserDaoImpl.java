package com.pai.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
 

import com.pai.dao.UserDao;
import com.pai.entity.User;
import com.pai.util.DBUtil;
 
/**     
 * 类名称：UserDaoImpl   
 * 类描述：用户控制dao实现数据库操作接口实现
 * 创建人：anan   
 * 创建时间：2015-4-21 下午11:07:43   
 * 修改人：anan  
 * 修改时间：2015-5-21 下午11:07:43   
 * 修改备注：   
 * @version        
 * */
 @Repository("UserDao")
public class UserDaoImpl  implements UserDao{
  
	public String results;
	
	public boolean addUser(User user) throws Exception     {
		    int rows;
		    boolean is = true;
		    String SQL = "";
		
				Connection conn  = DBUtil.getConnection();
		        SQL =  "INSERT INTO user(userName) VALUES(?)";
		        PreparedStatement prep = conn.prepareStatement(SQL);  
		     
		        prep.setString(1,user.getUserName() );

		   try {
		    
		        rows = prep.executeUpdate(); 
			   if (rows > 0) {
				    is =  true;
        			DBUtil.close(conn);
        		
			   }else
			   {
				    is =  false;
       		    	DBUtil.close(conn);
			   }
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				DBUtil.close(conn);
			}
			return is;
	}

	public boolean delUser(int userId)   throws Exception  {
	    int rows;
	    String SQL = "";
	    boolean is = true;
			Connection conn  = DBUtil.getConnection();
		    SQL =  "delete from  user where userId=?)";
		    PreparedStatement prep = conn.prepareStatement(SQL);  
	        prep.setInt (1,userId);
	    
		try {
		    rows = prep.executeUpdate(); 
			   if (rows > 0) {
					 is =  true;
     			    DBUtil.close(conn);
			   }else
			   {
					  is =  false;
       		    	DBUtil.close(conn);
			   }
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.close(conn);
		} 
		return 	  is   ;  
	}

	public boolean updateUser(User user ) throws Exception{
		  int rows;
		  boolean is = true;
		    String SQL = "";
		
				Connection conn  = DBUtil.getConnection();
			    
	            SQL =  " update user  set    userName =  ?  "
	            		+ "  where userId = ? ";
	            PreparedStatement prep = conn.prepareStatement(SQL); 
		        
		        prep.setString(1,user.getUserName() );
		        prep.setInt (2,user.getUserId());
		    
			try {
			    rows = prep.executeUpdate(); 
				   if (rows > 0) {
					    is =  true;
	     			    DBUtil.close(conn);
				   }else
				   {
					    is =  false;
	       		    	DBUtil.close(conn);
				   }
			} catch (Exception e) {
				e.printStackTrace();
				DBUtil.close(conn);
			} 
			return is; 
 
		
	}

	public List<User> selectUser()  throws Exception  {
		List<User> users = new ArrayList<User>();
	    String SQL = "";
		Connection conn  = DBUtil.getConnection();
	  
	    SQL =  " select * from user";
	    PreparedStatement prep = conn.prepareStatement(SQL);  
 
		try {
			 
			ResultSet rst = prep.executeQuery(); 
			 while(rst.next()){
				 User user = new User();
				 user.setUserId(rst.getInt("userId") ); 	
				 user.setUserName(rst.getString("userName") == null ? "" : rst.getString("userName") ); 	
				 user.setPassWord(rst.getString("passWord") == null ? "" : rst.getString("passWord") ); 				
				 users.add(user);
			 }
		 
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.close(conn);
		}
		DBUtil.close(conn);
		return users;
	}

	public User getUserByUserId(int userId)  throws Exception  {
		    User user = new User();
		    String SQL = "";
			Connection conn  = DBUtil.getConnection();
		    PreparedStatement prep = conn.prepareStatement(SQL);  
		    SQL =  " select * from user where userId = ?";
		    prep = conn.prepareStatement(SQL);    
	        prep.setInt (1,userId);
		try {
			ResultSet rst = prep.executeQuery();
			 while(rst.next()){
		    user.setPassWord(rst.getString("passWord") == null ? "" : rst.getString("passWord") ); 		
			user.setUserName(rst.getString("userName") == null ? "" : rst.getString("userName") ); 
			user.setUserId(userId);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.close(conn);
		}
 
		DBUtil.close(conn);
		return user;
	}

	public boolean isExitByName(String userName) throws Exception   {
		//  User user = new User();
		    boolean is = true;
		    String SQL = "";
			Connection conn  = DBUtil.getConnection();
		    PreparedStatement prep = conn.prepareStatement(SQL);  
		    SQL =  " select * from user where userName = ?";
		    prep = conn.prepareStatement(SQL);    
		    prep.setString(1,userName );
		 
			try {
				ResultSet rst = prep.executeQuery(); 
				  if(rst.next()){
					  is =  true;
		     			DBUtil.close(conn);
				  }else{
					  is = false	;
     		    	  DBUtil.close(conn);
				  }
			} catch (Exception e) {
				DBUtil.close(conn);
				e.printStackTrace();
			}
		 
	  return  is;
	}

	public boolean isExitByNameAndPass(User user) throws Exception    {
	    boolean is = true;
	    String SQL = "";
		Connection conn  = DBUtil.getConnection();
	    SQL =  " select * from user where userName = ? and passWord = ?";  
	    PreparedStatement prep = conn.prepareStatement(SQL);  
	   
        prep.setString(1,user.getUserName() );
        prep.setString(2,user.getPassWord() );
	 
		try {
			ResultSet rst = prep.executeQuery(); 
			  if(rst.next()){
				  is =  true;
	     		  DBUtil.close(conn);
			  }else{
				  is = false	;
 		    	  DBUtil.close(conn);
			  }
		} catch (Exception e) {
			DBUtil.close(conn);
			e.printStackTrace();
		}
	 
  return  is;
	}
	
	
	public User getUserByUserName(String userName) throws Exception{
	//	List<User> users = new ArrayList<User>();
		User user = new User();
	    String SQL = "";
		Connection conn  = DBUtil.getConnection();
	  
	    SQL =  " select * from user where userName = ?";
	    PreparedStatement prep = conn.prepareStatement(SQL);  
	    prep.setString(1, userName);
		try {
			 
			ResultSet rst = prep.executeQuery(); 
			
			 while(rst.next()){ 
				 user.setUserId(rst.getInt("userId") ); 	
				 user.setUserName(rst.getString("userName") == null ? "" : rst.getString("userName") ); 	
				 user.setPassWord(rst.getString("passWord") == null ? "" : rst.getString("passWord") ); 					 
			 }
		 
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.close(conn);
		}
		DBUtil.close(conn);
		return user;	
		
	}
/*	
	public List<User> findAll(int startRow, int endRow) {

		List rows = jdbcTemplate.queryForList("select * from T_USER  limit "
				+ startRow + "," + endRow);

		return rows;

	}
*/
}
