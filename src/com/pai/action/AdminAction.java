package com.pai.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pai.biz.AdminBiz;
import com.pai.entity.Admin;

public class AdminAction extends ActionSupport implements SessionAware {
	
	//定义用于保存用户登录表单参数的两个属性
	private String loginName;
	private String loginPwd;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	//使用AdminBiz声明一个属性，并添加set方法用于依赖注入
	AdminBiz adminBiz;	
	
	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	//处理登录请求
	public String validateLogin() throws Exception {			
		Admin condition=new Admin();
		condition.setLoginName(loginName);
		condition.setLoginPwd(loginPwd);		
		List list=adminBiz.login(condition);
		if(list.size()>0){
			//将管理员对象存入Session
			session.put("admin", list.get(0));			
		}
		return "index"; 
	}
	
	//注销
	public String loginout() throws Exception {
		if(session.get("admin")!=null){
			session.remove("admin");    		
		}
		return "index";

	}
	Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;			
	}


}
