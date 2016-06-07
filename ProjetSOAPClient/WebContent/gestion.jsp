<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.Annonce" %>
<%@ page import="beans.Categorie" %>
<%@ page import="control.Gestion" %>
<%@ page import="java.util.List" %>
<%
	Gestion g = new Gestion(request.getParameterMap());
	List<Annonce> lAnnonce = g.getAnnonces();
	List<Categorie> lCategorie = g.getCategories();
	int action = g.getAction();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page d'accueil</title>
</head>
<body>
	<h1><%= g.getMessage() %></h1>
	<form method="POST">


<%--  SI ON TENTE DE CREER UNE ANNONCE  --%>
<% if (action == Gestion.ADD) {		%>
		<label for="categorie">Catégorie : </label>
		<select name="categorie">
<% 		for (Categorie c : lCategorie) {	%>
			<option value="<%= c.getId() %>"><%= c.getNom() %></option>
<% 		} %>
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
		<input type="hidden" name="action" value="add" /><br />	



<%--  SI ON TENTE DE MODIFIER UNE ANNONCE  --%>
<% } else if (action == Gestion.UPDATE) {
	// On choisi l'annonce à modifier
	if (lAnnonce != null && lAnnonce.size() > 1) {				%>
		<label for="annonce">Annonce : </label>
		<select name="annonce">
		<% 	for (Annonce a : lAnnonce) {
				out.println("<option value=\"" + a.getId() + "\">" + a.getId() + " -- " + a.getNom() + "</option>");
 			}
		%>
		</select><br />
<% 	} else if (lAnnonce != null && lAnnonce.size() > 0){
	// On remplit les champs de l'annonce
	Annonce a = lAnnonce.get(0);
%>
		<label for="categorie">Catégorie : </label>
		<select name="categorie">
<% 		for (Categorie c : lCategorie) {	
				if (a.getCategorie() == c.getId()) {
					out.println("<option value=\"" + c.getId() + "\" selected>" + c.getNom() + "</option>");
	 			} else {
	 				out.println("<option value=\"" + c.getId() + "\">" + c.getNom() + "</option>");
	 			}
			} 
%>
		</select><br />
		<label for="nom">Nom : </label>
		<input type="text" name="nom" value="<%= a.getNom() %>"/><br />
		<label for="telephone">Telephone : </label>
		<input type="number" name="telephone" value="<%= a.getTelephone() %>" /><br />
		<label for="adresse.CP">Code Postal : </label>
		<input type="number" name="adresse.CP" value="<%= a.getAdresse().getCode_postal() %>" /><br />
		<label for="adresse.ville">Ville : </label>
		<input type="text" name="adresse.ville" value="<%= a.getAdresse().getVille() %>" /><br />
		<label for="adresse.rue">Rue : </label>
		<input type="text" name="adresse.rue" value="<%= a.getAdresse().getRue() %>" /><br />
		<label for="adresse.num">Numéro : </label>
		<input type="number" name="adresse.num" value="<%= a.getAdresse().getNumero() %>" /><br />
		<input type="hidden" name="annonce" value="<%= a.getId() %>" />
		<input type="hidden" name="adresse.id" value="<%= a.getAdresse().getId() %>" />
<% 	} %>
		<input type="hidden" name="action" value="mod" /><br />	

		
<%--  SI ON TENTE DE SUPPRIMER UNE ANNONCE  --%>	
<% } else if (action == Gestion.DELETE) { %>
		<label for="annonce">Annonce : </label>
		<select name="annonce">
<% 		for (Annonce a : lAnnonce) {	%>
			<option value="<%= a.getId() %>"><%= a.getId() + " -- " + a.getNom() %></option>
<% 		} 																	%>
		</select><br />
		<input type="hidden" name="action" value="del" /><br />



<%--  SI AUCUNE ACTION N'A ETE CHOISIE  --%>
<% } else { %>
		<label for="action">Action : </label>
		<select name="action">
			<option value="add">Créer</option>
			<option value="mod">Modifier</option>
			<option value="del">Supprimer</option>
		</select><br />
<% } %>
	
		<input type="submit" value="envoyer" />
	</form>
</body>
</html>