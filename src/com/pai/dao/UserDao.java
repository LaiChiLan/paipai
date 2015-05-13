package com.pai.dao;

import java.util.List;

import com.pai.entity.User;

/**     
 * 类名称：UserDao   
 * 类描述：用户控制dao实现数据库操作接口
 * 创建人：anan   
 * 创建时间：2012-12-21 下午11:05:46   
 * 修改人：anan  
 * 修改时间：2012-12-21 下午11:05:46   
 * 修改备注：   
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
