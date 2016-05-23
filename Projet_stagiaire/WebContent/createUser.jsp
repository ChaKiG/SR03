<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.UtilisateurDAO" %>  
<%@ page import="beans.Utilisateur" %> 
<%@ page import="others.SendMail" %> 
<% ConnectionControl c = new ConnectionControl(request); 
	if (!c.isOk() || c.type_utilisateur() < 1) {
		response.sendRedirect("index");
	}
	Utilisateur u = null;
	boolean ok = false;
	if (request.getParameter("mail") != null && request.getParameter("mdp") != null) {
		u = new Utilisateur(
				-1,
				request.getParameter("mail"),
				request.getParameter("mdp"),
				Integer.valueOf(request.getParameter("type_utilisateur")),
				Integer.valueOf(request.getParameter("active")),
				request.getParameter("telephone"),
				request.getParameter("societe"),
				new Date(System.currentTimeMillis())
				);
		ok = UtilisateurDAO.createUser(u);
		if (ok == true) {
			SendMail s = new SendMail();
			s.send(u.mail, u.mot_de_passe);
		}
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
	<h1>Création d'un utilisateur :</h1>
	<form method="POST">
		<label for="mail">Mail du nouvel utilisateur :</label><br />
		<input type="text" id="mail" name="mail" placeholder="mail" /><br />
		<label for="mdp">Mot de passe de l'utilisateur :</label><br />
		<input type="text" id="mdp" name="mdp" placeholder="mot de passe" /><br />
		<label for="type_utilisateur">Type d'utilisateur :</label><br />
		<select id="type_utilisateur" name="type_utilisateur">
			<option value="1">Administrateur</option>
			<option value="0">Stagiaire</option>
		</select><br />
		<label for="mdp">Actif :</label><br />
		<select id="active" name="active">
			<option value="1">Oui</option>
			<option value="0">Non</option>
		</select><br />
		<label for="telephone">Téléphone :</label><br />
		<input type="tel" id="telephone" name="telephone" placeholder="0201010101" /><br />
		<label for="societe">Société :</label><br />
		<input type="text" id="societe" name="societe" placeholder="societe" /><br />		
		<input type="submit" value="Envoyer" />
	</form>
<% if (ok == true) { %>
	<p>Utilisateur bien enregistré ! redirection dans 5 secondes</p>
<% } else if (u != null) {%>
	<p>Erreur, veuillez vérifier les informations</p>
<% } %>
	<script src="js/js.js"></script>
</body>
</html>