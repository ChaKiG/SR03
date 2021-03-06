<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Time" %>
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="beans.Utilisateur" %>
<%@ page import="beans.Questionnaire" %>
<%@ page import="beans.Question" %>
<%@ page import="beans.Reponse" %>
<%@ page import="beans.Parcours" %>
<%@ page import="beans.ReponseUtil" %>
<%@ page import="dao.QuestionnaireDAO" %>
<%@ page import="dao.QuestionDAO" %> 
<%@ page import="dao.ReponseDAO" %>
<%@ page import="dao.ParcoursDAO" %>
<%@ page import="dao.ReponseUtilDAO" %>
<% 
	int questionnaire = Integer.valueOf(request.getParameter("q"));
	ConnectionControl c = new ConnectionControl(request); 
	if ( !c.isOk() ) { 
		response.sendRedirect("index");
	}
	Questionnaire qu = QuestionnaireDAO.getQuestionnaire(questionnaire);
	List<Question> l = QuestionDAO.getQuestions(qu);
	if (qu == null) {
		response.sendRedirect("questionnaires");
	}
	Parcours p = ParcoursDAO.getParcours(questionnaire, c.id());
	List<ReponseUtil> reponses = null;
	request.getSession().setAttribute(String.valueOf(questionnaire), System.currentTimeMillis());
	if (p == null) {
		p = new Parcours();
		p.questionnaire = qu;
		p.utilisateur = new Utilisateur();
		p.utilisateur.id = c.id();
		p.score = 0;
		p.duree = new Time(0);
		ParcoursDAO.createParcours(p);
		reponses = new ArrayList<ReponseUtil>();
	} else {
		reponses = ReponseUtilDAO.getReponsesUtil(p);
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/css.css">
	<title>Question</title>
</head>
<body>
<%@ include file="navbar.html" %>
	<h1>Questions :</h1>
	<form id="form" name="<%= questionnaire %>">
<%	for (Question q : l) {  %>	
		<p><%= q.texte %></p>
<%		List<Reponse> lr = ReponseDAO.getReponses(q);
		for (Reponse r : lr) {	%>
		<input type="radio" 
			name="<%= q.id %>" 
			value="<%= r.id %>" 
			onchange="parcours();" 
<%			for(ReponseUtil rep : reponses) {
				if (rep.reponse.id == r.id ) {	%> 
			checked 
<% }} %>
		/> 
		<%= r.texte %>
		<br>
<% 		} %>
<% } %>
	</form>
	<h2 id=parcoursTime>Temps actuel : <%= p.duree.getTime() %> (en ms)</h2>
	<h2 id=parcoursScore>Score actuel : <%= p.score %></h2>
	<script src="js/js.js"></script>
</body>
</html>