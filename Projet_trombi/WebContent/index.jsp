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
			<div class="col-sm-2 col-xs-5">
				<img src="https://www.utc.fr/cru-1455812804/typo3conf/ext/site/Resources/Public/Frontend/vendor/html/images/utc-site-logo.png" height="45px">
			</div>
	 			<div class="col-sm-10 col-xs-7 title">
					<p style="margin:0px;">Trombinoscope</p>
				</div>
			<div class="clearfix"></div>
		</div>
	</header>
		
	<section class="global container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 searchCont">
			<div class="panel panel-default">
 				<div class="panel-heading">
 					<ul class="nav nav-tabs nav-justified">
 						<li class="active">
 							<a id="searchNameButton" href="#searchName" data-toggle="tab">Recherche par nom</a>
 						</li>
 						<li>
 							<a id="searchNameStructure" href="#searchStructure" data-toggle="tab">Recherche par structure</a>
 						</li>
 					</ul>
				</div>
				<div class="panel-body">
					<div class="tab-content">
						<div class="tab-pane fade in active" id="searchName">
							<form id="searchName" role="form" action="">
								<label for="nom">Nom :</label>
								<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom"/>
								<label for="prenom">Prénom :</label>
								<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom"/><br />
								<div id="errorName"></div>
								<input type="submit" class="btn btn-default" value="Rechercher"/>
								<input type="reset" class="btn btn-default" value="Annuler"/>
							</form>
						</div>
						<div class="tab-pane fade" id="searchStructure">
							<form id="searchStructure" role="form" action="">
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
								</select><br />
								<div id="errorStructure"></div>
								<input type="submit" class="btn btn-default" value="Rechercher"/>
								<input type="reset" class="btn btn-default" value="Annuler"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div id="divPers" class="col-md-12">
	</div>
	
	</div>
	
	<footer>
		<div class="footer">
			© SR03 - Fabrice De Régibus & Thomas Pelletier
		</div>
	</footer>
	</section>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/js.js"></script>
</body>
</html>