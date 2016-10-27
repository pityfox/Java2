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
<title><spring:message code="agenceEdit.title" /></title>
</head>
<body>

	<div class="container">
		<fieldset>
			<legend>
				<spring:message code="agenceEdit.fieldset" />
			</legend>

			<form:form method="post" action="save" modelAttribute="agence"
				cssClass="form-horizontal">
				<input type="hidden" name="mode" value="${mode}" />
				<form:hidden path="version" />

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="id.numBanque">
						<spring:message code="agenceEdit.numBanque" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control"  path="id.numBanque" readonly="${mode eq 'edit'}" />
						<form:errors cssClass="text-danger" path="id.numBanque" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="id.numAgence">
						<spring:message code="agenceEdit.numAgence" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control"  path="id.numAgence" readonly="${mode eq 'edit'}" />
						<form:errors cssClass="text-danger" path="id.numAgence" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="libelle">
						<spring:message code="agenceEdit.libelle" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control"  path="libelle" />
						<form:errors cssClass="text-danger" path="libelle" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="horaires">
						<spring:message code="agenceEdit.horaires" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control"  path="horaires" />
						<form:errors cssClass="text-danger" path="horaires" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="adresse.rue">
						<spring:message code="agenceEdit.rue" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control"  path="adresse.rue" />
						<form:errors cssClass="text-danger" path="adresse.rue" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label"
						path="adresse.codePostal">
						<spring:message code="agenceEdit.codePostal" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control"  path="adresse.codePostal" />
						<form:errors cssClass="text-danger" path="adresse.codePostal" />
					</div>
				</div>

				<div class="form-group">
					<form:label cssClass="col-xs-3 control-label" path="adresse.ville">
						<spring:message code="agenceEdit.ville" />
					</form:label>
					<div class="col-xs-5">
						<form:input cssClass="form-control"  path="adresse.ville" />
						<form:errors cssClass="text-danger" path="adresse.ville" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3 text-right"></div>
					<div class="col-xs-5 text-right">
						<input class="btn btn-primary" type="submit"
							value="<spring:message code="agenceEdit.save"/>" />
					</div>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>