package com.pai.action;

import java.util.List;
import java.lang.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
import org.springframework.web.bind.annotation.InitBinder; 
import org.springframework.web.bind.annotation.SessionAttributes;

  

import com.stub.SSDLogin.*;
import com.pai.biz.UserBiz;
import com.pai.entity.User;

@Controller
@RequestMapping("/user")
/*@SessionAttributes("user") */
public class UserAction          {
      @Autowired 
      private UserBiz userSerivce;
  	  public void setSerivce(UserBiz userSerivce) {
		this.userSerivce = userSerivce;
	  }
	  public UserBiz getSerivce() {
		return userSerivce;
	  }
	  
	  
	  @RequestMapping(value="/toList",method=RequestMethod.GET)
	  public ModelAndView tolist() throws Exception{
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("NewFile");
		  List<User> users =  userSerivce.selectUser();
		  mv.addObject("users", users);
	
		  return mv;
	  }
	  
	  @RequestMapping(value="/toEdit",method=RequestMethod.GET)
	  public ModelAndView toEdit(
			  @RequestParam(value="userId",required=true) Integer userId )  throws Exception {
		  User user =  userSerivce.getUserByUserId(userId);
		  
		  
	 	  ModelAndView mv = new ModelAndView();
	      mv.addObject("user", user);
	 	  mv.setViewName("edit");
		  
		   return mv;
	  }
	
	  @RequestMapping(value="/doEdit",method=RequestMethod.GET)
	  public String doEdit(
			  @RequestParam(value="userId",required=true) Integer userId ,
			  @RequestParam(value="passWord",required=true) String passWord ,
			  @RequestParam(value="userName",required=true) String userName )  
      throws Exception {
		  
	 //	  ModelAndView mv = new ModelAndView();
	 	  User user =  new User(userId, userName, passWord);
	 	  boolean res  = userSerivce.updateUser(user);
	 	 
	 	  if( res){
	 		 return "redirect:/user/toList.do";
	 	  }else
	 	  {
	 		 return "error"; 
	 	  }
	 	 
	 
	  }
	  
	  
	  @RequestMapping(value="/doLogin",method=RequestMethod.GET)
	  public ModelAndView doLogin(
			/*  @RequestParam(value="userId",required=true) Integer userId ,*/
			  @RequestParam(value="passWord",required=true) String passWord ,
			  @RequestParam(value="userName",required=true) String userName,
			  HttpServletRequest request)  
					  throws Exception {
		/*  User user =  userSerivce.getUserByUserId(userId);*/
		 
		  ModelAndView mv = new ModelAndView();
		  String Results;
		//����Ҫ��ɵ�����EKP�Ľӿ���֤�����صĽ���������֣��磺��־��  ��������ɹ������ص���false1
		  SSDLoginService ssdLoginService  =  new SSDLoginService();
		  SSDLoginDelegate ssdLoginDelegate = ssdLoginService.getSSDLoginPort();
		  Results = ssdLoginDelegate.getEKPUserFullName(userName, passWord);
		//����Ҫ��ɵ�����EKP�Ľӿ���֤�����صĽ���������֣��磺��־��  ��������ɹ������ص���false1   
		  
		 if (Results.equals("false1")) {
			 mv.setViewName("login"); 
			 
		}else{
			//����MYSQL��USER��û������ˣ�����еĻ���������SESSION����ȡ��ID�����û�У�INSERT ��ȡ���û�����ID 
			if(userSerivce.isExitByName(Results)){
				User user = userSerivce.getUserByUserName(Results);
				request.getSession().setAttribute("user",user);
				mv.addObject("user", user);
			    mv.setViewName("edit");
			}else{
				User user = new User();
				user.setUserName(Results);
				//��ӵ����ݿ�,��ʵֻ�Ǽ��˸�����ȥ����û������
				userSerivce.addUser(user);
				//��ΪҪȡUSERID ������ע����������ȡ
				user = userSerivce.getUserByUserName(Results);			
				//�������USERID ��USERNAME
				request.getSession().setAttribute("user",user); 
			    mv.addObject("user", user);
			    mv.setViewName("edit");
			}  
		}
		 //����Ƕ���������׷�,�ͽ���admin����
		 if(Results.equals("������") || Results.equals("���׷�") )
		 {

			  mv.setViewName("admin");
		 }
		   return mv;
	  }
	  
	  /*
	SSDLoginService ssdLoginService  =  new SSDLoginService();
		
		SSDLoginDelegate ssdLoginDelegate = ssdLoginService.getSSDLoginPort();
		
		result = ssdLoginDelegate.getEKPUserFullName("lizhinan", "12345");*/
}
