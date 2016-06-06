<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="control.Gestion" %>
<%@ page import="beans.Adresse" %>
<%@ page import="beans.Annonce" %>
<%@ page import="beans.Categorie" %>  
<% 
	Gestion g = new Gestion(request.getParameterMap());
	List<Categorie> liste = g.getCategories();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Recherche</title>
</head>
<body>
	<h1>Recherche par catégorie</h1>
</body>
</html>