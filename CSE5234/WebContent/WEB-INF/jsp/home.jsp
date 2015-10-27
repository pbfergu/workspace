<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/base_template/css/mystyle.css" rel="stylesheet">
</head>
<body>
<%@include file="Header.jsp"%>
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="http://www.glasses.com/dyn-images/default/Round_Collection_Page2.jpg" width="1200" alt="rayban">
        </div>
        <div class="item">
            <img src="http://www.glasses.com/dyn-images/default/Wayfarer_Collection_Page.jpg" width="1200"  alt="cartier">
        </div>

        <div class="item">
            <img src="http://www.glasses.com/dyn-images/default/Translucent_Collection_Page.jpg" width="1200" alt="me at my work">
        </div>

        <div class="item">
            <img src="http://www.glasses.com/dyn-images/default/wayfarer-collection-hero.jpg" width="1200" alt="Flower">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>