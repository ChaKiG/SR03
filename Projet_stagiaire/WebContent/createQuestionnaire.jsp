<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.SujetDAO" %>  
<%@ page import="beans.Sujet" %> 
<% ConnectionControl c = new ConnectionControl(request); 
	if (!c.isOk() || c.type_utilisateur() < 1) {
		response.sendRedirect("index");
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page d'accueil</title>
</head>
<body>
	<h1>Création d'un questionnaire :</h1>
	<form onsubmit="return connect();">
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
	<script src="js/js.js"></script>
</body>
</html>