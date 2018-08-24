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
<title>新增商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>

 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>新增商品</em></span>
  </div>
  <form action="upLoadServlet" method="post" enctype="multipart/form-data" onsubmit="return check_edit()">
  <table class="list-style">
   <tr>
    <td style="text-align:right;width:15%;" >商品名称：</td>
    <td>
     <input type="text" class="textBox" name="gname" value=""/>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;width:10%;">商品分类：</td>
    <td>
     <select class="textBox" name="gtype" value="">
     <option>请选择...</option>
      <option>篮球鞋</option>
      <option>跑鞋</option>
      <option>休闲鞋</option>
      <option>运动装备</option>
      <option>运动服饰</option>
      <option>其他</option>
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品品牌：</td>
    <td>
     <select class="textBox" name="gbrand" value="">
     <option>请选择...</option>
      <option>耐克</option>
      <option>AJ</option>
      <option>阿迪达斯</option>
      <option>三叶草</option>
      <option>新百伦</option>
      <option>李宁</option>
      <option>匡威</option>
      <option>其他</option>
     </select>
    </td>
   </tr>
   
   <tr>
   <td style="width:15%;text-align:right;">上传图片：</td>
    <td><input type="file" name="gpicpath" value=""/></td>
   </tr>
 
   <tr>
   <td style="text-align:right;width:15%;" >原价：</td>
    <td>
              ￥<input type="text" class="textBox length-long" name="goriprice" value=""/>
    </td>
   </tr>
   
   <tr>
   <td style="text-align:right;width:15%;" >现价：</td>
    <td>
              ￥<input type="text" class="textBox length-long" name="gnowprice" value=""/>
    </td>
    </tr>
    
      <tr>
   <td style="text-align:right;width:15%;" >折扣率：</td>
    <td>
     <input type="text" class="textBox length-long" name="gdiscount" value=""/>折
    </td>
    </tr>
   
    <tr>
   <td style="text-align:right;width:15%;" >团购天数：</td>
    <td>
     <input type="text" class="textBox length-long" name="gtime" value=""/>天
    </td>
    </tr>
    
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" value="添加" class="tdBtn"/></td>
   </tr>
  </table>
   </form>
 </div>

</body>
</html>
