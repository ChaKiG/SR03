package trombi;

public class Personne {
	private String prenom;
	private String nom;
	private String tel;
	private String tel2;
	private String bureau;
	private String structure;
	private String sousStructure;
	private String poste;
	private String mail;
	private String autorisation;
	private String photo;
	private String login;
	
	public Personne() {}
	
	public Personne(String prenom, String nom, 
					String tel, String tel2,
					String bureau, String structure,
					String sousStructure, String poste,
					String mail, String autorisation,
					String photo, String login) {
		this.prenom = prenom;
		this.nom = nom;
		this.tel = tel;
		this.tel2 = tel2;
		this.bureau = bureau;
		this.structure = structure;
		this.sousStructure = sousStructure;
		this.poste = poste;
		this.mail = mail;
		this.autorisation = autorisation;
		this.photo = photo;
		this.login = login;	
	}

	
	public String getPrenom() {return prenom;}
	public String getNom() {return nom;}
	public String getTel() {return tel;}
	public String getTel2() {return tel2;}
	public String getBureau() {return bureau;}
	public String getStructure() {return structure;}
	public String getSousStructure() {return sousStructure;}
	public String getPoste() {return poste;}
	public String getMail() {return mail;}
	public String getAutorisation() {return autorisation;}
	public String getPhoto() {return photo;}
	public String getLogin() {return login;}

	
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public void setNom(String nom) {this.nom = nom;}
	public void setTel(String tel) {this.tel = tel;}
	public void setTel2(String tel2) {this.tel2 = tel2;}
	public void setBureau(String bureau) {this.bureau = bureau;}
	public void setStructure(String structure) {this.structure = structure;}
	public void setSousStructure(String sousStructure) {this.sousStructure = sousStructure;}
	public void setPoste(String poste) {this.poste = poste;}
	public void setMail(String mail) {this.mail = mail;}
	public void setAutorisation(String autorisation) {this.autorisation = autorisation;}
	public void setPhoto(String photo) {this.photo = photo;}
	public void setLogin(String login) {this.login = login;}
}
