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
<title>订单列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
<script>
		$(function(){
			window.onload=(function(){
			  	$.ajax({
					type:"get",
					url:"getAllOrdersServlet?op=all",
					data:{
						"uname":"uname",
					},
					dataType:"json", 
					success: function(data){
						//在浏览器的控制台输出
						console.log(data);
						
						var info = "";
						$.each(data, function(i,n) {
							var oid = data[i].oid;
							var otime = data[i].otime;
							var gname = data[i].gname;
							var uname = data[i].uname;
							var aname = data[i].aname;
							var a='<a href="">修改&nbsp;&nbsp;&nbsp;</a>';							
							var b='<a href="getAllOrdersServlet?op=delete&oid='+oid+'">删除</a>';
							
							var Orderslist = "<tr><th>"+oid+"</th><th>"+otime+"</th><th>"+gname+"</th><th>"+uname+"</th><th>"+aname+"</th><th>"+a+""+b+"</th></tr>";
							$("#info tr:eq(0)").after(Orderslist);	
						});
					},
					
					async:true
				});
			});
			
			//按ID查找用户
			$("#btn1").click(function(){
				var uname=$("input[name=uname]").val();
			  	$.ajax({
					type:"get",
					url:"getAllOrdersServlet?op=uname",
					data:{
						"uname":uname,
					},
					dataType:"json", 
					
					success: function(data){
						console.log(data);
						//清空表
						$("#info tr:gt(0)").html("");
						var info = "";
						$.each(data, function(i,n) {
							var oid = data[i].oid;
							var otime = data[i].otime;
							var gname = data[i].gname;
							var uname = data[i].uname;
							var aname = data[i].aname;
							var a='<a href="">修改&nbsp;&nbsp;&nbsp;</a>';							
							var b='<a href="getAllOrdersServlet?op=delete&oid='+oid+'">删除</a>';
							
							var Orderslist = "<tr><th>"+oid+"</th><th>"+otime+"</th><th>"+gname+"</th><th>"+uname+"</th><th>"+aname+"</th><th>"+a+""+b+"</th></tr>";
							$("#info tr:eq(0)").after(Orderslist);	
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
    <span class="modular fl"><i class="order"></i><em>订单列表</em></span>
  </div>
  <div class="operate">
    <img src="img/icon_search.gif"/>
    <input type="text" class="textBox length-long" placeholder="输入订单编号或收件人姓名..." name="uname"/>
    <input type="submit" value="查询" class="tdBtn" id="btn1"/>
  </div>
  <table class="list-style Interlaced" id="info">
   <tr>
    <th>订单编号</th>
    <th>下单时间</th>
    <th>商品名</th>
    <th>客户名</th>
    <th>收件地址</th>
    <th>操作</th>
   </tr>
   <!-- <tr>
    <td>
     <input type="checkbox"/>
     <a href="order_detail.html">2015041803225</a>
    </td>
    <td class="center">
     <span class="block">DeatGhost</span>
     <span class="block">2015-04-18 12:00</span>
    </td>
    <td width="450">
     <address>陕西省西安市未央区255号</address>
    </td>
    <td class="center">
     <span><i>￥</i><b>58.00</b></span>
    </td>

    <td class="center">
     <a href="orderDetial.jsp" class="inline-block" title="查看订单"><img src="img/icon_view.gif"/></a>
     <a class="inline-block" title="删除订单"><img src="img/icon_trash.gif"/></a>
    </td>
   </tr> -->
  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="打印订单" class="btnStyle"/>
	   <input type="button" value="配货" class="btnStyle"/>
	   <input type="button" value="删除订单" class="btnStyle" />
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
