package com.pai.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pai.dao.UserDao;
import com.pai.entity.User;
import com.pai.biz.UserBiz;

@Service("userSerivce")
public class UserBizImpl implements UserBiz {
	@Autowired
	UserDao userDao;		
	public void setAdminDAO(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean addUser(User user) throws Exception  {
	   return	userDao.addUser(user);
		
	}

	public boolean delUser(int userId)  throws Exception {
		  return	userDao.delUser(userId);
	}

	public boolean updateUser(User user) throws Exception{
		return userDao.updateUser(user);
		
	}

	public List<User> selectUser()  throws Exception{
		return userDao.selectUser();
		
	}

	public User getUserByUserId(int userId) throws Exception{
		return userDao.getUserByUserId(userId);
		
	}

	public boolean isExitByName(String userName) throws Exception{
		return userDao.isExitByName(userName);
		
	}

	public boolean isExitByNameAndPass(User user) throws Exception{
		
		return userDao.isExitByNameAndPass(user);
	}
	
	public User getUserByUserName(String userName)  throws Exception 
	{
		return userDao.getUserByUserName(userName);
		
	}
}
