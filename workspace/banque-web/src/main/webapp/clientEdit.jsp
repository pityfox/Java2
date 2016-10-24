<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition du client</title>
</head>
<body>

	<fieldset>
		<legend>Edition du client</legend>

		<c:url var="saveUrl" value="/client" />

		<form method="post" action="${saveUrl}">
			<input type="hidden" name="action" value="save" /> <input
				type="hidden" name="id" value="${client.id}" />
				<input
				type="hidden" name="version" value="${client.version}" />
			<table border="1">
				<tr>
					<td>Titre</td>
					<td><select name="titre">
							<c:forEach items="${titres}" var="titre">
								<option value="${titre}" ${client.titre eq titre?"selected":""}>${titre.label}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Nom</td>
					<td><input type="text" name="nom" value="${client.nom}" /></td>
				</tr>
				<tr>
					<td>Prénom</td>
					<td><input type="text" name="prenom" value="${client.prenom}" /></td>
				</tr>
				<tr>
					<td>Date de naissance</td>
					<td><input type="text" name="dtNaissance"
						value='<fmt:formatDate value="${client.dtNaissance}" pattern="dd/MM/yyyy"/>' /></td>
				</tr>
				<tr>
					<td>Commentaire</td>
					<td><textarea name="commentaire" rows="4">${client.commentaire}</textarea></td>
				</tr>
				<tr>
					<td>Rue</td>
					<td><input type="text" name="rue" value="${client.adr.rue}" /></td>
				</tr>
				<tr>
					<td>Code postal</td>
					<td><input type="text" name="codePostal"
						value="${client.adr.codePostal}" /></td>
				</tr>
				<tr>
					<td>Ville</td>
					<td><input type="text" name="ville"
						value="${client.adr.ville}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Valider" /></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>