<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.Annonce" %>
<%@ page import="beans.Categorie" %>
<%@ page import="java.util.List" %>
<%
	Gestion g = new Gestion(request.getParameterMap());
	
	
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page d'accueil</title>
</head>
<body>
<%@ include file="navbar.html" %>
	<h1>Ajout d'une question :</h1>
	<form method="POST">
		<label for="nom">Nom de la question :</label><br />
		<input type="text" id="nom" name="nom" placeholder="Nom" /><br />
		<label for="ordre">Ordre :</label><br />
		<select id="ordre" name="ordre">
<%
	for (int i=1; i <= nbq + 1; i++) {
%>
		<option value="<%= i %>"><%= i %></option>
<%
	}
%>
		</select><br /><br />
		<label for="reponses">Réponses</label><br />
		<label for="r1">Réponse 1 :</label><br />
		<input type="text" id="nomr1" name="nomr1" placeholder="réponse 1" /><br />
		<label for="correctr1"><input type="checkbox" id="cr1" name="cr1">Correct?</label><br />
		
		<label for="r2">Réponse 2 :</label><br />
		<input type="text" id="nomr2" name="nomr2" placeholder="réponse 2" /><br />
		<label for="correctr2"><input type="checkbox" id="cr2" name="cr2">Correct?</label><br />
		
		<label for="r3">Réponse 3 :</label><br />
		<input type="text" id="nomr3" name="nomr3" placeholder="réponse 3" /><br />
		<label for="correctr3"><input type="checkbox" id="cr3" name="cr3">Correct?</label><br /><br />
		
		<input type="hidden" name="q" value="<%= questionnaire %>">
		<input type="submit" value="Envoyer" />
	</form>
	<% if (id != -1) { %>
		<!-- TODO Rajouter la bonne redirection --> 
		<p>Question bien enregistré ! Vous pouvez consulter l'ensemble des questions <a href="modification?q=<%= q.id %>">ici</a></p>
	<% } else if (qu != null) {%>
		<p>Erreur, veuillez vérifier les informations</p>
	<% } %>
	<script src="js/js.js"></script>
</body>
</html>