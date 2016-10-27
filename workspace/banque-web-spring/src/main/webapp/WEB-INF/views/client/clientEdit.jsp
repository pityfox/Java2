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
<title><spring:message code="clientEdit.title" /></title>
</head>
<body>

	<div class="container">
		<fieldset>
			<legend>
				<spring:message code="clientEdit.fieldset" />
			</legend>

			<form:form method="post" action="save" modelAttribute="client"
				cssClass="form-horizontal">
				<form:hidden path="id" />
				<form:hidden path="version" />

				<div class="form-group">
					<form:label cssClass="sr-only" path="titre">
						<spring:message code="clientEdit.titre" />
					</form:label>
					<form:select path="titre">
						<form:option value="">
							<spring:message code="titre.selection" />
						</form:option>
						<c:forEach items="${titres}" var="t">
							<form:option value="${t}">
								<spring:message code="${t.label}" />
							</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="titre" />
				</div>

				<div class="form-group">
					<form:label cssClass="sr-only" path="nom">
						<spring:message code="clientEdit.nom" />
					</form:label>
					<form:input cssClass="form-control" path="nom" />
					<form:errors path="nom" />
				</div>

				<div class="form-group">
					<form:label cssClass="sr-only" path="prenom">
						<spring:message code="clientEdit.prenom" />
					</form:label>
					<form:input cssClass="form-control" path="prenom" />
					<form:errors path="prenom" />
				</div>

				<div class="form-group">
					<form:label cssClass="sr-only" path="dtNaissance">
						<spring:message code="clientEdit.dtNaissance" />
					</form:label>
					<form:input cssClass="form-control" path="dtNaissance" type="date" />
					<form:errors path="dtNaissance" />
				</div>

				<div class="form-group">
					<form:label cssClass="sr-only" path="commentaire">
						<spring:message code="clientEdit.commentaire" />
					</form:label>
					<form:textarea path="commentaire" rows="4" />
					<form:errors path="commentaire" />
				</div>

				<div class="form-group">
					<form:label cssClass="sr-only" path="adr.rue">
						<spring:message code="clientEdit.rue" />
					</form:label>
					<form:input cssClass="form-control" path="adr.rue" />
					<form:errors path="adr.rue" />
				</div>

				<div class="form-group">
					<form:label cssClass="sr-only" path="adr.codePostal">
						<spring:message code="clientEdit.codePostal" />
					</form:label>
					<form:input cssClass="form-control" path="adr.codePostal" />
					<form:errors path="adr.codePostal" />
				</div>

				<div class="form-group">
					<form:label cssClass="sr-only" path="adr.ville">
						<spring:message code="clientEdit.ville" />
					</form:label>
					<form:input cssClass="form-control" path="adr.ville" />
					<form:errors path="adr.ville" />
				</div>

				<td colspan="3"><input type="submit"
					value="<spring:message code="clientEdit.save"/>" />
			</form:form>
		</fieldset>
	</div>
</body>
</html>