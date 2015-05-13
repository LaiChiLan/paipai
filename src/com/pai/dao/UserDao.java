package com.pai.dao;

import java.util.List;

import com.pai.entity.User;

/**     
 * �����ƣ�UserDao   
 * ���������û�����daoʵ�����ݿ�����ӿ�
 * �����ˣ�anan   
 * ����ʱ�䣺2012-12-21 ����11:05:46   
 * �޸��ˣ�anan  
 * �޸�ʱ�䣺2012-12-21 ����11:05:46   
 * �޸ı�ע��   
 * @version        
 * */
public interface UserDao {
	public boolean addUser(User user) throws Exception;

	public boolean delUser(int userId)  throws Exception ;

	public boolean updateUser(User user) throws Exception;

	public List<User> selectUser()  throws Exception;

	public User getUserByUserId(int userId) throws Exception;
    
	public User getUserByUserName(String userName)  throws Exception;
	
	public boolean isExitByName(String userName) throws Exception;

	public boolean isExitByNameAndPass(User user) throws Exception;

}
