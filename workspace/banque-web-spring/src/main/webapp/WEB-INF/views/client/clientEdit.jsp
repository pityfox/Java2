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
					<form:label cssClass="col-xs-3 control-label" path="titre">
						<spring:message code="clientEdit.titre" />
					</form:label>
					<div class="col-xs-5">
						<form:select path="titre">
							<form:option value="">
								<spring:message code="titre.selection" />
							</form:option>
							<c:forEach items="${titres}" var="t">
								<form:option value="${t}">
									<spring:message code="${t.label}" />
								</form:option>
							</c:forEach>
						</form:select><br>
						<form:errors cssClass="text-danger" path="titre" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="nom">
						<spring:message code="clientEdit.nom" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control" path="nom" />
						<form:errors cssClass="text-danger"  path="nom" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="prenom">
						<spring:message code="clientEdit.prenom" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control" path="prenom" />
						<form:errors cssClass="text-danger"  path="prenom" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="dtNaissance">
						<spring:message code="clientEdit.dtNaissance" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control" path="dtNaissance" type="date" />
						<form:errors cssClass="text-danger"  path="dtNaissance" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="commentaire">
						<spring:message code="clientEdit.commentaire" />
					</form:label>
					<div class="col-xs-5">
						<form:textarea path="commentaire" cssClass="form-control" rows="4" />
						<form:errors cssClass="text-danger"  path="commentaire" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="adr.rue">
						<spring:message code="clientEdit.rue" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control" path="adr.rue" />
						<form:errors cssClass="text-danger"  path="adr.rue" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="adr.codePostal">
						<spring:message code="clientEdit.codePostal" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control" path="adr.codePostal" />
						<form:errors cssClass="text-danger"  path="adr.codePostal" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="adr.ville">
						<spring:message code="clientEdit.ville" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control" path="adr.ville" />
						<form:errors cssClass="text-danger"  path="adr.ville" />
					</div>
				</div>
				<div class="form-group">
				<div class="col-xs-3 text-right">
				</div>
				<div class="col-xs-5 text-right">
				<input class="btn btn-primary" type="submit"
					value="<spring:message code="clientEdit.save"/>" />
				</div></div>
				
			</form:form>
		</fieldset>
	</div>
</body>
</html>