<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
<title>修改</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>修改资料</em></span>
  </div>
  <form method="post" action="UsersServlet?op=doedit&uid=${uid}">
  <table class="noborder">
   <tr>
    <td style="text-align:right;">新密码：</td>
    <td><input type="password" class="textBox length-middle" name="upwd"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">再次确认密码：</td>
    <td><input type="password" class="textBox length-middle" name="upwd2"/></td>
   </tr>
    <tr>
    <td style="text-align:right;">手机号：</td>
    <td><input type="password" class="textBox length-middle" name="uphone"/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="保存"/></td>
   </tr>
  </table>
  </form>
 </div>
</body>
</html>
