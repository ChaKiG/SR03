<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="trombi.DataHandler" %>
<%@ page import="trombi.Personne" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8" />
	<title>Trombi UTC</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<section>
		<h1>Recherche trombi</h1>
	</section>
	<%
	String nom = (String) request.getParameter("nom");
	String prenom = (String) request.getParameter("prenom");
	if (nom == null) nom = "";
	if (prenom == null) prenom = "";
	%>
	
	<section class="container">
		<div class="col-md-8 col-md-offset-2 col-lg-5">
			<form role="form" method="get" class="divForm">
			<label for="nom">Nom :</label>
			<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="<%= nom %>"/><br />
			<label for="prenom">Prénom :</label>
			<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="<%= prenom %>"/><br />
			<input type="submit" class="btn btn-default" value="Envoyer"/>
			</form>
		</div>
	</section>
	<section class="container myCont">
	<%
		Personne[] lPersonnes = new DataHandler(nom, prenom).getPersonnes();
		
		if (lPersonnes != null) {
			for (Personne p : lPersonnes) {
				%>
				<div class="col-sm-4 divPers">
					<div class="row">
						<div class="col-xs-6 boxPers">
							<img alt="Photo non disponible" src="<%= p.getPhoto() %>" width="96px" height="120px"/>
						</div>
						<div class="col-xs-6"><p>
							<%= p.getNom() %><br />
							<%= p.getPoste() %><br />
							<%= p.getLogin() %></p>
						</div>
					</div>
				</div>
	<% 		} 
		}
		if (lPersonnes == null || lPersonnes.length == 0){
			%>
			<p>Aucun Résultat</p>
			<%
		}
	%>
	</section>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>