package beans;

import java.util.Date;

public class Parcours {

	public Integer id;
	public Questionnaire questionnaire ;
	public Utilisateur utilisateur;
	public Integer score;
	public Date duree;
	
	public Parcours() {}
	public Parcours(int id, Questionnaire questionnaire, Utilisateur utilisateur, int score, Date duree ) {
		this.id = id;
		this.questionnaire = questionnaire;
		this.utilisateur = utilisateur;
		this.score = score;
		this.duree = duree;
	}

}
