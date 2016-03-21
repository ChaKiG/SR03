function getHtml(personne) {
	var text ="";
	
	text += '<div class="col-sm-4 divPers">' +
				'<div class="row">' +
					'<div class="col-xs-6 boxPers">' +
						'<img alt="Photo non disponible" src="' + personne.photo + '" width="96px" height="120px"/>' +
					'</div>' +
					'<div class="col-xs-6"><p>' +
						personne.nom + '<br />' +
						personne.login + '</p>' +
					'</div>' +
					'<button type="button" class="btn btn-default btn-lg modalButton" data-toggle="modal" data-target="#' + personne.login + '">' +
						'<span class="glyphicon glyphicon-resize-full"></span>' +
					'</button>' +
				'</div>' +
			'</div>';
	text += '<div class="modal fade" id="' + personne.login + '" tabindex="-1" role="dialog" aria-labelledby="' + personne.login + 'Label">' +
				'<div class="modal-dialog" role="document">' +
					'<div class="modal-content">' + 
						'<div class="modal-header">' +
						'<button type="button" class="close" data-dismiss="modal" aria-label="Fermer"><span aria-hidden="true">&times;</span></button>' +
							'<h4 class="modal-title" id="' + personne.login + 'Label">' + personne.nom + '</h4>' +
						'</div>' +
						'<div class="modal-body">' +
							'<div class="row">' +
								'<div class="col-md-3">' +
									'<img alt="Photo non disponible" src="' + personne.photo + '" width="96px" height="120px"/>' +
								'</div>' +
								'<div class="col-md-9">';
	text += 						'<p class="category">Informations</p>' +
									'<p>' +
										'Login : ' + personne.login + '<br />' +
										'Nom : ' + personne.nom + '<br />' +
										'Poste : ' + personne.poste + '<br />' +
									'</p>' +
									'<p class="category">Contact</p>' +
									'<p>' +
										'Mail : ' + personne.mail + '<br />' +
										'Tel. : ' + personne.tel + '<br />' +
										'Tel2. : ' + personne.tel2 + '<br />' +
									'</p>' +
									'<p class="category">Travail</p>' +
										'<p>' +
											'Structure : ' + personne.structure + '<br />' +
											'Sous-structure : ' + personne.sousStructure + '<br />' +
											'Bureau : ' + personne.bureau + '<br />' +
										'</p>' +
								'</div>' +
							'</div>' +
						'</div>' +
					'</div>' +
				'</div>' +
			'</div>' +
		'</div>';
	return text;
}


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
	
	
	$('#searchName').submit(function(event) {
		var nomVal = $('#nom').val();
		var prenomVal = $('#prenom').val();
		$.get('PersonneServlet',{nom:nomVal,prenom:prenomVal},function(responseText) {

			console.log(responseText);
			var pers ="";
			if (responseText.length <= 0) {
				pers = '<p>Aucun Résultat</p>';
			} else {
				$.each( responseText, function( key, value) {
					console.log(value);
					pers += getHtml(value);
				});
			}
			console.log(pers);
			$('#divPers').html(pers);
		});
		event.preventDefault();
	});
	
	
	

	$('#searchStructure').submit(function(event) {
		var structId = $('#structure').val();
		var sousStructId = $('#sousStructure').val();
		$.get('StructureServlet',{structId:structId,sousStructId:sousStructId},function(responseText) {
			
			var pers ="";
			if (responseText.length >= 0) {
				pers = '<p>Aucun Résultat</p>';
			} else {
				$.each( responseText, function( key, value) {
					pers += getHtml(value);
				});
			}
			console.log(responseText);
			$('#divPers').html(pers);
		});
		event.preventDefault();
	});
	
});