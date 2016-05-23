<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.QuestionnaireDAO" %>
<%@ page import="dao.QuestionDAO" %>    
<%@ page import="beans.Questionnaire" %>
<%@ page import="beans.Question" %> 
<% ConnectionControl c = new ConnectionControl(request); 
	if ( !c.isOk() ) { response.sendRedirect("index");}
	int questionnaire = Integer.valueOf(request.getParameter("q"));	
	Questionnaire q = QuestionnaireDAO.getQuestionnaire( questionnaire);
	List<Question> l = QuestionDAO.getQuestions( q);
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Questionnaires</title>
</head>
<body>
<%@ include file="navbar.html" %>
	<h1>Questions disponibles :</h1>
	 <table>
	 	<tr>
		 	<th>Question</th>
		 	<th>Ordre</th>
		 	<th>Modifier</th>
		 	<th>Supprimer</th>
	 	</tr>
<%
	for (Question qu: l) {
%>
		<tr>
			<th><%= qu.texte %></th>
			<th><%= qu.ordre %></th>
			<th><a href="modificationQuestion?q=<%= questionnaire %>&qu=<%= qu.id %>">Modifier</a></th>
			<th><a href="suppressionQuestion?q=<%= questionnaire %>&qu=<%= qu.id %>">Supprimer</a></th>
		</tr>
<%
	}
%>	 
	 </table>
	 <p><a href="ajoutQuestion?q=<%= q.id %>">Ajouter une question</a></p> 
	<script src="js/js.js"></script>
</body>
</html>