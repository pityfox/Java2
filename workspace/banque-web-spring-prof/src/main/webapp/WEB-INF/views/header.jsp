<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
</head>
<body>
<c:url var="home" value="/" />
<c:url var="agence" value="/agence/list" />
<c:url var="client" value="/client/list" />
	<div class="container">
	
		<div class="container-fluid">
			<nav class="navbar navbar-default">
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li ${page eq 'home'?'class=active':''}><a href="${home }">Accueil</a></li>
					<li ${page eq 'agence'?'class=active':''}><a href="${agence }">Agence</a></li>
					<li ${page eq 'client'?'class=active':''}><a href="${client }">Client</a></li>
				</ul>
			</div>
			</nav>
		</div>
	</div>
</body>
</html>