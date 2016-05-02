CREATE DATABASE IF NOT EXISTS sr03p013;
USE sr03p013;

DROP TABLE IF EXISTS reponse;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS questionnaire;
DROP TABLE IF EXISTS utilisateur;


CREATE TABLE utilisateur (
	id INT PRIMARY KEY AUTO_INCREMENT,
	mail VARCHAR(64) UNIQUE,
	mot_de_passe VARCHAR(64),
	type_utilisateur INT,
	active BOOLEAN,
	telephone VARCHAR(10),
	societe VARCHAR(64),
	creation DATETIME
);


CREATE TABLE questionnaire (
	id INT PRIMARY KEY AUTO_INCREMENT,
	utilisateur_id INT,
	nom VARCHAR(64),
	sujet VARCHAR(64),
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)
);


CREATE TABLE question (
	id INT PRIMARY KEY AUTO_INCREMENT,
	questionnaire_id INT,
	ordre INT,
	texte VARCHAR(128),
	FOREIGN KEY (questionnaire_id) REFERENCES questionnaire(id)
);


CREATE TABLE reponse (
	id INT PRIMARY KEY,
	question_id INT,
	utilisateur_id INT,
	ordre INT UNIQUE,
	texte VARCHAR(128),
	FOREIGN KEY (question_id) REFERENCES question(id),
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)
);