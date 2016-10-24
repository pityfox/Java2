<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des agences</title>
</head>
<body>

<table border="1">
	<tr>
		<th>Numéro Agence</th>
		<th>Numéro Banque</th>
		<th>CP</th>
		<th>Rue</th> 
		<th>Ville</th>
		<th>Horaires</th>
		<th>Libellé</th>
		<th></th>
		<th></th>
	</tr>
	
	<c:forEach items="${agences}" var="agence">
		<c:url var="editUrl" value="/agence">
			<c:param name="action" value="edit"/>
			<c:param name="numBanque" value="${agence.id.numBanque}"/>
			<c:param name="numAgence" value="${agence.id.numAgence}"/>
		</c:url>
		<c:url var="deleteUrl" value="/agence">
			<c:param name="action" value="delete"/>
			<c:param name="numBanque" value="${agence.id.numBanque}"/>
			<c:param name="numAgence" value="${agence.id.numAgence}"/>
		</c:url>
		<tr>
			<td>${agence.id.numAgence}</td>
			<td>${agence.id.numBanque}</td>
			<td>${agence.adresse.codePostal}</td>
			<td>${agence.adresse.rue}</td>
			<td>${agence.adresse.ville}</td>
			<td>${agence.horaires}</td>
			<td>${agence.libelle}</td>
			<td><a href="${editUrl}">Modifier</a></td>
			<td><a href="${deleteUrl}">Supprimer</a></td>
		</tr>
	</c:forEach>
	<c:url var="addUrl" value="/agence">
		<c:param name="action" value="add"/>
	</c:url>
	<tr>
		<td colspan="9"><a href="${addUrl}">Ajouter</a></td>
	</tr>
</table>

</body>
</html>