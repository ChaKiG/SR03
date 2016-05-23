use sr03p013;

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
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(2, 1, 2, "question 2 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(3, 1, 3, "question 3 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(4, 1, 4, "question 4 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(5, 1, 5, "question 5 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(6, 1, 6, "question 6 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(7, 1, 7, "question 7 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(8, 1, 8, "question 8 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(9, 1, 9, "question 9 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(10, 1, 10, "question 10 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(11, 1, 11, "question 11 !!");
INSERT INTO question(id, questionnaire_id, ordre, texte)
			VALUES(12, 1, 12, "question 12 !!");
			
			
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(1, 1, "Reponse 1 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(1, 2, "Reponse 2 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(1, 3, "Reponse 3 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(2, 1, "Reponse 1 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(2, 2, "Reponse 2 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(3, 1, "Reponse 1 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(3, 2, "Reponse 2 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(4, 1, "Reponse 1 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(4, 2, "Reponse 2 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(5, 1, "Reponse 1 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(5, 2, "Reponse 2 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(6, 1, "Reponse 1 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(6, 2, "Reponse 2 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(7, 1, "Reponse 1 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(7, 2, "Reponse 2 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(8, 1, "Reponse 1 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(8, 2, "Reponse 2 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(9, 1, "Reponse 1 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(9, 2, "Reponse 2 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(10, 1, "Reponse 1 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(10, 2, "Reponse 2 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(11, 1, "Reponse 1 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(11, 2, "Reponse 2 !!!", 1);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(12, 1, "Reponse 1 !!!", 0);
INSERT INTO reponse(question_id, ordre, texte, is_correct)
			VALUES(12, 2, "Reponse 2 !!!", 1);
