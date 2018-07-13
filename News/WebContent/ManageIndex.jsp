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
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
function delete_product(id){
	var Id = id;
	fajax("DeleteServlte?id="+id,null,function(data){
		window.location.href="NewsServlet";
	})
}
function change_product(id){
	var Id = id;
	fajax("ChangeNewsServlet?id="+id,null,function(data){
		window.location.href="ChangeOkServlet";
	})
}
function readmore(id){
	var Id = id;
	fajax("ReadmorServlet?id="+id,null,function(data){
		window.location.href="AllNewsServlet";
	})
}
</script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css" id="theme-styles">
</head>
<body>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<header>
	<div class="widewrapper masthead">
		<div class="container">
			<a href="index.jsp" id="logo"> <img src="img/logo.jpg"
				alt="clean Blog">
			</a>

			<div id="mobile-nav-toggle" class="pull-right">
				<a href="#" data-toggle="collapse"
					data-target=".clean-nav .navbar-collapse"> <i
					class="fa fa-bars"></i>
				</a>
			</div>

			<nav class="pull-right clean-nav">
			<div class="collapse navbar-collapse">
				<ul class="nav nav-pills navbar-nav">

					<li><a href="NewsServlet">主页</a></li>
					<li><a href="AddUser.jsp">添加管理员</a></li>
					<li><a href="form.jsp">添加新帖子</a></li>

				</ul>
			</div>
			</nav>

		</div>
	</div>

	<div class="widewrapper subheader">
		<div class="container">
			<div class="clean-breadcrumb">
				<a href="#">Blog</a>
			</div>

			<div class="clean-searchbox">
				<form action="#" method="get" accept-charset="utf-8">
					<input class="searchfield" id="searchbox" type="text"
						placeholder="Search">
					<button class="searchbutton" type="submit">
						<i class="fa fa-search"></i>
					</button>
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
										<a onclick="change_product(${news.n_id})"
											class="btn btn-clean-one">修改</a>
										<a onclick="delete_product(${news.n_id})"
											class="btn btn-clean-one">删除</a>
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
								<li><a onclick="readmore(${news.n_id})">${news.n_title}</a></li>
							</c:forEach>
						</ul>

					</div>
				</div>

				<div class="aside-widget">
					<header>
					<h3>Tags</h3>
					</header>
					<div class="body clearfix">
						<ul class="tags">
							
							<li><a href="http://www.iqiyi.com/a_19rrgi8vct.html?vfm=2008_aldbd">动漫全集</a></li>
							<li><a href="https://baike.baidu.com/item/LoveLive%21/6278898?fr=aladdin#4">登场人物</a></li>
							<li><a href="https://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&ie=gb18030&word=love%20livecos&fr=ala&ala=1&alatpl=adress&pos=0&hs=2&xthttps=111111">cosplay图赏</a></li>
							<li><a href="https://www.baidu.com/link?url=qDpfkNwHCEVeRokFCRoPfR7OeZS7FW4B68j2Qph3rAK_mqTLmgje32hLGwYgnS2S-FTzwFvbhelMKtokpa7966qexRwom-yYsnmRymJsmkq&wd=&eqid=8e8af94200005494000000035b41c9d4">了解企划</a></li>
							<li><a href="http://adsr.ll.sdo.com/pc/index.html?wft_source=bdgjz_30">了解官方手游</a></li>
							<li><a href="https://www.baidu.com/link?url=qDpfkNwHCEVeRokFCRoPfR7OeZS7FW4B68j2Qph3rAK_mqTLmgje32hLGwYgnS2S-FTzwFvbhelMKtokpa796qtkpGtpP2y_K4YA2GQH157&wd=&eqid=8e8af94200005494000000035b41c9d4">音乐下载</a></li>
							<li><a href="https://baike.baidu.com/item/LoveLive%21%E5%AD%A6%E5%9B%AD%E5%81%B6%E5%83%8F%E7%A5%AD/14587488?fr=aladdin">百度百科</a></li>
							<li><a href="#">返回顶部</a></li>
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