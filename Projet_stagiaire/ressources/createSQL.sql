DROP DATABASE projet_stagiaire;
CREATE DATABASE projet_stagiaire;
/*CREATE USER 'projet_stagiaire'@'localhost' IDENTIFIED BY 'projet_stagiaire';*/
GRANT ALL PRIVILEGES ON projet_stagiaire.* TO 'projet_stagiaire'@'localhost';
USE projet_stagiaire;

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
	id INT PRIMARY KEY,
	nom VARCHAR(64),
	sujet VARCHAR(64)
);


CREATE TABLE question (
	id INT PRIMARY KEY,
	questionnaire_id INT,
	ordre INT UNIQUE,
	texte VARCHAR(128),
	FOREIGN KEY (questionnaire_id) REFERENCES questionnaire(id)
);


CREATE TABLE reponse (
	id INT PRIMARY KEY,
	question_id INT,
	ordre INT UNIQUE,
	texte VARCHAR(128),
	FOREIGN KEY (question_id) REFERENCES question(id)
);