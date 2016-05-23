<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.QuestionnaireDAO" %>  
<%@ page import="beans.Questionnaire" %> 
<%@ page import="dao.ParcoursDAO" %>  
<% ConnectionControl c = new ConnectionControl(request); 
	if ( !c.isOk() ) { response.sendRedirect("index");}
	
	String del = request.getParameter("del");
	if (del != null && !del.isEmpty()) {
		ParcoursDAO.deleteParcours(Integer.valueOf(del), c.id());
		del = "Parcours bien supprimé !";
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/css.css">
	<title>Questionnaires</title>
</head>
<body>
<%@ include file="navbar.html" %>
<%	if (del != null && !del.isEmpty()) {	%>
	<h3><%= del %></h3>
<% } %>	
	<h1>Questionnaires disponibles :</h1>
	 <table>
	 	<tr>
		 	<th>Questionnaire</th>
		 	<th>Sujet</th>
		 	<th>Créateur</th>
		 	<th>Effectuer</th>
		 	<th>Réinitialiser</th>
<% if (c.type_utilisateur() >= 1) { %>
			<th>  </th>
		 	<th>Modifier</th>
		 	<th>Supprimer</th>
<% } %>
	 	</tr>
<%
	List<Questionnaire> l = QuestionnaireDAO.getQuestionnaires();
	for (Questionnaire q: l) {
%>
		<tr>
			<th><%= q.nom %></th>
			<th><%= q.sujet.nom %></th>
			<th><%= q.utilisateur.mail %></th>
			<th><a href="question?q=<%= q.id %>">Effectuer</a></th>
			<th><a href="questionnaires?del=<%= q.id %>">Reinitialiser</a></th>
<% if (c.type_utilisateur() >= 1) { %>
			<th>  </th>
			<th><a href="">Modifier</a></th>
			<th><a href="suppression?q=<%= q.id %>">Supprimer</a></th>
<% } %>
		</tr>
<%
	}
%>	 
	 </table> 
	<script src="js/js.js"></script>
</body>
</html>