package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import beans.*;

public class Gestion {
	int action = -1;
	int categorie = 0;
	Annonce a = new Annonce();
	
	public Gestion() {}
	
	public Gestion(Map<String, String[]> map) {
		
		for(Entry<String, String[]> entry : map.entrySet()) {
		    String val[] = entry.getValue();
			String key = entry.getKey();
			
			switch (key) {
			case "annonce":
				this.a.setId(Integer.valueOf(val[0]));
				break;
			case "action":
				if (val[0].equals("add"))
					this.action = 1;
				if (val[0].equals("mod"))
					this.action = 2;
				if (val[0].equals("del"))
					this.action = 3;
				break;
			case "categorie":
				this.categorie = Integer.valueOf(val[0]);
				this.a.setCategorie(this.categorie);
				break;
			case "nom":
				this.a.setNom(val[0]);
				break;
			case "telephone":
				this.a.setTelephone(Integer.valueOf(val[0]));
				break;
			case "adresse.id":
				a.getAdresse().setId(Integer.valueOf(val[0]));
				break;
			case "adresse.CP":
				a.getAdresse().setCode_postal(Integer.valueOf(val[0]));
				break;
			case "adresse.ville":
				a.getAdresse().setVille(val[0]);
				break;
			case "adresse.rue":
				a.getAdresse().setRue(val[0]);
				break;
			case "adresse.num":
				a.getAdresse().setNumero(Integer.valueOf(val[0]));
				break;
			}
		}
	}
	
	public List<Annonce> getAnnonces() {
		annoncesSOAP.AnnonceSOAPProxy p = new annoncesSOAP.AnnonceSOAPProxy("");
		List<Annonce> annonces = null;
		try {
			if (a.getId() > 0) {
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
	
	public List<Categorie> getCategories() {
		categoriesSOAP.CategorieSOAPProxy c = new categoriesSOAP.CategorieSOAPProxy("");
		List<Categorie> categories = null;
		try {
			categories = new ArrayList<Categorie>( Arrays.asList( c.getCategories()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	
	private int createAnnonce() {return -1;}
	private int updateAnnonce() {return -1;}
	private int deleteAnnonce() {return -1;}
	
	
}
