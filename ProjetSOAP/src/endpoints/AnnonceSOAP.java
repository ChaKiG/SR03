package endpoints;

import java.util.List;
import beans.Annonce;
import dao.AnnonceDAO;



public class AnnonceSOAP {
	
	public AnnonceSOAP() { super(); }
	
	public Annonce[] getAnnonces() {
		List<Annonce> l = AnnonceDAO.getAnnonces();
		System.out.println("SOAP service returning " + l.size() + " rows");
		return l.toArray(new Annonce[l.size()]);
	}
	
	public Annonce getAnnonce(int id) {
		Annonce a = AnnonceDAO.getAnnonce(id);
		System.out.println("SOAP service returning annonce : " + a.id + " -- " + a.nom);
		return a;
	}
	
	public Annonce[] getAnnoncesCat(int cat_id) {
		List<Annonce> l = AnnonceDAO.getAnnoncesCat(cat_id);
		System.out.println("SOAP service returning " + l.size() + " annonces");
		return l.toArray(new Annonce[l.size()]);
	}

	public int createAnnonce(Annonce a) {
		int id = AnnonceDAO.createAnnonce(a);
		System.out.println("SOAP service creating annonce : " + id + " -- " + a.nom);
		return id;
	}
	
	public boolean modifyAnnonce(Annonce a) {
		System.out.println("SOAP modifying creating annonce : " + a.id + " -- " + a.nom);
		return AnnonceDAO.modifyAnnonce(a);
	}
	
	public boolean deleteAnnonce(Annonce a) {
		System.out.println("SOAP service deleting annonce : " + a.id);
		return AnnonceDAO.deleteAnnonce(a);	
	}
}
