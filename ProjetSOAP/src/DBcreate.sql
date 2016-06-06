DROP schema IF EXISTS projet_soap;
CREATE schema projet_soap;
USE projet_soap;


CREATE TABLE categorie(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(256)
);

CREATE TABLE adresse(
	id INT PRIMARY KEY AUTO_INCREMENT,
	code_postal INT,
	ville VARCHAR(256),
	rue VARCHAR(256),
	numero INT
);

CREATE TABLE annonce(
	id INT PRIMARY KEY AUTO_INCREMENT,
	categorie INT,
	adresse INT,
	nom VARCHAR(256),
	telephone INT,
	FOREIGN KEY (categorie) REFERENCES categorie(id) ON DELETE CASCADE,
	FOREIGN KEY (adresse) REFERENCES adresse(id) ON DELETE CASCADE
);

