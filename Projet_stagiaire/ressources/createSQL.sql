CREATE DATABASE IF NOT EXISTS sr03p013;
USE sr03p013;

DROP TABLE IF EXISTS reponse_util;
DROP TABLE IF EXISTS parcours;
DROP TABLE IF EXISTS reponse;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS questionnaire;
DROP TABLE IF EXISTS sujet;
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

CREATE TABLE sujet (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(64)
);

CREATE TABLE questionnaire (
	id INT PRIMARY KEY AUTO_INCREMENT,
	utilisateur_id INT,
	sujet_id INT,
	nom VARCHAR(64),
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id),
	FOREIGN KEY (sujet_id) REFERENCES sujet(id)
);


CREATE TABLE question (
	id INT PRIMARY KEY AUTO_INCREMENT,
	questionnaire_id INT,
	ordre INT,
	texte VARCHAR(128),
	FOREIGN KEY (questionnaire_id) REFERENCES questionnaire(id)
);


CREATE TABLE reponse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	question_id INT,
	ordre INT UNIQUE,
	texte VARCHAR(128),
	FOREIGN KEY (question_id) REFERENCES question(id)
);



CREATE TABLE parcours (
	id INT PRIMARY KEY AUTO_INCREMENT,
	questionnaire_id INT,
	utilisateur_id INT,
	score INT,
	duree TIME,
	FOREIGN KEY (questionnaire_id) REFERENCES question(id),
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)	
);

CREATE TABLE reponse_util (
	id INT PRIMARY KEY AUTO_INCREMENT,
	parcours_id INT,
	reponse_id INT,
	utilisateur_id INT,
	FOREIGN KEY (parcours_id) REFERENCES parcours(id),
	FOREIGN KEY (reponse_id) REFERENCES reponse(id),
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)	
);