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
<title>地址</title>
<link href="css/address.css" rel="stylesheet">
<script type="text/javascript">
			function changeImg() {
				var imgObj = document.getElementById("img");
				imgObj.src = "CheckCodeServlet?ran=" + Math.random();
			}
		</script>
<style type="text/css">
body {
	background-image: url(img/bodyBackground.jpg);
	position: relative;
}

.container {
	background-color: white;
	width: 550px;
	height: 500px;
	margin: 0 auto;
	margin-top: 184px;
	border: 1px solid red;
	text-align: center;
	border-radius: 42px;
}

.container div {
	padding-top: 13px;
}

.btn {
	background-color: indianred;
	width: 117px;
	height: 42px;
	margin-top: 33px;
	margin-left: 40px;
}

.formbtn {
	font-family: "微软雅黑";
	font-weight: bold;
	font-size: 19px;
}

.haiguan {
	/*position: absolute;
	/*left: 10px;
	top: 10px;*/ */
	
}

.haiguan img {
	width: 488px;
	height: 64px;
}

.hzw-city-picker {
	top: 361px !important;
}

.address {
	    height: 115px;
    border-radius: 19px;
    margin: 0 auto;
    background-color: white;
    width: 1174px;
    margin-top: 29px;
    text-align: center;
    }
.biaoti{
    text-align: center;
    color: red;
    background-color: cornsilk;
    }
.detil:hover{
    background-color: cornsilk;
    }
</style>
</head>
<body>
	<div class="container">
		<form class="form-inline" role="form"  method="post" action="AddressServlet?op=add&uid=${uid}">
			<div class="haiguan">
				<img src="img/haiguan.png">
			</div>
			<hr />
			<div class="form-group has-success">
				<font color="red">*</font><label for="username"
					class="control-label">收货人姓名</label> <input type="text"
					id="username" name="aname" class="form-control" placeholder=""
					width="1000px">

			</div>
			<br />
			<div class="form-group has-success">
				<font color="red">*</font><label for="userpwd" class="control-label">身份证&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input type="text" id="userpwd" name="aidentify"
					class="form-control" placeholder="">
			</div>
			<br />
			<div class="form-group has-success">
				<font color="red">*</font><label for="userrealname"
					class="control-label">邮编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input type="userrealname" id="userrealname" name="amail"
					class="form-control" placeholder="">
			</div>
			<br />

			<div class="form-group has-success">
				<font color="red">*</font><label for="userpwd" class="control-label">电
					话&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
					type="useridentity" id="useridentity" name="aphone"
					class="form-control" placeholder="">
			</div>
			<br /> <font color="red">*</font>
			<div class="form-group has-success">
				<label for="userpwd" class="control-label">详细地址&nbsp;&nbsp;&nbsp;&nbsp;</label><input
					type="text" id="cityChoice" name="aaddress" class="form-control">
			</div>
			<br> <br />

			<button type=submit class="btn">
				<font class="formbtn"><font>保存</font>
			</button>
			<button type="button" class="btn"
				onclick="window.location='UsersServlet?op=myOder&uid=${uid}'">
				<font class="formbtn"><font>返回</font>
			</button>
		</form>
	</div>
	
		<table class="address"  align="center">
			<tr class="biaoti">
				<td>收件人</td>
				<td>收件地址</td>
				<td>身份证</td>
				<td>电话</td>
				<td>邮编</td>
				<td>操作</td>
			</tr>
			<c:forEach var="a" items="${alist}">
				<tr class="detial">
					<td>${a.aname}</td>
					<td>${a.aaddress}</td>
					<td >${a.aidentify}</td>
					<td >${a.aphone}</td>
					<td>${a.amail}</td>
					<td ><a href="AddressServlet?op=delete&aid=${a.aid}&uid=${uid}">删除</a></td>
				</tr>
			</c:forEach>
		


			<script src="js/jquery.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/jquery.qrcode.min.js"></script>
			<script src="js/jquery.min.js"></script>
			<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
			<script type="text/javascript" src="js/city-data.js"></script>
			<script type="text/javascript" src="js/hzw-city-picker.min.js"></script>
			<script>
				var cityPicker = new HzwCityPicker({
					data: data,
					target: 'cityChoice',
					valType: 'k-v',
					hideCityInput: {
						name: 'city',
						id: 'city'
					},
					hideProvinceInput: {
						name: 'province',
						id: 'province'
					},
					callback: function() {
						alert('确认选择！');
					}
				});

				cityPicker.init();
			</script>
</body>
</html>
