package beans;

import java.util.List;

public class Categorie {
	private int id;
	private String titre;
	private List<Annonce> annonces;
	
	public Categorie() {}
	public Categorie(int id, String titre, List<Annonce> annonces){
		this.id = id;
		this.titre = titre;
		this.annonces = annonces;
	}
	
	public int getId() {return this.id;}
	public String getTitre() {return this.titre;}
	public List<Annonce> getAnnonces() {return this.annonces;}
	
	public void setId( int id) {this.id = id;}
	public void setTitre( String titre) {this.titre = titre;}
	public void setAnnonces( List<Annonce> annonces) {this.annonces = annonces;}
}
