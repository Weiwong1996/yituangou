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
<title>产品列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
<script>
		$(function(){
			window.onload=(function(){
			  	$.ajax({
					type:"get",
					url:"getAllProductsServlet?op=all",
					data:{
						"uname":"uname",
					},
					dataType:"json", 
					success: function(data){
						console.log(data);
						var info = "";
						$.each(data, function(i,n) {
							var gid = data[i].gid;
							var gname = data[i].gname;
							var gbrand = data[i].gbrand;
							var gattention = data[i].gattention;
							var gdiscount = data[i].gdiscount;
							var goriprice = data[i].goriprice;
							var gnowprice = data[i].gnowprice;
							var gtime = data[i].gtime;
							var gtype = data[i].gtype;
							var a='<a href="">修改&nbsp;&nbsp;&nbsp;</a>';							
							var b='<a href="getAllProductsServlet?op=delete&gid='+gid+'">删除</a>';
							
							var Productlist = "<tr><th>"+gid+"</th><th>"+gbrand+"</th><th>"+gname+"</th><th>"+gtype+"</th><th>"+gtime+"</th><th>"+goriprice+"</th><th>"+gnowprice+"</th><th>"+gdiscount+"</th><th>"+a+""+b+"</th></tr>";
							$("#info tr:eq(0)").after(Productlist);	
						});
					},
					
					async:true
				});
			});
			
			//按ID查找用户
			$("#btn1").click(function(){
				var forbrand=$("input[name=for_brand]").val();
			  	$.ajax({
					type:"get",
					url:"getAllProductsServlet?op=brand",
					data:{
						"for_brand":forbrand,
					},
					dataType:"json", 
					success: function(data){
						console.log(data);
						//清空表
						$("#info tr:gt(0)").html("");
						var info = "";
						$.each(data, function(i,n) {
							var gid = data[i].gid;
							var gname = data[i].gname;
							var gbrand = data[i].gbrand;
							var gattention = data[i].gattention;
							var gdiscount = data[i].gdiscount;
							var goriprice = data[i].goriprice;
							var gnowprice = data[i].gnowprice;
							var gtime = data[i].gtime;
							var gtype = data[i].gtype;
							var a='<a href="">修改&nbsp;&nbsp;&nbsp;</a>';							
							var b='<a href="getAllProductsServlet?op=delete&gid='+gid+'">删除</a>';
							
							var Productlist = "<tr><th>"+gid+"</th><th>"+gbrand+"</th><th>"+gname+"</th><th>"+gtype+"</th><th>"+gtime+"</th><th>"+goriprice+"</th><th>"+gnowprice+"</th><th>"+gdiscount+"</th><th>"+a+""+b+"</th></tr>";
							$("#info tr:eq(0)").after(Productlist);	
						});
							
					},
					
					async:true
				});
			});
			
		});
	</script>
</head>

<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>产品列表</em></span>
    <span class="modular fr"><a href="addGood.jsp" class="pt-link-btn">+添加商品</a></span>
  </div>
  <div class="operate">
   
    <input type="text" class="textBox length-long" placeholder="输入产品名称..." name="for_brand"/>
    <input id="btn1" type="submit" value="查询" class="tdBtn"/>
   
  </div>
  <table class="list-style Interlaced" id="info">
   <tr>
    <th>ID编号</th>
    <th>品牌</th>
    <th>名称</th>
    <th>类型</th>
    <th>活动剩余时间</th>
    <th>原价</th>
    <th>现价</th>
    <th>折扣</th>
    <th>操作</th>
   </tr>
<!--    <tr>
    <td>
     <span>
     <input type="checkbox" class="middle children-checkbox"/>
     <i>1</i>
     </span>
    </td>
    <td class="center pic-area">NIKE</td>
    <td class="td-name">
      <span class="ellipsis td-name block">球鞋</span>
    </td>
    <td class="center">
     <span>
      <i>￥</i>
      <em>100.00</em>
     </span>
    </td>
    <td class="center">
     <span>
      <i>￥</i>
      <em>50.00</em>
     </span>
    </td>
    <td class="center">
     <span>
      <em>7.5</em>
      <i>折</i>
     </span>
    </td>
    <td class="center">
     <span>
      <i>500</i>
      <em>人</em>
     </span>
    </td>
    <td class="center">
     <span>
      <i>5</i>
      <em>天</em>
     </span>
    </td>
    <td class="center">
     <a href="http://www.baidu.com/跳转至前台页面哦" title="查看" target="_blank"><img src="img/icon_view.gif"/></a>
     <a href="edit_product.html" title="编辑"><img src="img/icon_edit.gif"/></a>
     <a title="删除"><img src="img/icon_drop.gif"/></a>
    </td>
   </tr> -->

  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="批量删除" class="btnStyle"/>
	  </div>
	  <!-- turn page -->
	  <div class="turnPage center fr">
	   <a>第一页</a>
	   <a>1</a>
	   <a>最后一页</a>
	  </div>
  </div>
 </div>
</body>
</html>
