INSERT INTO utilisateur(
	id,
	mail,
	mot_de_passe,
	type_utilisateur,
	active,
	telephone,
	societe,
	creation
) VALUES(
	1,
	"sr03p013",
	"sr03p013",
	1,
	1,
	"0675408381",
	"UTC",
	null
);


INSERT INTO utilisateur(
	id,
	mail,
	mot_de_passe,
	type_utilisateur,
	active,
	telephone,
	societe,
	creation
) VALUES(
	2,
	"test",
	"test",
	0,
	0,
	"0675408381",
	"societe",
	null
);


INSERT INTO sujet(id, nom) VALUES (1, "sujet1");
INSERT INTO sujet(nom) VALUES ("sujet2");
INSERT INTO sujet(nom) VALUES ("sujet3");
INSERT INTO sujet(nom) VALUES ("sujet4");

INSERT INTO questionnaire(id, utilisateur_id, nom, sujet_id)
			VALUES(1, 1, "q1", 1);
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(1, 1, 1, "question 1 !!");
INSERT INTO reponse(question_id, ordre, texte)
			VALUES(1, 1, "Reponse 1 !!!");
INSERT INTO reponse(question_id, ordre, texte)
			VALUES(1, 2, "Reponse 2 !!!");
INSERT INTO reponse(question_id, ordre, texte)
			VALUES(1, 3, "Reponse 3 !!!");

