<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
  <head>  
    <title>注册</title>
	
  </head>
  
  <body>
 
    <form action="doEdit.do" method="get">  
    请用EKP帐号登录
  <!--   <form action="user.do?method=doEdit" method="post"> -->
        <table>
        	<tr>
        		<td>用户名：</td>
        		<td><input type="text" name="userName" value="${user.userName}"/></td>
        	</tr>
        	<tr>
        		<td>密码：</td>
        		<td><input type="text" name="passWord" value="${user.passWord}"/></td>
        	</tr>

        	<tr>
        		<td></td>
        		<td><input type="submit" value="登 陆"> </td>
        	</tr>
        </table>

    </form>
  </body>
</html>
