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
		//这里要完成的是与EKP的接口验证，返回的结果是中文字，如：黎志南  ；如果不成功，返回的是false1
		  SSDLoginService ssdLoginService  =  new SSDLoginService();
		  SSDLoginDelegate ssdLoginDelegate = ssdLoginService.getSSDLoginPort();
		  Results = ssdLoginDelegate.getEKPUserFullName(userName, passWord);
		//这里要完成的是与EKP的接口验证，返回的结果是中文字，如：黎志南  ；如果不成功，返回的是false1   
		  
		 if (Results.equals("false1")) {
			 mv.setViewName("login"); 
			 
		}else{
			//先找MYSQL的USER有没有这个人，如果有的话，就跳入SESSION，并取回ID，如果没有，INSERT 并取回用户名和ID 
			if(userSerivce.isExitByName(Results)){
				User user = userSerivce.getUserByUserName(Results);
				request.getSession().setAttribute("user",user);
				mv.addObject("user", user);
			    mv.setViewName("edit");
			}else{
				User user = new User();
				user.setUserName(Results);
				//添加到数据库,其实只是加了个名入去。但没有密码
				userSerivce.addUser(user);
				//因为要取USERID ，所以注册完再来获取
				user = userSerivce.getUserByUserName(Results);			
				//这里就有USERID ，USERNAME
				request.getSession().setAttribute("user",user); 
			    mv.addObject("user", user);
			    mv.setViewName("edit");
			}  
		}
		 //如果是董凤祥或刘兆峰,就进入admin界面
		 if(Results.equals("董凤祥") || Results.equals("刘兆峰") )
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
