<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="control.Gestion" %>
<%@ page import="beans.Adresse" %>
<%@ page import="beans.Annonce" %>
<%@ page import="beans.Categorie" %>  
<% 
	Gestion g = new Gestion(request.getParameterMap());
	List<Categorie> categories = g.getCategories();
	List<Annonce> annonces = g.getAnnonces();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Recherche</title>
</head>
<body>
	<h1>Recherche par catégorie</h1>
	<form method="GET">
		<select name="categorie">
		<%
			for(Categorie ca : categories) {
				%>
				<option value="<%= ca.getId() %>"><%= ca.getNom() %></option>
				<%
			}
		%>
		</select>
		<input type="hidden" name="action" value="search" />
		<input type="submit" value="Rechercher" />
	</form>
	<%
		if (annonces != null) {
			%>
			<h1>Résultat</h1>
			<%
			for(Annonce a : annonces) {
				%>
				<h2>Annonce : <%= a.getNom() %></h2>
				<p>
					Adresse : <%= a.getAdresse().getNumero() + " " +  a.getAdresse().getRue()%>
					Ville : <%= a.getAdresse().getVille() %>
					Code Postal : <%= a.getAdresse().getCode_postal() %>				
					Téléphone : <%= a.getTelephone() %>
				</p>
				<%
			}
		}
	%>
</body>
</html>