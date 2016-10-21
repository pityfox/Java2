<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="monBean" scope="request" class="java.lang.String"/>
<% monBean="Le contenu de mon bean"; %>

Ma première page<br/>
<hr/>
<%@include file="ForIncludeByDirective.jsp" %>
<hr/>
<jsp:include page="ForIncludeByTagJsp.jsp"></jsp:include>
</body>
</html>