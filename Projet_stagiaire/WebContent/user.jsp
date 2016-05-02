<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String mail = (String)request.getSession().getAttribute("mail"); %>
<% String id = (String)request.getSession().getAttribute("id"); %>
<% Integer type_utilisateur = (Integer)request.getSession().getAttribute("type_utilisateur"); %>
<% String cookieId = ""; %>
<% 
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (int i = 0, n = cookies.length; i < n; i++) {
		if (cookies[i].getName().equals("id")) {
			cookieId = cookies[i].getValue();
			break;
		}
	}
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
if ( type_utilisateur != null && mail != null && id != null && id.equals(cookieId) ) {
%>	
	<h1>Vous êtes bien connecté !</h1>
<%	if ( type_utilisateur >= 2) {				%>
	<h2>Administrateur</h2>
	<a href="">Creer un compte</a><br />
	<a href="">Modifier un compte</a><br />
	<hr />
	
<%	} if ( type_utilisateur >= 1){			%>
 	<h2>Professeur</h2>
	<a href="">Créer un questionnaire</a><br />
	<a href="">Modifier questionnaire</a><br />
	<hr />
	
<%	}							%>
	<h2>Etudiant</h2>
	<a href="">Effectuer un questionnaire</a><br />
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
