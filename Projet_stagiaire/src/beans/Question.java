package beans;

public class Question {
	public Integer id;
	public Integer questionnaire_id ;
	public Integer ordre;
	public String texte;
	
	public Question() {}
	public Question(int id, int questionnaire_id, int ordre, String texte ) {
		this.id =id;
		this.questionnaire_id = questionnaire_id ;
		this.ordre = ordre;
		this.texte = texte;
	}

}
