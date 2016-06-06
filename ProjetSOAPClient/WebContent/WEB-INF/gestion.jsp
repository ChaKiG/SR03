<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.Annonce" %>
<%@ page import="beans.Categorie" %>
<%@ page import="control.Gestion" %>
<%@ page import="java.util.List" %>
<%
	Gestion g = new Gestion(request.getParameterMap());
	List<Annonce> l = g.getAnnonces();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page d'accueil</title>
</head>
<body>
	<h1>Action ?</h1>
	<form>
		<label for="action">Action : </label>
		<select name="action">
			<option value="add">Créer</option>
			<option value="mod">Modifier</option>
			<option value="del">Supprimer</option>
		</select><br />
		<hr>
		<label for="categorie">Catégorie : </label>
		<select name="categorie">
<% List<Categorie> lCat = g.getCategories();
	for (Categorie c : lCat) { %>
		<option value="<%= c.getId() %>"><%= c.getNom() %></option>
<%  } %>
		</select><br />
		<label for="nom">Nom : </label>
		<input type="text" name="nom" /><br />
		<label for="telephone">Telephone : </label>
		<input type="number" name="telephone" /><br />
		<label for="adresse.CP">Code Postal : </label>
		<input type="number" name="adresse.CP" /><br />
		<label for="adresse.ville">Ville : </label>
		<input type="text" name="adresse.ville" /><br />
		<label for="adresse.rue">Rue : </label>
		<input type="text" name="adresse.rue" /><br />
		<label for="adresse.num">Numéro : </label>
		<input type="number" name="adresse.num" /><br />
		
		<input type="submit" value="envoyer" />
	</form>





</body>
</html>