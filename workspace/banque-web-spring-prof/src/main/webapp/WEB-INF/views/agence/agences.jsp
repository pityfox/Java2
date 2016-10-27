<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="agences.title"/></title>
</head>
<body>

<table border="1">
	<tr>
		<th><spring:message code="agences.numBanque"/></th>
		<th><spring:message code="agences.numAgence"/></th>
		<th><spring:message code="agences.libelle"/></th>
		<th><spring:message code="agences.horaires"/></th> 
		<th></th>
		<th></th>
	</tr>
	
	<c:forEach items="${agences}" var="agence">
		<c:url var="editUrl" value="/agence/edit">
			<c:param name="numBanque" value="${agence.id.numBanque}"/>
			<c:param name="numAgence" value="${agence.id.numAgence}"/>
		</c:url>
		<c:url var="deleteUrl" value="/agence/delete">
			<c:param name="numBanque" value="${agence.id.numBanque}"/>
			<c:param name="numAgence" value="${agence.id.numAgence}"/>
		</c:url>
		<tr>
			<td>${agence.id.numBanque}</td>
			<td>${agence.id.numAgence}</td>
			<td>${agence.libelle}</td>
			<td>${agence.horaires}</td>
			<td><a href="${editUrl}"><spring:message code="agences.edit"/></a></td>
			<td><a href="${deleteUrl}"><spring:message code="agences.delete"/></a></td>
		</tr>
	</c:forEach>
	<c:url var="addUrl" value="add"/>
	<tr>
		<td colspan="7"><a href="${addUrl}"><spring:message code="agences.add"/></a></td>
	</tr>
</table>

</body>
</html>