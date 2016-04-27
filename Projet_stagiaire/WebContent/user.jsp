<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String mail = (String)request.getSession().getAttribute("mail"); %>
<% String id = (String)request.getSession().getAttribute("id"); %>
<% String cookieId = ""; %>
<% Cookie[] cookies = request.getCookies();
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
if (id.equals(cookieId)) {
%>	
	<h1>Vous êtes bien connecté !</h1>
<%
} else {
%>
	<h1>Erreur, veuillez vous reconnecter !</h1>
	<a href="/Projet_stagiaire/index">Retour</a>
<%	
}
%>
	<script src="js/js.js"></script>
</body>
</html>
