<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controllers.ConnectionControl" %> 
<% ConnectionControl c = new ConnectionControl(request); 
	if (!c.isOk()) {
		response.sendRedirect("index");
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Création utilisateur</title>
</head>
<body>
<%
if ( c.isOk() ) {
	%>
	<h2>Création d'un utilisateur</h2>
	<form method="POST" action="createUser">
		Mail:<input type="text" id="mailUser"></input></br>
		Mot de passe:<input type="text" id="mdpUser"></input></br>
		Type:<select type="typeUser">
			<option value="user">Utilisateur</option>
			<option value="admin">Administrateur</option>
		</select></br>
		Actif:<input type="radio" id="activeUser" value="true" checked="checked">Oui
		<input type="radio" id="activeUser" value="false">Non</br>
		Téléphone:<input type="text" id="telephoneUser"></input></br>
		Société:<input type="text" id="companyUser"></input></br>
		<input type="reset" value="Annuler"/>
		<input type="submit" value="Créer"/>
	</form>
	<%
}
%>
</body>