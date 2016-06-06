package beans;

import java.util.List;

public class Annuaire {
	private List<Categorie> categories;
	
	public Annuaire( List<Categorie> categories) {
		this.categories = categories;
	}
	
	public List<Categorie> getCategories() {return categories;}
	
	public void setCategories( List<Categorie> categories) {this.categories = categories;}
}
