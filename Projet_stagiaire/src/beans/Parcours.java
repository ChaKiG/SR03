package beans;

import java.time.Duration;

public class Parcours {

	public Integer id;
	public Questionnaire questionnaire ;
	public Utilisateur utilisateur;
	public Integer score;
	public Duration duree;
	
	public Parcours() {}
	public Parcours(int id, Questionnaire questionnaire, Utilisateur utilisateur, int score, Duration duree ) {
		this.id = id;
		this.questionnaire = questionnaire;
		this.utilisateur = utilisateur;
		this.score = score;
		this.duree = duree;
	}

}
