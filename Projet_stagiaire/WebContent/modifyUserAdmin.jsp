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
	String suid = request.getParameter("uid");
	String del = request.getParameter("del");
	String mail = request.getParameter("mail");
	String mot_de_passe = request.getParameter("mdp");
	String telephone = request.getParameter("telephone");
	String societe = request.getParameter("societe");
	String active = request.getParameter("active");
	String type_util = request.getParameter("type_utilisateur");
	boolean ok = false;
	boolean tried = false;
	int uid = -1;
	Utilisateur u = null;
	
	if (suid != null) {
		u = UtilisateurDAO.getUtilisateur(Integer.valueOf(suid));
		if (del != null && del.equals("1")) {
			System.out.println("trying to del");
			ok = UtilisateurDAO.deleteUser(u);
			tried = true;
		} else if (mail != null && mot_de_passe != null && telephone != null && societe != null) {
			u.mail = mail;
			u.mot_de_passe = mot_de_passe;
			u.telephone = telephone;
			u.societe = societe;
			u.active = Integer.valueOf(active);
			u.type_utilisateur = Integer.valueOf(type_util);
			ok = UtilisateurDAO.modifyUser(u);
		}
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="css/css.css">
<% if (ok) { %>
	<meta http-equiv="refresh" content="5;URL=modifyUserAdmin" />
<% } %>
	<title>Page d'accueil</title>
</head>
<body>
<%@ include file="navbar.html" %>
<% if (u == null) {
	List<Utilisateur> l = UtilisateurDAO.getAllUtilisateurs();
%>
	<table>
	<tr>
		<th>Mail</th>
		<th>Admin ?</th>
		<th>Modifier</th>
	</tr>
<%	for (Utilisateur ut : l) {	%>
	<tr>
		<td><%= ut.mail %></td>
		<td><%= (ut.type_utilisateur == 1 ? "Oui" : "Non") %></td>
		<td><a href="modifyUserAdmin?uid=<%= ut.id %>">Modifier</a></td>
	</tr>
<% 	}%>
	</table>
<% } else if (tried == false) { %>
	<h1>Modification des informations :</h1>
	<form method="POST">
		<input type="hidden" name="uid" value="<%= u.id %>">
		<label for="mail">Mail  :</label><br />
		<input type="text" id="mail" name="mail" value="<%= u.mail %>" /><br />
		<label for="mdp">Mot de passe :</label><br />
		<input type="text" id="mdp" name="mdp" value="<%= u.mot_de_passe %>" /><br />
		<label for="telephone">Téléphone :</label><br />
		<input type="tel" id="telephone" name="telephone" value="<%= u.telephone %>" /><br />
		<label for="societe">Société :</label><br />
		<input type="text" id="societe" name="societe" value="<%= u.societe %>" /><br />		
		<label for="type_utilisateur">Type d'utilisateur :</label><br />
		<select id="type_utilisateur" name="type_utilisateur">
			<option value="1" <%= (u.type_utilisateur == 1) ? "selected" :"" %>>Administrateur</option>
			<option value="0" <%= (u.type_utilisateur == 0) ? "selected" :"" %>>Stagiaire</option>
		</select><br />
		<label for="active">Actif :</label><br />
		<select id="active" name="active">
			<option value="1" <%= (u.active == 1) ? "selected" :"" %>>Oui</option>
			<option value="0" <%= (u.active == 0) ? "selected" :"" %>>Non</option>
		</select><br />
		<label for="del">ATTENTION !! suppression du compte :</label><br />
		<select id="del" name="del">
			<option value="1">Oui</option>
			<option value="0" selected>Non</option>
		</select><br />
		<input type="submit" value="Envoyer" />
	</form>
<% } else if (ok == true) { %>
	<p>Informations bien enregistrées ! redirection dans 5 secondes</p>
<% } else  { %>
	<p>Erreur, veuillez vérifier les informations</p>
<% } %>
	<script src="js/js.js"></script>
</body>
</html>