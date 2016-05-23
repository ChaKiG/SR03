package beans;

public class ReponseUtil {
	
	public Integer id;
	public Parcours parcours;
	public Reponse reponse;
	
	public ReponseUtil() {}
	public ReponseUtil(int id, Parcours parcours, Reponse reponse) {
		this.id = id;
		this.parcours = parcours;
		this.reponse = reponse;
	}
	
}
