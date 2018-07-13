<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style.css" id="theme-styles">
</head>
<body>
	<header>
	<div class="widewrapper masthead">
		<div class="container">
			<a href="index.jsp" id="logo"> <img src="img/logo.png"
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
					<li><a href="form.jsp">添加帖子</a></li>

				</ul>
			</div>
			</nav>

		</div>
	</div>

	<div class="widewrapper subheader">
		<div class="container">
			<div class="clean-breadcrumb">
				<a href="#">Blog</a> <span class="separator">&#x2F;</span> <a
					href="#">Bootstrap</a> <span class="separator">&#x2F;</span> <a
					href="#">HTML Template</a>
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
				<c:forEach items="${change }" var="news">
					<div class="col-md-8 blog-main">
						<article class="blog-post"> <header>

						<div class="lead-image">
							<img src="${news.n_image}" alt="" class="img-responsive">

						</div>
						</header>
						<div class="body">
							<h1>${news.n_title}</h1>
							<div class="meta">
								<i class="fa fa-user"></i> John Doe <i class="fa fa-calendar"></i>
								${news.n_time}<i class="fa fa-comments"></i><span class="data"><a
									href="#comments">3 Comments</a></span>
							</div>
							<p>${news.n_thing}</p>
						</div>
						</article>
						<aside class="social-icons clearfix">
						<h3>Share on</h3>
						<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-google"></i></a> </aside>

						<aside class="comments" id="comments">
						<hr>


						</aside>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>