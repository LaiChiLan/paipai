package com.pai.biz.impl;

import java.util.List;

import com.pai.biz.AdminBiz;
import com.pai.dao.AdminDAO;
import com.pai.entity.Admin;

public class AdminBizImpl implements AdminBiz {

	//ʹ��AdminDAO�ӿ���������adminDAO�������set������������ע��
	AdminDAO adminDAO;		
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public List login(Admin condition) {		
		return adminDAO.search(condition);
	}

}
