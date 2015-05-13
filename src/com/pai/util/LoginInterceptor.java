package com.pai.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override 
	public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler) throws Exception {
		Object obj = request.getSession().getAttribute("user");
		if(obj==null){
			request.getRequestDispatcher("/login.jsp").forward(request, response); 
		return false;
		}
		else{
			return super.preHandle(request, response, handler);
		}
	}
}