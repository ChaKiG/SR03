<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.UtilisateurDAO" %>  
<%@ page import="beans.Utilisateur" %> 
<% ConnectionControl c = new ConnectionControl(request); 
	if (!c.isOk() || c.type_utilisateur() < 1) {
		response.sendRedirect("index");
	}
	Utilisateur u = UtilisateurDAO.getUtilisateur(c.id());
	boolean ok = false;
	boolean tried = false;
	
	String mail = request.getParameter("mail");
	String mot_de_passe = request.getParameter("mdp");
	String telephone = request.getParameter("telephone");
	String societe = request.getParameter("societe");
	if (mail != null && mot_de_passe != null && telephone != null && societe != null) {
		u.mail = mail;
		u.mot_de_passe = mot_de_passe;
		u.telephone = telephone;
		u.societe = societe;
		tried = true;
		ok = UtilisateurDAO.modifyUser(u);
	}
	
	
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<% if (ok) { %>
	<meta http-equiv="refresh" content="5;URL=user" />
<% } %>
	<title>Page d'accueil</title>
</head>
<body>
<%@ include file="navbar.html" %>
	<h1>Modification de vos informations :</h1>
	<form method="POST">
		<label for="mail">Mail  :</label><br />
		<input type="text" id="mail" name="mail" value="<%= u.mail %>" /><br />
		<label for="mdp">Mot de passe :</label><br />
		<input type="text" id="mdp" name="mdp" value="<%= u.mot_de_passe %>" /><br />
		<label for="telephone">Téléphone :</label><br />
		<input type="tel" id="telephone" name="telephone" value="<%= u.telephone %>" /><br />
		<label for="societe">Société :</label><br />
		<input type="text" id="societe" name="societe" value="<%= u.societe %>" /><br />		
		<input type="submit" value="Envoyer" />
	</form>
<% if (ok == true) { %>
	<p>Informations bien enregistrées ! redirection dans 5 secondes</p>
<% } else if (tried == true) { %>
	<p>Erreur, veuillez vérifier les informations</p>
<% } %>
	<script src="js/js.js"></script>
</body>
</html>