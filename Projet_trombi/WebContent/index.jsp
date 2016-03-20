<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="trombi.DataHandler" %>
<%@ page import="trombi.Personne" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8" />
	<title>Trombi UTC</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="css/css.css" rel="stylesheet" type="text/css" />
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
			<form role="form" method="get" class="divForm">
			<label for="nom">Nom :</label>
			<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="<%= nom %>"/><br />
			<label for="prenom">Prénom :</label>
			<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="<%= prenom %>"/><br />
			
			<label for="struct">Structure : </label>
			<select class="form-control" id="struct">
			<!-- faire boucle sur structures -->
			<option>Structure</option>
			<!--  -->
			</select><br />
			
			<label for="sStruct">Sous-Structure : </label>
			<select class="form-control" id="sStruct">
			<!-- faire boucle sur sous-structure pour la structure -->
			<option>Sous-Structure</option>
			<!--  -->
			</select><br />

			<input type="submit" class="btn btn-default" value="Rechercher"/>			
			</form>
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
									<% 
									String tel1 = p.getTel();
									String tel2 = p.getTel2();
									if (tel1 != null && !tel1.equals("")) {
										out.print("Tel.: " + tel1);
										if (tel2 !=null && !tel2.equals("")) {
											out.print(" OU " + p.getTel2());
										}
										out.print("<br />");
									}
									%>
								</p>
								<p class="category">Travail</p>
									<p>
								<%
								String str = p.getStructure();
								String sstr = p.getSousStructure();
								String bur = p.getBureau();
								out.print("Structure: " + str + "<br />");
								if (sstr != null && !sstr.equals("")) 
									out.print("Sous-structure: " + sstr + "<br />");
								if (bur != null && !bur.equals(""))
									out.print("Bureau: " + bur + "<br />");
								%>
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