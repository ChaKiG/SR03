<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="trombi.DataHandler" %>
<%@ page import="trombi.Personne" %>
<%@ page import="trombi.Structure" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8" />
	<title>Trombi UTC</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="css/css.css" rel="stylesheet" type="text/css" />
	<script src="https://code.jquery.com/jquery-1.12.2.min.js" integrity="sha256-lZFHibXzMHo3GGeehn1hudTAP3Sc0uKXBXAzHX1sjtk=" crossorigin="anonymous"></script>
	
</head>
<body>
	<header>
		<div class="header">
			<div class="col-sm-2">
				<img src="https://www.utc.fr/cru-1455812804/typo3conf/ext/site/Resources/Public/Frontend/vendor/html/images/utc-site-logo.png" height="75px">
			</div>
			<div class="col-sm-6">
				<h1>Trombinoscope</h1>
			</div>
			<div class="clearfix"></div>
		</div>
	</header>
		
	<section class="global container-fluid">
	<div class="row">
		<div class="col-md-2 searchCont">
			<div class="panel panel-default">
 				<div class="panel-heading">Recherche par Nom</div>
				<div class="panel-body">
					<form id="searchName" role="form" class="divForm" action="">
					<label for="nom">Nom :</label>
					<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom"/><br />
					<label for="prenom">Prénom :</label>
					<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom"/><br />
					<input type="submit" class="btn btn-default" value="Rechercher"/>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
 				<div class="panel-heading">Recherche par Structure</div>
				<div class="panel-body">
					<form id="searchStructure" role="form" class="divForm" action="">
					<label for="structure">Structure :</label>
					<select class="form-control" id="structure">
						<option value="0" selected>--</option>
						<%
							Structure[] structures = DataHandler.getStructures();
							for (Structure s : structures) {
							%>
									<option value="<%= s.getStructureId() %>"><%= s.getStructureLibelle() %></option>
							<%
							}
							%>
					</select>
					<label for="sousStructure">Sous-Structure :</label>
					<select class="form-control" id="sousStructure">
						<option value="0">--</option>
					</select>
					<input type="submit" class="btn btn-default" value="Rechercher"/>
					</form>		
				</div>
			</div>
		</div>
	<div id="divPers" class="col-md-10">
	</div>
	
	</div>
	</section>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/js.js"></script>
</body>
</html>