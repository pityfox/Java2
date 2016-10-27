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
<title><spring:message code="clientEdit.title" /></title>
<spring:url value="/resources/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>
				<spring:message code="clientEdit.fieldset" />
				
			</legend>
			<form:form method="post" modelAttribute="client" action="save">
				<form:hidden path="id" />
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="titre" class="control-label">
						<spring:message code="clientEdit.titre" />
					</form:label>
					<form:select path="titre" class="form-control">
						<form:option value="">
							<spring:message code="titre.selection" />
						</form:option>
						<c:forEach items="${titres}" var="titre">
							<form:option value="${titre}">
								<spring:message code="${titre.label}" />
							</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="titre" cssClass="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="nom" class="control-label">
						<spring:message code="clientEdit.nom" />
					</form:label>
					<form:input path="nom" class="form-control" />
					<form:errors path="nom" />
				</div>
				<div class="form-group">
					<form:label path="prenom" class="control-label">
						<spring:message code="clientEdit.prenom" />
					</form:label>
					<form:input path="prenom" class="form-control" />
					<form:errors path="prenom" />
				</div>
				<div class="form-group">
					<form:label path="dtNaissance" class="control-label">
						<spring:message code="clientEdit.dtNaissance" />
					</form:label>
					<form:input path="dtNaissance" class="form-control" type="date" />
					<form:errors path="dtNaissance" />
				</div>
				<div class="form-group">
					<form:label path="commentaire" class="control-label">
						<spring:message code="clientEdit.commentaire" />
					</form:label>
					<form:input path="commentaire" class="form-control" />
					<form:errors path="commentaire" />
				</div>
				<div class="form-group">
					<form:label path="adr.rue" class="control-label">
						<spring:message code="clientEdit.rue" />
					</form:label>
					<form:input path="adr.rue" class="form-control" />
					<form:errors path="adr.rue" />
				</div>
				<div class="form-group">
					<form:label path="adr.codePostal" class="control-label">
						<spring:message code="clientEdit.codePostal" />
					</form:label>
					<form:input path="adr.codePostal" class="form-control" />
					<form:errors path="adr.codePostal" />
				</div>
				<div class="form-group">
					<form:label path="adr.ville" class="control-label">
						<spring:message code="clientEdit.ville" />
					</form:label>
					<form:input path="adr.ville" class="form-control" />
					<form:errors path="adr.ville"/>
				</div>
				<input type="submit"
					value="<spring:message code="clientEdit.save"/>"
					class="btn btn-success" />
			</form:form>
		</fieldset>
	</div>


</body>
</html>