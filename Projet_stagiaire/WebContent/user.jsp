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
	<title>Page d'utilisateur</title>
</head>
<body>
<%
if ( c.isOk() ) {
%>	
	<h1>Vous êtes bien connecté !</h1>
		
<%	if ( c.type_utilisateur() >= 1){			%>
	<h2>Administrateur</h2>
	<a href="">Creer un compte</a><br />
	<a href="">Modifier un compte</a><br />
	<hr />
	<a href="createquestionnaire">Créer un questionnaire</a><br />
	<a href="questionnaires">Modifier questionnaire</a><br />
	<hr />
	
<%	}					%>
	<h2>Etudiant</h2>
	<a href="questionnaires">Effectuer un questionnaire</a><br />
	<a href="">Modifier votre compte</a><br />
	<hr />
	<a href="#" onclick="disconnect();">Se déconnecter</a><br />
<%
} else {							%>
	<h1>Erreur, veuillez vous reconnecter !</h1>
	<a href="/Projet_stagiaire/index">Retour</a><br />
	<hr />
<%	
}
%>
	<script src="js/js.js"></script>
</body>
</html>
