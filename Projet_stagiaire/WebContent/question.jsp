<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="beans.Questionnaire" %>
<%@ page import="beans.Question" %>
<%@ page import="beans.Reponse" %>
<%@ page import="dao.QuestionnaireDAO" %>
<%@ page import="dao.QuestionDAO" %> 
<%@ page import="dao.ReponseDAO" %>
<% Questionnaire qu = QuestionnaireDAO.getQuestionnaire(Integer.valueOf(request.getParameter("q")));
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
	<h1>Question :</h1>
<%	for (Question q : l) {  %>	
	<h3><%= q.texte %></h3>
	<form method="POST" >
<%		List<Reponse> lr = ReponseDAO.getReponses(q);
		for (Reponse r : lr) {	%>
		<input type="radio" name="<%= q.id %>" value="<%= r.id %>" /> <%= r.texte %><br>
<% 		} %>
		<input type="submit" value="Ok" />
	</form>
<% } %>
	<script src="js/js.js"></script>
</body>
</html>