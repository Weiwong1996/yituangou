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
 <head>
    <title>商品详情</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="N-Air Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() {setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<meta charset utf="8">
		<!--fonts-->
		<link href='https://fonts.googleapis.com/css?family=Fredoka+One' rel='stylesheet' type='text/css'>
		
		<!--fonts-->
		<!--bootstrap-->
			 <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<!--coustom css-->
			<link href="css/style.css" rel="stylesheet" type="text/css"/>
        <!--shop-kart-js-->
        <script src="js/simpleCart.min.js"></script>
		<!--default-js-->
			<script src="js/jquery-2.1.4.min.js"></script>
		<!--bootstrap-js-->
			<script src="js/bootstrap.min.js"></script>
		<!--script-->
         <!-- FlexSlider -->
            <script src="js/imagezoom.js"></script>
              <script defer src="js/jquery.flexslider.js"></script>
            <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

            <script>
            // Can also be used with $(document).ready()
            $(window).load(function() {
              $('.flexslider').flexslider({
                animation: "slide",
                controlNav: "thumbnails"
              });
            });
            </script>
        <!-- //FlexSlider-->
    </head>
    <body>
        <div class="clearfix"></div>
                </div>
                <!---menu-----bar--->
                <div class="header-botom">
                    <div class="content white">
                    <nav class="navbar navbar-default nav-menu" role="navigation">
                    
                        <!--/.navbar-header-->

						<div class="collapse navbar-collapse collapse-pdng"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav nav-font">
						</div>
						</ul>
                                </li>
                   
                              
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <!--/.navbar-collapse-->
                        <div class="clearfix"></div>
                    </nav>
                    <!--/.navbar-->   
                        <div class="clearfix"></div>
                    </div>
                    <!--/.content--->
                </div>
                    <!--header-bottom-->
            </div>
        </div>
        <div class="showcase-grid">
            <div class="container">
                <div class="col-md-8 showcase">
                    <div class="flexslider">
                          <ul class="slides">                     		
                            <li data-thumb="${gpic}">
                                <div class="thumb-image"> <img src="${gpic}" data-imagezoom="true"  class="img-responsive"> </div>
                            </li>
                            <li data-thumb="${gpic1}">
                                 <div class="thumb-image"> <img src="${gpic1}" data-imagezoom="true" class="img-responsive"> </div>
                            </li>
                            <li data-thumb="${gpic2}">
                               <div class="thumb-image"> <img src="${gpic2}" data-imagezoom="true" class="img-responsive"> </div>
                            </li>                   
                          </ul>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="col-md-4 showcase">
                    <div class="showcase-rt-top">
                        <div class="pull-left shoe-name">
                            <h3>${gname}</h3>
                            <p>${gbrand}</p>
                            <h4>￥${gprice}</h4>
                        </div>
                        <div class="pull-left rating-stars">
                            <ul>
    <li><a href="#" class="active"><span class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
    <li><a href="#" class="active"><span class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
    <li><a href="#" class="active"><span class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
    <li><a href="#"><span class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
    <li><a href="#"><span class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a></li>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <hr class="featurette-divider">
                    <div class="shocase-rt-bot">
                        <div class="float-qty-chart">
                        <ul>
                            <li class="qty">
                                <h3>尺码</h3>
                                <select class="form-control siz-chrt">
                                  <option>35</option>
                                  <option>36</option>
                                  <option>37</option>
                                  <option>38</option>
                                  <option>39</option>
                                  <option>40</option>
                                   <option>41</option>
                                  <option>42</option>
                                   <option>43</option>
                                  <option>44</option>
                                   <option>45</option>
                                  <option>46</option>
                                </select>
                                
                            </li>
                         
                        </ul>
                        <div class="clearfix"></div>
                        </div>
                        <ul>
                            <li class="ad-2-crt simpleCart_shelfItem">
                                <a class="btn item_add" href="IndexServlet?op=a" role="button"><font size=7>立即团购</font></a>
               
                            </li>
                        </ul>
                    </div>
                    <div class="showcase-last">
                        <h3>购买须知</h3>
                        <ul>
                            <li>1、什么是团购?
