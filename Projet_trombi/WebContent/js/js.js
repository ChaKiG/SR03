/*
	PersonneServlet  -> envoi nom/prenom

*/

$(document).ready(function() {
	$('#structure').change( function() {
		var IdStructure = $('#structure').val();
		$.get('SousStructureServlet',{structure:IdStructure},function(responseText) {
			$('#sousStructure').find('option').remove();
			$.each( responseText, function( key, value) {
				$('#sousStructure').append('<option value=' + value.structure.structId + '>' + value.structureLibelle + '</option>');
			});
		});
	});
	
	
	$('#searchName').click(function() {
		var nomVal = $('#nom').val();
		var prenomVal = $('#prenom').val();
		$.get('PersonneServlet',{nom:nomVal,prenom:prenomVal},function(responseText) {
			
			var pers ="";
			if (responseText.length >= 0) {
				pers = '<p>Aucun Résultat</p>';
			} else {
				$.each( responseText, function( key, value) {
					pers += '<option value=' + value.structure.structId + '>' + value.structureLibelle + '</option>';
				});
			}
			$('#divPers').innerHTML = pers;
		});
	});
});
				
/*		
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
				}*/
	