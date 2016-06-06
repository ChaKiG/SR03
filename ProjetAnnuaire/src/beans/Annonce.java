package beans;

public class Annonce {
	private String nom;
	private Adresse adresse;
	private int telephone;
	
	public Annonce(String nom, Adresse adresse, int telephone){
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	public String getNom(){return this.nom;}
	public Adresse getAdresse(){return this.adresse;}
	public int getTelephone(){return this.telephone;}
	
	public void setNom( String nom) {this.nom = nom;}
	public void setAdresse( Adresse adresse) {this.adresse = adresse;}
	public void setTelephone( int telephone) {this.telephone = telephone;}
}
