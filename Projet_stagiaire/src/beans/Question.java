package beans;

public class Question {
	public Integer id;
	public Questionnaire questionnaire ;
	public Integer ordre;
	public String texte;
	public Integer isCorrect;
	
	public Question() {}
	public Question(int id, Questionnaire questionnaire, int ordre, String texte, int isCorrect) {
		this.id = id;
		this.questionnaire = questionnaire ;
		this.ordre = ordre;
		this.texte = texte;
		this.isCorrect = isCorrect;
	}

}
