<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>My Rafting Store</title>
<!-- Angular JS -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/global.js"></script>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

<!-- Carousel CSS -->
<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

<!-- Main CSS -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<c:url value="/" /> ">River
							Outfitter's Exchange</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="<c:url value="/" /> ">Home</a></li>
							<li><a href="<c:url value="/product/productList" />">Products</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<ul class="nav navbar-nav pull-right">
							<sec:authorize access="authenticated" var="authenticated"></sec:authorize>
							<c:choose>
								<c:when test="${authenticated}">
									<li>
										<p class="navbar-text">
											Welcome <sec:authentication property="name" />
											<a href="<c:url value="/logout" />">Logout</a>
										</p>
									</li>
								</c:when>
								<c:otherwise>
									<li><a href="<spring:url value="/login/"/>">Sign In</a></li>
									<li><a href="<c:url value="/register" />">Register</a></li>
								</c:otherwise>
							</c:choose>
							<sec:authorize access="hasRole('USER')">
								<li><a href="<c:url value="/customer/cart" />">Cart</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('ADMIN')">
								<li><a href="<c:url value="/admin" />">Admin</a></li>
							</sec:authorize>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>