<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="trombi.DataHandler" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8" />
	<title>Test trombi</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col-md-5 col-md-offset-3 col-lg-3">
			<form role="form" method="get" class="col-sm-6 col-lg-5 divForm">
			<label for="nom">Nom :</label>
			<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom"/><br />
			<label for="prenom">Prénom :</label>
			<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom"/><br />
			<input type="submit" class="btn btn-default" value="Envoyer"/>
		</form>
		</div>
	</div>
	</div>
	<div class="container myCont">
		<div class="row">
		<%
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		out.println(new DataHandler(nom, prenom).getHtml());
		%>
		</div>
	</div>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>