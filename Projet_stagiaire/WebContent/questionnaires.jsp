<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.QuestionnaireDAO" %>  
<%@ page import="beans.Questionnaire" %> 
<% ConnectionControl c = new ConnectionControl(request); 
	if ( !c.isOk() ) { response.sendRedirect("index");}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Questionnaires</title>
</head>
<body>
	<h1>Questionnaires disponibles :</h1>
	 <table>
	 	<tr>
		 	<th>Questionnaire</th>
		 	<th>Sujet</th>
		 	<th>Créateur</th>
		 	<th>Effectuer</th>
<% if (c.type_utilisateur() >= 1) { %>
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
<% if (c.type_utilisateur() >= 1) { %>
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