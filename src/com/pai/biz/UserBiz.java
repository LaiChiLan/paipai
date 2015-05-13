package com.pai.biz;

import java.util.List;

import com.pai.entity.User;

public interface UserBiz {
	public boolean addUser(User user) throws Exception;

	public boolean delUser(int userId)  throws Exception ;

	public boolean updateUser(User user) throws Exception;

	public List<User> selectUser()  throws Exception;

	public User getUserByUserId(int userId) throws Exception;

	public User getUserByUserName(String userName)  throws Exception;
	
	public boolean isExitByName(String userName) throws Exception;

	public boolean isExitByNameAndPass(User user) throws Exception;

}
