package beans;

public class Reponse {
	
	public Integer id;
	public Question question;
	public Integer ordre;
	public String texte;
	public Integer isCorrect;
	
	public Reponse() {}
	public Reponse(int id, Question question, int ordre, String texte, int isCorrect ) {
		this.id = id;
		this.question = question;
		this.ordre = ordre;
		this.texte = texte;
		this.isCorrect = isCorrect;
	}
	
}
