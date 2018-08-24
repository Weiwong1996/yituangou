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
<title>用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
<script>
		$(function(){
			//显示出全部用户
			window.onload=(function(){
			  	$.ajax({
					type:"get",
					url:"getAllUsersServlet?op=all",
					data:{
						"uid":"uid",
					},
					dataType:"json", 
					success: function(data){
						console.log(data);
						var info = "";
						$.each(data, function(i,n) {
							var uid = data[i].uid;
							var uidentify = data[i].uidentify;
							var uname = data[i].uname;
							var uphone = data[i].uphone;
							var upwd = data[i].upwd;
							var urealName = data[i].urealName;
							var a='<a href="">修改&nbsp;&nbsp;&nbsp;</a>';							
							var b='<a href="UsersServlet?op=delete&uid='+uid+'">删除</a>';
							var Userlist = "<tr><th>"+uid+"</th><th>"+uname+"</th><th>"+upwd+"</th><th>"+uphone+"</th><th>"+urealName+"</th><th>"+uidentify+"</th><th>"+a+""+b+"</th></tr>";
							$("#info tr:eq(0)").after(Userlist);	
						});
					},
					
					async:true
				});
			});
			
			//按ID查找用户
			$("#btn1").click(function(){
				var forid=$("input[name=for_id]").val();
			  	$.ajax({
					type:"get",
					url:"getAllUsersServlet?op=sb_ID",
					data:{
						"for_id":forid,
						"uid":"uid",
					},
					dataType:"json", 
					success: function(data){
						$("#info tr:gt(0)").html("");
						var info = "";
						var uid = data.uid;
						var uidentify = data.uidentify;
						var uname = data.uname;
						var uphone = data.uphone;
						var upwd = data.upwd;
						var urealName = data.urealName;
						var a='<a href="UsersServlet?op=edit&uid='+uid+'">修改&nbsp;&nbsp;&nbsp;</a>';
						var b='<a href="UsersServlet?op=delete&uid='+uid+'">删除</a>';
						var User = "<tr><th>"+uid+"</th><th>"+uname+"</th><th>"+upwd+"</th><th>"+uphone+"</th><th>"+urealName+"</th><th>"+uidentify+"</th><th>"+a+""+b+"</th></tr>";
						$("#info tr:eq(0)").after(User);	
					},
					
					async:true
				});
			});
		
		})

	</script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>会员列表</em></span>
   
  </div>
  <div class="operate">
    <input type="text" class="textBox length-long" placeholder="输入会员ID" name="for_id"/>
    <input id="btn1" type="submit" value="查询" class="tdBtn" />
  </div>
  <table id="info" class="list-style Interlaced">
   <tr>
     <th>编号</th>
     <th>用户名</th>
     <th>密码</th>
     <th>手机号码</th>
     <th>真实姓名</th>
     <th>身份证</th>
     <th>操作</th>
   </tr>
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

