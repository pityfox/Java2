<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des clients</title>
</head>
<body>

<table border="1">
	<tr>
		<th>Id</th>
		<th>Titre</th>
		<th>Nom</th>
		<th>Prénom</th> 
		<th>Date de naissance</th>
		<th></th>
		<th></th>
	</tr>
	
	<c:forEach items="${clients}" var="client">
		<c:url var="editUrl" value="/client">
			<c:param name="action" value="edit"/>
			<c:param name="id" value="${client.id}"/>
		</c:url>
		<c:url var="deleteUrl" value="/client">
			<c:param name="action" value="delete"/>
			<c:param name="id" value="${client.id}"/>
		</c:url>
		<tr>
			<td>${client.id}</td>
			<td>${client.titre.label}</td>
			<td>${client.nom}</td>
			<td>${client.prenom}</td>
			<td><fmt:formatDate value="${client.dtNaissance}" pattern="dd/MM/yyyy"/></td>
			<td><a href="${editUrl}">Modifier</a></td>
			<td><a href="${deleteUrl}">Supprimer</a></td>
		</tr>
	</c:forEach>
	<c:url var="addUrl" value="/client">
		<c:param name="action" value="add"/>
	</c:url>
	<tr>
		<td colspan="7"><a href="${addUrl}">Ajouter</a></td>
	</tr>
</table>

</body>
</html>