用户下单识货团购是以为用户和卖家提供更直接、便捷的交易渠道为初衷，以为双方提供良好、诚信、互惠互利的网上购物 体验为目标的专业运动类正品导购平台。通过对卖家资质、产品质量、价格优势三个维度严格的要求和筛选，为用户提供更 专业、直接的导购服务，满足用户足不出户就可以在网上放心购物的需求。</li>
                            <li>2、团购购买流程是怎样的？
在识货团购页面挑选自己喜欢的商品进入对应淘宝店家</li>
                          
                        </ul>
                    </div>
                </div>
        <div class="clearfix"></div>
            </div>
        </div>
        
        <div class="you-might-like">
            <div class="container">
                <h3 class="you-might">你可能会喜欢</h3>
                <div class="col-md-4 grid-stn simpleCart_shelfItem">
                     <!-- normal -->
                        <div class="ih-item square effect3 bottom_to_top">
                            <div class="bottom-2-top">
                    <div class="img"><img src="img/grid4.jpg" alt="/" class="img-responsive gri-wid"></div>
                            <div class="info">
                                <div class="pull-left styl-hdn">
                                    <h3>style 01</h3>
                                </div>
                                <div class="pull-right styl-price">
                                    <p><a  href="#" class="item_add"><span class="glyphicon glyphicon-shopping-cart grid-cart" aria-hidden="true"></span> <span class=" item_price">$190</span></a></p>
                                </div>
                                <div class="clearfix"></div>
                            </div></div>
                        </div>
                    <!-- end normal -->
                    <div class="quick-view">
                        <a href="single.html">Quick view</a>
                    </div>
                </div>
                <div class="col-md-4 grid-stn simpleCart_shelfItem">
                    <!-- normal -->
                        <div class="ih-item square effect3 bottom_to_top">
                            <div class="bottom-2-top">
                    <div class="img"><img src="img/grid6.jpg" alt="/" class="img-responsive gri-wid"></div>
                            <div class="info">
                                <div class="pull-left styl-hdn">
                                    <h3>style 01</h3>
                                </div>
                                <div class="pull-right styl-price">
    <p><a  href="#" class="item_add"><span class="glyphicon glyphicon-shopping-cart grid-cart" aria-hidden="true"></span> <span class=" item_price">$190</span></a></p>
                                </div>
                                <div class="clearfix"></div>
                            </div></div>
                        </div>
                    <!-- end normal -->
                    <div class="quick-view">
                        <a href="single.html">Quick view</a>
                    </div>
                </div>
                <div class="col-md-4 grid-stn simpleCart_shelfItem">
                    <!-- normal -->
                        <div class="ih-item square effect3 bottom_to_top">
                            <div class="bottom-2-top">
                    <div class="img"><img src="img/grid3.jpg" alt="/" class="img-responsive gri-wid"></div>
                            <div class="info">
                                <div class="pull-left styl-hdn">
                                    <h3>style 01</h3>
                                </div>
                                <div class="pull-right styl-price">
    <p><a  href="#" class="item_add"><span class="glyphicon glyphicon-shopping-cart grid-cart" aria-hidden="true"></span> <span class=" item_price">$190</span></a></p>
                                </div>
                                <div class="clearfix"></div>
                            </div></div>
                        </div>
                    <!-- end normal -->
                    <div class="quick-view">
                        <a href="single.html">Quick view</a>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        
        <div class="footer-grid">
            <div class="container">
              
                <div class="col-md-6 re-ft-grd">
             
             
                </div>
                <div class="col-md-2 re-ft-grd">
                    <div class="bt-logo">
                     
                    </div>
                </div>
        <div class="clearfix"></div>
            </div>
            <div class="copy-rt">
                <div class="container">
            <p>Copyright &copy; 2018.Company name All rights reserved.</p>
                </div>
            </div>
        </div>
    </body>
</html>
