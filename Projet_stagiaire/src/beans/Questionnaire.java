package beans;

public class Questionnaire {

	public Integer id;
	public Integer utilisateur_id;
	public String nom;
	public Integer sujet_id;
	
	public Questionnaire() {}
	public Questionnaire(int id, int utilisateur_id, String nom, int sujet_id) {
		this.id = id;
		this.utilisateur_id = utilisateur_id;
		this.nom = nom;
		this.sujet_id = sujet_id;
	}
	
	
}
