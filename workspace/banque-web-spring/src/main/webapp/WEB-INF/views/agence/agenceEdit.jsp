<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<title><spring:message code="agenceEdit.title"/></title>
</head>
<body>

	<fieldset>
		<legend><spring:message code="agenceEdit.fieldset"/></legend>

		<form:form method="post" action="save" modelAttribute="agence">
			<input type="hidden" name="mode" value="${mode}" /> 
			<form:hidden path="version"/>
			<table border="1">
				<tr>
					<td><spring:message code="agenceEdit.numBanque"/></td>
					<td><form:input path="id.numBanque" readonly="${mode eq 'edit'}"/>
				</tr>
				<tr>
					<td><spring:message code="agenceEdit.numAgence"/></td>
					<td><form:input path="id.numAgence" readonly="${mode eq 'edit'}"/>
				</tr>
				<tr>
					<td><spring:message code="agenceEdit.libelle"/></td>
					<td><form:input path="libelle"/>
				</tr>
				<tr>
					<td><spring:message code="agenceEdit.horaires"/></td>
					<td><form:input path="horaires"/>
				</tr>
				<tr>
					<td><spring:message code="agenceEdit.rue"/></td>
					<td><form:input path="adresse.rue"/>
				</tr>
				<tr>
					<td><spring:message code="agenceEdit.codePostal"/></td>
					<td><form:input path="adresse.codePostal"/>
				</tr>
				<tr>
					<td><spring:message code="agenceEdit.ville"/></td>
					<td><form:input path="adresse.ville"/>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="<spring:message code="agenceEdit.save"/>" /></td>
				</tr>
			</table>
		</form:form>
	</fieldset>

</body>
</html>