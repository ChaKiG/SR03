function collapseNavbar() {
	if ($(".navbar").offset().top > 80) {
		$(".navbar-fixed-top").removeClass("navbar-plain");
		$(".navbar-fixed-top").addClass("navbar-minified");
		$(".to-top").removeClass("hidden");
	} else {
		$(".navbar-fixed-top").removeClass("navbar-minified");
		$(".navbar-fixed-top").addClass("navbar-plain");
		$(".to-top").addClass("hidden");
	}
}
$(window).scroll(collapseNavbar);
$(document).ready(collapseNavbar);



function handleImgError(image) {
	image.onerror = "";
    image.src = "noPhoto.png";
    return true;	
}

function getHtml(personne) {
	var text ="";
	
	text += '<div class="col-sm-4 divPers">' +
				'<div class="row">' +
					'<div class="col-xs-6 boxPers">' +
						'<img alt="Photo non disponible" src="' + personne.photo + '" onerror="handleImgError(this);" width="96px" height="120px"/>' +
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
									'<img alt="Photo non disponible" src="' + personne.photo + '" class="persPhoto" onerror="handleImgError(this);" />' +
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
										'Mail : ' + personne.mail + '<br />';
	if (personne.tel !== null && personne.tel !== "") {
		text +=							'Tel. : ' + personne.tel;
		if (personne.tel2 !== null && personne.tel2 !== "") {
			text +=						' ou ' + personne.tel2;
		}
		text += 						'<br />';
	}
									'</p>' +
									'<p class="category">Travail</p>' +
										'<p>';
	if (personne.structure !== null && personne.structure !== "") {
		text +=							'Structure : ' + personne.structure + '<br />';
	}
	if (personne.sousStructure !== null && personne.sousStructure !== "") {
		text +=							'Sous-structure : ' + personne.sousStructure + '<br />';
	}
	if (personne.bureau !== null && personne.bureau !== "") {
		text +=							'Bureau : ' + personne.bureau + '<br />';
	}
	text +=							'</p>' +
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
			$('#sousStructure').append('<option value="0">--</option>');
			$.each( responseText, function( key, value) {
				$('#sousStructure').append('<option value=' + value.structure.structId + '>' + value.structureLibelle + '</option>');
			}).fail(function(){
				if (($('#alertNetwork').length)) {
					$('#alertNetwork').remove();
				}
				$("#divPers").empty();
				$('<div id="alertNetwork" class="alert alert-danger" role="alert">Erreur réseau, impossible de se connecter au serveur. Veuillez réessayer plus tard</div>').appendTo( "#divPers");
			});
		});
	});
	
	
	$('#searchName').submit(function(event) {
		var nomVal = $('#nom').val();
		var prenomVal = $('#prenom').val();
		
		if (($('#alertName').length)) {
			$('#alertName').remove();
		}
		
		if( !nomVal.trim() && !prenomVal.trim()) {
			$('<div id="alertName" class="alert alert-danger" role="alert">Vous n\'avez pas saisi de nom ni de prénom.</div>').appendTo( "#errorName");
			return false;
		}
		
		$.get('PersonneServlet',{nom:nomVal,prenom:prenomVal},function(responseText) {
			var pers ="";
			if (responseText.length <= 0) {
				pers = '<div id="alertName" class="alert alert-info" role="alert">Aucun résultat</div>';
			} else {
				$.each( responseText, function( key, value) {
					pers += getHtml(value);
				});
			}
			$('#divPers').html(pers);
		}).fail(function(){
			if (($('#alertNetwork').length)) {
				$('#alertNetwork').remove();
			}
			$("#divPers").empty();
			$('<div id="alertNetwork" class="alert alert-danger" role="alert">Erreur réseau, impossible de se connecter au serveur. Veuillez réessayer plus tard</div>').appendTo( "#divPers");
		});
		event.preventDefault();
	});
	
	
	

	$('#searchStructure').submit(function(event) {
		var structId = $('#structure').val();
		var sousStructId = $('#sousStructure').val();
		
		if (($('#alertStructure').length)) {
			$('#alertStructure').remove();
		}
		
		if( structId == 0 && sousStructId == 0) {
			$('<div id="alertStructure" class="alert alert-danger" role="alert">Vous n\'avez pas choisi de structure.</div>').appendTo( "#errorStructure");
			return false;
		}
		
		$.get('StructureServlet',{structId:structId,sousStructId:sousStructId},function(responseText) {
			
			var pers ="";
			if (responseText.length <= 0) {
				pers = '<div id="alertName" class="alert alert-info" role="alert">Aucun résultat</div>';
			} else {
				$.each( responseText, function( key, value) {
					pers += getHtml(value);
				});
			}
			$('#divPers').html(pers);
		}).fail(function(){
			if (($('#alertNetwork').length)) {
				$('#alertNetwork').remove();
			}
			$("#divPers").empty();
			$('<div id="alertNetwork" class="alert alert-danger" role="alert">Erreur réseau, impossible de se connecter au serveur. Veuillez réessayer plus tard</div>').appendTo( "#divPers");
		});
		event.preventDefault();
	});
});
