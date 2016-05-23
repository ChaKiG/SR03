<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="beans.Questionnaire" %>
<%@ page import="beans.Question" %>
<%@ page import="beans.Reponse" %>
<%@ page import="dao.QuestionnaireDAO" %>
<%@ page import="dao.QuestionDAO" %> 
<%@ page import="dao.ReponseDAO" %>
<% 
	int questionnaire = Integer.valueOf(request.getParameter("q"));
	Questionnaire qu = QuestionnaireDAO.getQuestionnaire(questionnaire);
	List<Question> l = QuestionDAO.getQuestions(qu);
	ConnectionControl c = new ConnectionControl(request); 
	if ( !c.isOk() ) { 
		response.sendRedirect("index");
	} else if (qu == null) {
		response.sendRedirect("questionnaires");
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Question</title>
</head>
<body>
	<h1>Questions :</h1>
	<form id="form" name="<%= questionnaire %>">
<%	for (Question q : l) {  %>	
		<p><%= q.texte %></p>
<%		List<Reponse> lr = ReponseDAO.getReponses(q);
		for (Reponse r : lr) {	%>
		<input type="radio" name="<%= q.id %>" value="<%= r.id %>" onchange="parcours();"/> <%= r.texte %><br>
<% 		} %>
	</form>
<% } %>
	<script src="js/js.js"></script>
</body>
</html>