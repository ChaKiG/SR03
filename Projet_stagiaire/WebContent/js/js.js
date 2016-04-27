
function login() {
	"use strict";
	var mail = document.getElementById("mail").value,
		mdp = document.getElementById("mdp").value;
	var req = new XMLHttpRequest();
	
	req.addEventListener('readystatechange', function() {
        if (req.readyState === XMLHttpRequest.DONE && req.status === 200) {
        	if (req.responseText === "Ok") {
        		window.location.href = "/Projet_stagiaire/user";
	        } else {
	        	document.getElementById("error").innerHTML = "Identifiants incorrects";
	        	setTimeout(function() { document.getElementById("error").innerHTML = "" }, 3000);
        	}
        }
	});
	
	req.open("POST", "/Projet_stagiaire/login", true);
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	req.send("mail=" + mail + "&mdp=" + mdp);
	return false;
}