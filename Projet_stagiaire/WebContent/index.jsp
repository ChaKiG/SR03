<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page d'accueil</title>
</head>
<body>
	<h1>Veuillez vous connecter :</h1>
	<form onsubmit="return login();">
		<label for="mail">Mail :</label><br />
		<input type="text" id="mail" name="mail" placeholder="Adresse mail" /><br />
		<label for="mdp">Mot de Passe :</label><br />
		<input type="password" id="mdp" name="mdp"  placeholder="********" /><br />
		<p id="error"></p>
		<input type="submit" value="Envoyer" />
	</form>
	
	<script src="js/js.js"></script>
</body>
</html>