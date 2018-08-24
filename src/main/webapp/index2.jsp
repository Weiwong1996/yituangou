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
<title>易团购</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300">
<link href='http://fonts.googleapis.com/css?family=PT+Sans'
	rel='stylesheet' type='text/css'>
<link href="http://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href=" css/bootstrap.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/selfdeclare.css">

</head>

<body>
	<div>
		<div class="sDiv">
			<div class="sDiv1">
				<table>
					<tr>
						<td><img src="img/logo.jpg"></td>
						<td>
							<p>运动潮流好物</p>
							<p>精选正品好价</p>
						</td>
					</tr>
				</table>
			</div>

			<div class="search_goods">
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入商品...">
					</div>
					<button type="button" class="btn btn-default btn-md">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						搜索
					</button>
				</form>
			</div>
			<div class="userlogin_icon">
				
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					用户：${uname}  
			
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-default btn-md"
					onclick="window.location='UsersServlet?op=myOder&uid=${uid}'">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					我的订单
				</button>
				
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-default btn-md"
					onclick="window.location='IndexServlet?op=allGoods'">
					注销
				</button>
			</div>
			
		</div>
	</div>

	<!-- End Header -->

	<!-- Begin #carousel-section -->
	<section id="carousel-section" class="section-global-wrapper">
		<div class="container-fluid-kamn">
			<div class="row">
				<div id="carousel-1" class="carousel slide" data-ride="carousel">

					<!-- Indicators -->
					<ol class="carousel-indicators visible-lg">
						<li data-target="#carousel-1" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-1" data-slide-to="1"></li>
						<li data-target="#carousel-1" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<!-- Begin Slide 1 -->
						<div class="item active">
							<img src="img/ad001.jpg" height="400"
								alt="Image of first carousel">
							<div class="carousel-caption"></div>
						</div>
						<!-- End Slide 1 -->

						<!-- Begin Slide 2 -->
						<div class="item">
							<img src="img/ad02.jpg" height="400"
								alt="Image of second carousel">
							<div class="carousel-caption"></div>
						</div>
						<!-- End Slide 2 -->

						<!-- Begin Slide 3 -->
						<div class="item">
							<img src="img/ad03.jpg" height="400"
								alt="Image of third carousel">
							<div class="carousel-caption"></div>
						</div>
						<!-- End Slide 3 -->
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-1"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-1"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>
	</section>
	<!-- End #carousel-section -->

	<!-- Begin #services-section -->
	<section id="services" class="services-section section-global-wrapper">
		<div class="container">
			<div class="row">
				<div class="services-header">
					<div class="t0">
						<span><strong>热门团购</strong></span>
					</div>
					<div class="goods-screen-box">
						<div class="inner">
							<div class="inner-width">
								<ol>
									<li class="clearfix" id="sex_list">
										<div class="t1">适用人群</div>
										<div class="t2">
											<a href="#" class="">通用<s></s></a> <a href="#" class="">男生<s></s></a>
											<a href="#" class="">女生<s></s></a> <a href="#" class="">儿童<s></s></a>
										</div>
									</li>
									<li class="clearfix" id="type_list">
										<div class="t1">分&emsp;&emsp;类</div>
										<div class="t2">
											<a href="IndexServlet?op=byType2&type=篮球鞋" class="">篮球鞋<s></s></a> <a href="IndexServlet?op=byType2&type=跑鞋" class="">跑鞋<s></s></a>
											<a href="IndexServlet?op=byType2&type=休闲鞋" class="">休闲鞋<s></s></a> <a href="IndexServlet?op=byType2&type=运动装备" class="">运动装备<s></s></a>
											<a href="IndexServlet?op=byType2&type=运动服饰" class="">运动服饰<s></s></a> <a href="IndexServlet?op=byType2&type=其它" class="">其它<s></s></a>
										</div>
									</li>
									<li class="clearfix" id="brand_list">
										<div class="t1">品&emsp;&emsp;牌</div>
										<div class="t2">
											<a href="IndexServlet?op=byBrand2&type=${gtype}&brand=耐克" class="">耐克<s></s></a> <a href="IndexServlet?op=byBrand2&type=${gtype}&brand=AJ" class="">AJ<s></s></a>
											<a href="IndexServlet?op=byBrand2&type=${gtype}&brand=阿迪达斯" class="">阿迪达斯<s></s></a> <a href="IndexServlet?op=byBrand2&type=${gtype}&brand=三叶草" class="">三叶草<s></s></a>
											<a href="IndexServlet?op=byBrand2&type=${gtype}&brand=新百伦" class="">新百伦<s></s></a> <a href="IndexServlet?op=byBrand2&type=${gtype}&brand=李宁" class="">李宁<s></s></a>
											<a href="IndexServlet?op=byBrand2&type=${gtype}&brand=匡威" class="">匡威<s></s></a> <a href="IndexServlet?op=byBrand2&type=${gtype}&brand=其它" class="">其它<s></s></a>
										</div>
									</li>
									<li class="clearfix" >
									<div class="t1">筛&emsp;&emsp;选</div>
										<div class="t2">										
										<table>
										<tr>
											<td><a href="IndexServlet?op=allGoods2">默认</a></td>
											<td><a href="IndexServlet?op=price2">价格</a></td>
											<td><a href="IndexServlet?op=discount2">折扣</a></td>
										</tr>
										</table>
										</div>
									</li>
								</ol>															
							</div>
						</div>
					</div>

					<!--<h3 class="services-header-title">Our Mission</h3>
                    <p class="services-header-body"><em> Things we provide in Office </em>  </p><hr>-->
				</div>
			</div>

			<!--以下为商品信息  -->
			<div class="container">
				<c:forEach var="g" items="${glist}">
					<div class="goods_items">
						<div class="pic_goods" aglin="center">
							<img src="${g.gpicpath}">
						</div>
						<div class="h2" aglin="center">
							<a><font>${g.gname}</font></a>
						</div>
						<div class="goods_price">
							<div class="t2">
								<span class="s2"><s>¥</s>${g.gnowprice}</span><span class="s1">¥${g.goriprice}</span>
							</div>
							<div class="t1">${g.gdiscount}折</div>
							<a href="IndexServlet?op=buy2&gpic=${g.gpicpath}&gname=${g.gname}&gprice=${g.gnowprice}&gbrand=${g.gbrand}&uid=${uid}&gid=${g.gid}" class="t1">立即抢购</a>
							
						</div>
						<div id="day" class="goods_timelimit">
							<span class="glyphicon glyphicon-time">活动剩余<font
								color="red" size=10>${g.gtime}</font>天
							</span>
						</div>
					</div>
				</c:forEach>
			</div>
			<p align="right">

				当前页数:${currentIndex}/${totalPage}]&nbsp; <a
					href="IndexServlet?op=${op}&currentIndex=${1}">首页</a> <a
					href="IndexServlet?op=${op}&currentIndex=${currentIndex-1}">上一页</a>
				<a href="IndexServlet?op=${op}&currentIndex=${currentIndex+1}">下一页</a>
				<a href="IndexServlet?op=${op}&currentIndex=${totalPage}">末页</a>
			</p>
			<!--结束商品信息  -->

			<!-- Footer -->
			<footer>
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<h3>
								<i class="fa fa-map-marker"></i> Contact:
							</h3>
							<p class="footer-contact">
								Address: Zhejiang Province,Zhejiang water conservancy and
								hydropower college, China<br> <br> Group: No.2<br>
								<br> Members:王威,程力东,夏若冰 <br>
							</p>
						</div>
						<div class="col-md-4">
							<h3>
								<i class="fa fa-external-link"></i> 购物指南
							</h3>
							<p>
								<a href="#"> 信息</a>
							</p>
							<p>
								<a href="#"> 付款</a>
							</p>
							<p>
								<a href="#"> 配送</a>
							</p>
							<p>
								<a href="#"> 退货 </a>
							</p>
						</div>
						<div class="col-md-4">
							<h3>
								<i class="fa fa-heart"></i> 帮助
							</h3>
							<div class="col-md-4">
								<p>
									<a href="#"> 客户服务</a>
								</p>
								<p>
									<a href="#"> 我的eBuy</a>
								</p>
								<p>
									<a href="#"> 隐私及法律条款</a>
								</p>
								<p>
									<a href="#"> 联系我们 </a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</footer>
			<!-- End Footer -->

			<div class="copyright text center">
				<p>
					&copy; Copyright 2018, <a href="#">eBuy.com</a>. 易购网
				</p>
			</div>

			<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/wow.min.js"></script>
			<script>
				new WOW().init();
			</script>
</body>

</html>
