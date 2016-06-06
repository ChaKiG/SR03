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
				<p>
					<h2>Annonce : <%= a.getNom() %></h2>
					Adresse : <%= a.getAdresse().getNumero() + " " +  a.getAdresse().getRue()%></br>
					Ville : <%= a.getAdresse().getVille() %></br>
					Code Postal : <%= a.getAdresse().getCode_postal() %></br> 					
					Téléphone : <%= a.getTelephone() %></br>
				</p>
				<%
			}
		}
	%>
</body>
</html>