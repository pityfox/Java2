<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<title><spring:message code="clients.title" /></title>
</head>
<body>

	<div class="container">
	<h2><spring:message code="clients.title" /></h2>
		<table class="table table-striped">
			<tr>
				<th><spring:message code="clients.id" /></th>
				<th><spring:message code="clients.titre" /></th>
				<th><spring:message code="clients.nom" /></th>
				<th><spring:message code="clients.prenom" /></th>
				<th><spring:message code="clients.dtNaissance" /></th>
				<th></th>
				<th></th>
			</tr>

			<c:forEach items="${mesClients}" var="client">
				<c:url var="editUrl" value="/client/edit">
					<c:param name="id" value="${client.id}" />
				</c:url>
				<c:url var="deleteUrl" value="/client/delete">
					<c:param name="id" value="${client.id}" />
				</c:url>
				<tr>
					<td>${client.id}</td>
					<td><spring:message code="${client.titre.label}" /></td>
					<td>${client.nom}</td>
					<td>${client.prenom}</td>
					<td><fmt:formatDate value="${client.dtNaissance}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="${editUrl}" class="btn btn-warning"><spring:message
								code="clients.edit" /></a></td>
					<td><a href="${deleteUrl}" class="btn btn-danger"><spring:message
								code="clients.delete" /></a></td>
				</tr>
			</c:forEach>
			<c:url var="addUrl" value="/client/add" />
			<tr>
				<td colspan="7"><a href="${addUrl}" class="btn btn-primary"><spring:message
							code="clients.add" /></a></td>
			</tr>
		</table>
	</div>
</body>
</html>