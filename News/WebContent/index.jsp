<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css" id="theme-styles">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
function readmore(id){
	var Id = id;
	fajax("ReadmorServlet?id="+id,null,function(data){
		window.location.href="AllNewsServlet";
	})
}
</script>
<!-- 设置字符集编码，中文编码：GBK GB2312 国际编码集：utf-8-->
			<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
			<!-- 申明当前页面的三要素 -->
			<title>lovelive</title><!-- 网页标题，字数上限31个字 -->
			<meta http-equiv="keywords" content="" /><!-- 设置搜索引擎关键字 -->
			<meta http-equiv="description" content="" /><!-- 设置内容简介，字数上限76个字 -->
			<!-- 申明网页制作者 -->
			<meta name="author" content="" />
			<!-- =============================  css样式表 start ==========================  -->
			<link rel="stylesheet" type="text/css" href="res/css/default.css"><!-- 引用外部样式表  -->
			<link rel="stylesheet" type="text/css" href="res/css/index.css"><!-- 引用外部样式表  -->
			<!-- 内部样式表 -->
			<style type="text/css">
				
			</style>
			<!-- =============================  css样式表  end ==========================  -->
			<!-- 内部JS脚本 -->
			<script src="res/js/jquery-1.7.2.js"></script>
			<script src="res/js/scrollAd.js"></script>
			<script type="text/javascript">
				$(function(){
					$(".hot li:eq(3),.sift li:eq(2),.sift li:eq(6),.sift li:eq(10),.sift li:eq(14),.sift li:eq(18)").addClass("small-item2");
					
				});
			</script>
</head>
<body>
<!-- 头部开始 -->
			<!-- 头部开始 -->
		<!-- 头部结束 -->
			<!-- 头部结束 -->
			
			<!-- 轮播图开始 -->
			<div id="img-box">
				<ol></ol>
				<ul>
					<li class="active" style="left:0;z-index:11;">
						<a href="#"><img src="images/top1.jpg"/></a>
					</li>
					<li>
						<a href="#"><img src="images/top2.jpg"/></a>
					</li>
					<li>
						<a href="#"><img src="images/top3.jpg"/></a>
					</li>
					<li>
						<a href="#"><img src="images/top4.jpg"/></a>
					</li>
					<li>
						<a href="#"><img src="images/top5.jpg"/></a>
					</li>
				</ul>
			</div>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<header>
	<div class="widewrapper subheader">
		<div class="container">
			<div class="clean-breadcrumb">
				<a href="#">Blog</a>
			</div>

			<div class="clean-searchbox">
				<form action="#" method="get" accept-charset="utf-8">
					<div class="collapse navbar-collapse">
				<ul class="nav nav-pills navbar-nav">

					<li><a href="NewsServlet">主页</a></li>
				</ul>
			</div>
				</form>
			</div>
		</div>
	</div>
	</header>

	<div class="widewrapper main">
		<div class="container">
			<div class="row">
				<div class="col-md-8 blog-main">
					<div class="row">
						<c:forEach items="${list }" var="news">
							<div class="col-md-6 col-sm-6">
								<li id="${news.n_id}"><article class=" blog-teaser">
									<header> <img src="${news.n_image}" alt="">
									<h3>
										<a onclick="readmore(${news.n_id})">${news.n_title}</a>
									</h3>
									<span class="meta">${news.n_time}</span>
									<hr>
									</header>
									<div class="body"
										style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${news.n_thing}</div>
									<div class="clearfix">
										<a class="btn btn-clean-one" onclick="readmore(${news.n_id})">Read
											more</a>
									</div>
									</article></li>
							</div>
						</c:forEach>
					</div>

					<div class="paging">
						<a href="#" class="older">Older Post</i></a>
					</div>
				</div>
				<aside class="col-md-4 blog-aside">

				<div class="aside-widget">
					<header>
					<h3>Featured Post</h3>
					</header>
					<div class="body">

						<ul class="clean-list">
							
							
							<c:forEach items="${listapp }" var="news">
								<li><a href="">${news.n_title}</a></li>
							</c:forEach>
							
						</ul>

					</div>
				</div>

			
				</aside>
			</div>
		</div>
	</div>

	<footer>
	<div class="widewrapper footer">
		<div class="container">
			<div class="row">
				<div class="col-md-4 footer-widget">
					<h3>
						<i class="fa fa-user"></i>About
					</h3>

					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab
						animi laboriosam nostrum consequatur fugiat at, labore praesentium
						modi, quasi dolorum debitis reiciendis facilis, dolor saepe sint
						nemo, earum molestias quas.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Dolorum, error aspernatur assumenda quae eveniet.</p>
				</div>

				<div class="col-md-4 footer-widget">
					<h3>
						<i class="fa fa-pencil"></i> Recent Post
					</h3>
					<ul class="clean-list">
						<li><a href="">Clean - Responsive HTML5 Template</a></li>
						<li><a href="">Responsive Pricing Table</a></li>
						<li><a href="">Yellow HTML5 Template</a></li>
						<li><a href="">Blackor Responsive Theme</a></li>
						<li><a href="">Portfolio Bootstrap Template</a></li>
						<li><a href="">Clean Slider Template</a></li>
					</ul>
				</div>

				<div class="col-md-4 footer-widget">
					<h3>
						<i class="fa fa-envelope"></i>Contact Me
					</h3>

					<p>Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Nihil fugiat, cupiditate veritatis excepturi tempore explicabo.</p>
					<div class="footer-widget-icon">
						<i class="fa fa-facebook"></i><i class="fa fa-twitter"></i><i
							class="fa fa-google"></i>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="widewrapper copyright">
		Copyright 2015 More Templates <a href="http://www.cssmoban.com/"
			target="_blank" title="模板之家">模板之家</a> - Collect from <a
			href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
	</div>
	</footer>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/modernizr.js"></script>

</body>
</html>