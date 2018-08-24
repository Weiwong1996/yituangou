<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">   
<title>登陆界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="nofollow"/>
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
<style>
body{width:100%;height:100%;overflow:hidden;background:url(image/pc_loginBg.jpg) no-repeat;background-size:cover;position:absolute;}
.btn{
width: 121px;
    height: 59px;
    margin-top: 14px;
    margin-left: 181px;}
</style>
<script src="js/jquery.js"></script>
<script src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  $('body').particleground({
    dotColor:'green',
    lineColor:'#c9ec6e'
  });
  $('.intro').css({
    'margin-top': -($('.intro').height() /2)
  });
});
</script>
<body>
<form action="UsersServlet?op=login" method="post"> 
  <section class="loginform" >
   <h1>登陆系统</h1>
   <ul>
    <li>
     <label>账号：</label>
     <input type="text" id="uname" name="uname" class="textBox" placeholder="用户账号"/>
    </li>
    <li>
     <label>密码：</label>
     <input type="password" id="upwd" name="upwd" class="textBox" placeholder="登陆密码"/>
    </li>
    <li>
     <input type="submit" value="立即登陆" class="btn"/> </li>
    <li> <a href="register.jsp">注册</a></li>
    <li> <a href="home.jsp">返回</a></li>
   
   </ul>
  </section>
  </form>
</body>
</html>
