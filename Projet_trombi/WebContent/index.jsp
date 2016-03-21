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
	<script>
		$(document).ready(function() {
			$('#structure').change( function() {
				var IdStructure = $('#structure').val();
				console.log("Je suis avant le get");
				$.get('SousStructureServlet',{structure:IdStructure},function(responseText) {
					console.log("Je suis dans la servlet");
					var resultat = JSON.parse( responseText);
					console.log(resultat);
					$.each(resultat.sousStructures, function( key, value) {
						$('#sousStructure').append('<option value=' + key + '>' + value + '</option>');
					});
				});
			});
		});
	</script>
</head>
<body>
	<header>
		<div class="header">
			<div class="col-sm-2">
				<img src="https://www.utc.fr/fileadmin/user_upload/SITE-UTC/images/Home/Logotheque/logosUTC_SU.jpg" height="75px">
			</div>
			<div class="col-sm-6">
				<h1>Trombinoscope</h1>
			</div>
			<div class="clearfix"></div>
		</div>
	</header>
		
	<%
	String nom = (String) request.getParameter("nom");
	String prenom = (String) request.getParameter("prenom");
	if (nom == null) nom = "";
	if (prenom == null) prenom = "";
	%>
	<section class="global container-fluid">
	<div class="row">
		<div class="col-md-2 searchCont">
			<div class="panel panel-default">
 				<div class="panel-heading">Recherche par Nom</div>
				<div class="panel-body container">
					<form role="form" method="get" class="divForm">
					<label for="nom">Nom :</label>
					<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="<%= nom %>"/><br />
					<label for="prenom">Prénom :</label>
					<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="<%= prenom %>"/><br />
					<input type="submit" class="btn btn-default" value="Rechercher"/>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
 				<div class="panel-heading">Recherche par Structure</div>
				<div class="panel-body container">
					<form role="form" method="get" class="divForm">
					<label for="nom">Structure :</label>
<%-- 					<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="<%= nom %>"/><br /> --%>
					<select class="form_control" id="structure">
						<%
							Structure[] structures = new DataHandler().getStructures();
							for (Structure s : structures) {
								%>
									<%-- <option value="<%= s.getStructure().getStructId() %>"><%= s.getStructureLibelle() %></option> --%>
									<option value="<%= s.getStructureId() %>"><%= s.getStructureLibelle() %></option>
							<%
							}
							%>
					</select>
					<label for="prenom">Sous-Structure :</label>
					<select class="form_control" id="sousStructure">
					</select>
					<input type="submit" class="btn btn-default" value="Rechercher"/>
					</form>		
				</div>
			</div>
		</div>
	<div class="col-md-10">
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
							<%= p.getLogin() %></p>
						</div>
						<button type="button" class="btn btn-default btn-lg modalButton" data-toggle="modal" data-target="#<%=p.getLogin() %>">
							<span class="glyphicon glyphicon-resize-full"></span>
						</button>
					</div>
				</div>
				
				<!-- Modal -->
				<div class="modal fade" id="<%= p.getLogin() %>" tabindex="-1" role="dialog" aria-labelledby="<%= p.getLogin() %>Label">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="<%= p.getLogin() %>Label"><%= p.getNom() %></h4>
				      </div>
				      <div class="modal-body">
				      	<div class="row">
					        <div class="col-md-3">
								<img alt="Photo non disponible" src="<%= p.getPhoto() %>" width="96px" height="120px"/>
							</div>
							<div class="col-md-9">
								<p class="category">Informations</p>
								<p>
									Login: <%= p.getLogin() %><br />
									Nom: <%= p.getNom() %><br />
									Poste: <%= p.getPoste() %><br />
								</p>
								<p class="category">Contact</p>
								<p>
									Mail: <%= p.getMail() %><br />
									Tel.:<%= p.getTel() %><br />
									Tel2.:<%= p.getTel2() %><br />
								</p>
								<p class="category">Travail</p>
								<p>
									Structure: <%= p.getStructure() %><br />
									Sous-structure: <%= p.getSousStructure() %><br />
									Bureau: <%= p.getBureau() %><br />
								</p>
							</div>
						</div>
				      </div>
				    </div>
				  </div>
				</div>
	<% 		} 
		}
		if (lPersonnes != null && lPersonnes.length == 0){
			%>
			<p>Aucun Résultat</p>
			<%
		}
	%>
			</div>
		</div>
	</section>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>