package endpoints;

import java.util.List;
import beans.Annonce;
import beans.Categorie;
import dao.AnnonceDAO;
import dao.CategorieDAO;



public class CategorieSOAP {
	
	public CategorieSOAP() { super(); }
	
	public Categorie[] getCategories() {
		List<Categorie> l = CategorieDAO.getCategories();
		System.out.println("SOAP Categorie service returning " + l.size() + " rows");
		return l.toArray(new Categorie[l.size()]);
	}
	
	public Categorie getCategorie(int id) {
		Categorie a = CategorieDAO.getCategorie(id);
		System.out.println("SOAP Categorie service returning categorie : " + a.id + " -- " + a.nom);
		return a;
	}
	
	public int addCategorie(Categorie c) {
		return CategorieDAO.addCategorie(c);
	}
	
	public boolean delCategorie(int cat_id) {
		return CategorieDAO.delCategorie(cat_id);
	}
	
	public boolean deleteAnnonce(Annonce a) {
		return AnnonceDAO.deleteAnnonce(a);	
	}
}
