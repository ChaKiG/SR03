package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import beans.Annonce;

public class Gestion {
	int categorie = 0;
	boolean isCreating = false;
	boolean isModifying = false;
	boolean isDeleting = false;
	Annonce a = new Annonce();
	
	public Gestion() {}
	
	public Gestion(Map<String, String[]> map) {
		
		for(Entry<String, String[]> entry : map.entrySet()) {
		    String val[] = entry.getValue();
			String key = entry.getKey();
			
			switch (key) {
			case "cat":
				this.categorie = Integer.valueOf(val[0]);
				break;
			case "annonce":
				this.a.setId(Integer.valueOf(val[0]));
				break;
			case "delete":
				if (val[0].equals("1"))
					this.isDeleting = true;
				break;
			case "modify":
				if (val[0].equals("1"))
					this.isModifying = true;
				break;
			case "add":
				if (val[0].equals("1"))
					this.isCreating = true;
				break;
			case "categorie":
				this.categorie = Integer.valueOf(val[0]);
				break;
			case "nom":
				this.a.setNom(val[0]);
				break;
			case "telephone":
				this.a.setTelephone(Integer.valueOf(val[0]));
				break;
			case "adresse.id":
				break;
			case "adresse.CP":
				break;
			case "adresse.ville":
				break;
			case "adresse.rue":
				break;
			case "adresse.num":
				break;
			}
		}
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
	
	
	private int createAnnonce() {return -1;}
	private int updateAnnonce() {return -1;}
	private int deleteAnnonce() {return -1;}
	
	private int updateAnnonce() {return -1;}
	private int updateAnnonce() {return -1;}
	private int updateAnnonce() {return -1;}
	
}
