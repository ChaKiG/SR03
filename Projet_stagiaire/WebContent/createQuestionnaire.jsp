<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.SujetDAO" %>
<%@ page import="dao.UtilisateurDAO" %>
<%@ page import="dao.QuestionnaireDAO" %>  
<%@ page import="beans.Sujet" %>
<%@ page import="beans.Questionnaire" %>  
<% ConnectionControl c = new ConnectionControl(request); 
	if (!c.isOk() || c.type_utilisateur() < 1) {
		response.sendRedirect("index");
	}
	Questionnaire q = null;
	boolean ok = false;
	if (request.getParameter("nom") != null && request.getParameter("sujet") != null) {
		//public Questionnaire(int id, Utilisateur utilisateur, String nom, Sujet sujet)
		Sujet s = SujetDAO.getSujet( Integer.parseInt( request.getParameter("sujet")));
		q = new Questionnaire(
				-1,
				UtilisateurDAO.getUtilisateur(c.mail()),
				request.getParameter("nom"),
				s
				);
		ok = QuestionnaireDAO.createQuestionnaire(q);
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/css.css">
	<title>Page d'accueil</title>
</head>
<body>
<%@ include file="navbar.html" %>
	<h1>Création d'un questionnaire :</h1>
	<form method="POST">
		<label for="nom">Nom du questionnaire :</label><br />
		<input type="text" id="nom" name="nom" placeholder="Nom" /><br />
		<label for="sujet">Sujet :</label><br />
		<select id="sujet" name="sujet">
<%
	List<Sujet> l = SujetDAO.getSujets();
	for (Sujet s: l) {
%>
		<option value="<%= s.id %>"><%= s.nom %></option>
<%
	}
%>
		</select><br />
		<input type="submit" value="Envoyer" />
	</form>
	<% if (ok == true) { %>
		<!-- TODO Rajouter la bonne redirection --> 
		<p>Questionnaire bien enregistré ! <a href="...">Ajouter des questions au formulaire</a></p>
	<% } else if (q != null) {%>
		<p>Erreur, veuillez vérifier les informations</p>
	<% } %>
	<script src="js/js.js"></script>
</body>
</html>