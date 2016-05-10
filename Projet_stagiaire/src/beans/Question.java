package beans;

public class Question {
	public Integer id;
	public Questionnaire questionnaire ;
	public Integer ordre;
	public String texte;
	
	public Question() {}
	public Question(int id, Questionnaire questionnaire, int ordre, String texte ) {
		this.id =id;
		this.questionnaire = questionnaire ;
		this.ordre = ordre;
		this.texte = texte;
	}

}
