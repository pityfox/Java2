<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition de l'agence</title>
</head>
<body>

	<fieldset>
		<legend>Edition de l'agence</legend>

		<c:url var="saveUrl" value="/agence" />

		<form method="post" action="${saveUrl}">
			<input type="hidden" name="action" value="save" />
			<input type="hidden" name="new" value="${"add".equals(param['action']) ? true:false}" />
			<input type="hidden" name="version" value="${agence.version}" />
			<table border="1">
				<tr>
					<td>NumAgence</td>
					<td><input type="text" name="numAgence" value="${agence.id.numAgence}" ${"add".equals(param['action']) ? "":"readonly"} /></td>
				</tr>
				<tr>
					<td>NumBanque</td>
					<td><input type="text" name="numBanque" value="${agence.id.numBanque}" ${"add".equals(param['action']) ? "":"readonly"}/></td>
				</tr>
				<tr>
					<td>CP</td>
					<td><input type="text" name="codePostal" value="${agence.adresse.codePostal}" /></td>
				</tr>
				<tr>
					<td>Rue</td>
					<td><input type="text" name="rue" value="${agence.adresse.rue}" /></td>
				</tr>
				<tr>
					<td>Ville</td>
					<td><input type="text" name="ville" value='${agence.adresse.ville}' /></td>
				</tr>
				<tr>
					<td>Horaires</td>
					<td><input type="text" name="horaires" value="${agence.horaires}" /></td>
				</tr>
				<tr>
					<td>Libellé</td>
					<td><input type="text" name="libelle"
						value="${agence.libelle}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Valider" /></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>