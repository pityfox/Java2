<%@page import="java.util.List"%>
<%@page import="banque.model.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des CLients</title>
</head>
<body>

<table>
	<tr>
		<th>Id</th>
		<th>Titre</th>
		<th>Nom</th>
		<th>Prénom</th>
		<th>DDN</th>
	</tr>
	<% 
	List<Client> clients = (List<Client>) request.getAttribute("clients");
	for(banque.model.Client client:clients)
	{
	%>
	<tr>
		<td><%=client.getId()%></td>
		<td><%=client.getTitre()%></td>
		<td><%=client.getNom()%></td>
		<td><%=client.getPrenom()%></td>
		<td><%=client.getDtNaissance()%></td>
	</tr>
	
	<% } %>
</table>

</body>
</html>