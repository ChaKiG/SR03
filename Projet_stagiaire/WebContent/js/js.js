
function connect() {
	"use strict";
	var mail = document.getElementById("mail").value,
		mdp = document.getElementById("mdp").value,
		req = new XMLHttpRequest();
	
	req.addEventListener('readystatechange', function() {
        if (req.readyState === XMLHttpRequest.DONE && req.status === 200) {
        	if (req.responseText === "Ok") {
        		window.location.href = "/Projet_stagiaire/user";
	        } else {
	        	if (req.responseText == "Inactive"){
	        		document.getElementById("error").innerHTML = "Compte désactivé, veuillez contacter l'administrateur";
	        	} else if (req.responseText == "Inexistant") {
	        		document.getElementById("error").innerHTML = "Identifiants incorrects";
	        	}
	        	setTimeout(function() { document.getElementById("error").innerHTML = "" }, 3000);
	        }
        }
	});
	
	req.open("POST", "/Projet_stagiaire/connect", true);
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	req.send("mail=" + mail + "&mdp=" + mdp);
	return false;
}


function disconnect() {
	"use strict";
	var req = new XMLHttpRequest();
	
	req.addEventListener('readystatechange', function() {
        if (req.readyState === XMLHttpRequest.DONE && req.status === 200) {
    		window.location.href = "/Projet_stagiaire/index";
        }
	});	
	req.open("GET", "/Projet_stagiaire/disconnect", true);
	req.send(null);
	return false;
}



function parcours() {
	"use strict";
	var questionnaire = document.getElementById("form").name,
		fields = document.getElementById("form").elements,
		req = new XMLHttpRequest(),
		str = "";
	
	for (var i = 0; i < fields.length; i++) {
	    if (fields[i].type === "radio" && fields[i].checked === true) {
	    	if (str !== "")
	    		str += "&"
	    	str += fields[i].name + "=" + fields[i].value;
	    }
	}
	
	req.addEventListener('readystatechange', function() {
        if (req.readyState === XMLHttpRequest.DONE && req.status === 200) {
    		// afficher ok;
        }
	});	
	req.open("POST", "/Projet_stagiaire/parcours", true);
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	req.send("q="+ questionnaire + "&" + str);
	return false;
}