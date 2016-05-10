package beans;

public class Questionnaire {

	public Integer id;
	public Utilisateur utilisateur;
	public String nom;
	public Sujet sujet;
	
	public Questionnaire() {}
	public Questionnaire(int id, Utilisateur utilisateur, String nom, Sujet sujet) {
		this.id = id;
		this.utilisateur = utilisateur;
		this.nom = nom;
		this.sujet = sujet;
	}
	
	
}
