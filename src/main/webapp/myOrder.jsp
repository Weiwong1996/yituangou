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
<title>订单列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.imgshow {
	width: 100px;
	height: 100px;
}

.xuanzhe {
	    width: 354px;
    height: 39px;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="order"></i><em>订单列表</em></span>
  </div>
  <div class="operate">
   <div class="BatchOperation fl">
    <input type="button" value="地址管理" class="btnStyle" onclick="window.location='AddressServlet?op=DoAddress&uid=${uid}'">
    <input type="button" value="个人资料修改" class="btnStyle" onclick="window.location='UsersServlet?op=edit&uid=${uid}'">
     <input type="button" value="返回首页" class="btnStyle" onclick="window.location='IndexServlet?op=allGoods2&uid=${uid}'">
    </div>
  <table class="list-style Interlaced">
   <tr>
    <th>订单编号</th>
    <th>图片</th>
    <th>下单时间</th>
    <th>收件人姓名</th>
    <th>收件人电话</th>
    <th>收件地址</th>
    <th>订单金额</th>
    <th>操作</th>
   </tr>
   <c:forEach var="go" items="${golist}">
   <tr>
    <td align="center">
      ${go.oid}
    </td>
     <td class="center">
     <img src="${go.gpicpath}" class="imgshow"></img>
    </td>
    <td class="center">
     <span class="block">${go.urealName}</span>
     <span class="block">${go.otime}</span>
    </td>
    <td align="center">
      ${go.aname}
    </td>
    <td align="center">
      ${go.aphone}
    </td>
    <td align="center" >
     ${go.aaddress}
    </td>
    <td class="center">
     <span><i>￥</i><b>${go.gnowprice}</b></span>
    </td>
    
    <td class="center">
   
     <a class="inline-block" title="删除订单" href="DeleteOrderServlet?op=delete&oid=${go.oid}&uid=${uid}"><img src="img/icon_trash.gif"/></a>
    </td>
   </tr>
    </c:forEach>
  </table>

 </div>
</body>
</html>
