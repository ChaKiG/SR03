package beans;

public class ReponseUtil {

	public Integer id;
	public Reponse reponse;
	public Utilisateur utilisateur;
	
	public ReponseUtil() {}
	public ReponseUtil(int id, Reponse reponse, Utilisateur utilisateur ) {
		this.id = id;
		this.reponse = reponse;
		this.utilisateur = utilisateur;
	}
	
}
