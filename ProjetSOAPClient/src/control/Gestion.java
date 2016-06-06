package control;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import beans.*;

public class Gestion {
	int action = -1;
	int categorie = 0;
	String message = "";
	Annonce a = new Annonce();
	categoriesSOAP.CategorieSOAPProxy catProxy = new categoriesSOAP.CategorieSOAPProxy("http://localhost:8080/ProjetSOAP/services/CategorieSOAP");
	annoncesSOAP.AnnonceSOAPProxy annonceProxy = new annoncesSOAP.AnnonceSOAPProxy("http://localhost:8080/ProjetSOAP/services/AnnonceSOAP");
	List<Annonce> annonces = null;
	
	
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
		switch (action) {
		case 0:
			this.message = "Bienvenue";
			getSOAPAnnonces();
			break;
		case 1:
			createAnnonce();
			break;
		case 2:
			updateAnnonce();
			break;
		case 3:
			deleteAnnonce();
			break;
		}
	}
	
	public String getMessage() {
		return message;
	}
	
	
	public void getSOAPAnnonces() {
		try {
			if (a.getId() > 0) {
				annonces = new ArrayList<Annonce>(Arrays.asList(annonceProxy.getAnnonce(a.getId())));
			} else if (categorie > 0) {
				annonces = new ArrayList<Annonce>(Arrays.asList(annonceProxy.getAnnoncesCat(categorie)));
			} else {
				annonces = new ArrayList<Annonce>(Arrays.asList(annonceProxy.getAnnonces()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Annonce> getAnnonces() {
		return annonces;
	}
	
	
	public List<Categorie> getCategories() {
		List<Categorie> categories = null;
		try {
			categories = new ArrayList<Categorie>( Arrays.asList( catProxy.getCategories()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	
	private void createAnnonce() {
		try {
			if (annonceProxy.createAnnonce(a) > 0)
				this.message = "Création d'annonce réussie";
			else 
				this.message = "Echec !!!!";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void updateAnnonce() {
		try {
			if (annonceProxy.modifyAnnonce(a) == true)
				this.message = "Modification d'annonce réussie";
			else 
				this.message = "Echec !!!!";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	private void deleteAnnonce() {
		try {
			if (annonceProxy.deleteAnnonce(a) == true)
				this.message = "Suppression d'annonce réussie";
			else 
				this.message = "Echec !!!!";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
}
