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
<title>管理员导航</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body style="background:#313131">
<div class="menu-list">
 <a href="main.html" target="mainCont" class="block menu-list-title center" style="border:none;margin-bottom:8px;color:#fff;">欢迎，XXX</a>
 <ul>
  <li class="menu-list-title">
   <span>订单管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="orderlist.jsp" title="商品列表" target="mainCont">订单列表</a></li>
   </ul>
  </li>
 
  <li class="menu-list-title">
   <span>商品管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="goodsList.jsp" title="商品列表" target="mainCont">商品列表</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>用户管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="userList.jsp" title="会员列表" target="mainCont">会员列表</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>系统设置</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="#" title="站点基本设置" target="mainCont">站点基本设置</a></li>
    <li><a href="#" title="站点基本设置" target="mainCont">站点管理员</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>广告管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="advertising_list.html" title="站点基本设置" target="mainCont">广告列表</a></li>
   </ul>
  </li>
  
  <li class="menu-list-title">
   <span>其他</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="home.jsp" title="站点基本设置" target="mainCont" >安全退出</a></li>
   </ul>
  </li>
    
 </ul>
</div>
<div class="menu-footer">© 我是牛逼的管理员：<a href="http://www.mycodes.net/" target="_blank">哈哈哈</a></div>
</body>
</html>
