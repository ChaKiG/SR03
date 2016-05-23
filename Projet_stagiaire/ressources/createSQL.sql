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
	mail VARCHAR(64) UNIQUE NOT NULL,
	mot_de_passe VARCHAR(64) NOT NULL,
	type_utilisateur INT NOT NULL,
	active INT NOT NULL,
	telephone VARCHAR(10) NOT NULL,
	societe VARCHAR(64) NOT NULL,
	creation DATETIME
);

CREATE TABLE sujet (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(64) NOT NULL
);

CREATE TABLE questionnaire (
	id INT PRIMARY KEY AUTO_INCREMENT,
	utilisateur_id INT NOT NULL,
	sujet_id INT NOT NULL,
	nom VARCHAR(64) NOT NULL,
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id),
	FOREIGN KEY (sujet_id) REFERENCES sujet(id)
);


CREATE TABLE question (
	id INT PRIMARY KEY AUTO_INCREMENT,
	questionnaire_id INT NOT NULL,
	ordre INT NOT NULL,
	texte VARCHAR(128) NOT NULL,
	FOREIGN KEY (questionnaire_id) REFERENCES questionnaire(id)
);


CREATE TABLE reponse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	question_id INT NOT NULL,
	ordre INT NOT NULL,
	texte VARCHAR(128) NOT NULL,
	is_correct INT NOT NULL,
	FOREIGN KEY (question_id) REFERENCES question(id)
);



CREATE TABLE parcours (
	id INT PRIMARY KEY AUTO_INCREMENT,
	questionnaire_id INT NOT NULL,
	utilisateur_id INT NOT NULL,
	score INT NOT NULL,
	duree TIME NOT NULL,
	FOREIGN KEY (questionnaire_id) REFERENCES question(id),
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)	
);

CREATE TABLE reponse_util (
	id INT PRIMARY KEY AUTO_INCREMENT,
	parcours_id INT NOT NULL,
	reponse_id INT NOT NULL,
	utilisateur_id INT NOT NULL,
	FOREIGN KEY (parcours_id) REFERENCES parcours(id),
	FOREIGN KEY (reponse_id) REFERENCES reponse(id),
	FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id)	
);