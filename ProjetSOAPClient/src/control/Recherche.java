package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import beans.Annonce;

public class Gestion {
	int categorie = 0;
	int annonceId = 0;
	boolean isCreating = false;
	boolean isModifying = false;
	boolean isDeleting = false;
	
	public Gestion() {}
	
	public Gestion( Integer categorie, Integer annonceId, Boolean isCreating, 
			Boolean isModifying, Boolean isDeleting) {
		if (categorie != null)
			this.categorie = categorie;
		if (annonceId != null)
			this.annonceId = annonceId;
		if (isCreating != null)
			this.isCreating = isCreating;
		if (isModifying != null)
			this.isModifying = isModifying;
		if (isDeleting != null)
			this.isDeleting = isDeleting;
	}
	
	public List<Annonce> getAnnonces() {
		annoncesSOAP.AnnonceSOAPProxy p = new annoncesSOAP.AnnonceSOAPProxy("");
		List<Annonce> annonces = null;
		try {
			if (annonceId > 0) {
			p.getAnnonces();
			} else if (categorie > 0) {
				annonces = new ArrayList<Annonce>(Arrays.asList(p.getAnnoncesCat(categorie)));
			} else {
				annonces = new ArrayList<Annonce>(Arrays.asList(p.getAnnonces()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return annonces;
	}
	
	
	
}
