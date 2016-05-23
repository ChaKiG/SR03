package beans;

public class Reponse {
	
	public Integer id;
	public Question question;
	public Integer ordre;
	public String texte;
	
	public Reponse() {}
	public Reponse(int id, Question question, int ordre, String texte ) {
		this.id = id;
		this.question = question;
		this.ordre = ordre;
		this.texte = texte;
	}
	
}
