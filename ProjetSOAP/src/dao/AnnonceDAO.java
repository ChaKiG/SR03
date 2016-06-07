package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Annonce;

public class AnnonceDAO {
	private static Connection c = null;
	private static PreparedStatement getAnnonce = null;
	private static PreparedStatement getAnnonces = null;
	private static PreparedStatement getAnnoncesCat = null;
	private static PreparedStatement createAnnonce = null;
	private static PreparedStatement modifyAnnonce = null;
	private static PreparedStatement deleteAnnonce = null;
	
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getAnnonce = c.prepareStatement("SELECT * FROM annonce WHERE id = ?");
				getAnnonces = c.prepareStatement("SELECT * FROM annonce");
				getAnnoncesCat = c.prepareStatement("SELECT * FROM annonce WHERE categorie = ?");
				createAnnonce = c.prepareStatement("INSERT INTO annonce( "
												+ "id, categorie, adresse, nom, telephone) "
												+ "VALUES(?,?,?,?,?)",
												Statement.RETURN_GENERATED_KEYS);
				modifyAnnonce = c.prepareStatement("UPDATE annonce SET "
												+ "categorie = ?, "
												+ "nom = ?, "
												+ "telephone = ? "
												+ "WHERE id = ?");
				deleteAnnonce = c.prepareStatement("DELETE FROM annonce WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Annonce> getAnnonces() {
		List<Annonce> l = new ArrayList<Annonce>();
		try {
			renewConnection();
			ResultSet rs = getAnnonces.executeQuery();			
			while ( rs.next() ) {
				Annonce a = new Annonce();
				a.id = rs.getInt("id");
				a.categorie = rs.getInt("categorie");
				a.adresse = AdresseDAO.getAdresse( rs.getInt("adresse"));
				a.telephone = rs.getInt("telephone");
				a.nom = rs.getString("nom");
				l.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	public static Annonce getAnnonce(int annonce_id) {
		Annonce a = null;
		try {
			renewConnection();
			getAnnonce.setInt(1, annonce_id);
			ResultSet rs = getAnnonce.executeQuery();			
			if ( rs.next() ) {
				a = new Annonce();
				a.id = rs.getInt("id");
				a.categorie = rs.getInt("categorie");
				a.adresse = AdresseDAO.getAdresse( rs.getInt("adresse"));
				a.telephone = rs.getInt("telephone");
				a.nom = rs.getString("nom");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public static List<Annonce> getAnnoncesCat(int cat_id) {
		List<Annonce> l = new ArrayList<Annonce>();
		try {
			renewConnection();
			getAnnoncesCat.setInt(1, cat_id);
			ResultSet rs = getAnnoncesCat.executeQuery();			
			while ( rs.next() ) {
				Annonce a = new Annonce();
				a.id = rs.getInt("id");
				a.categorie = rs.getInt("categorie");
				a.adresse = AdresseDAO.getAdresse( rs.getInt("adresse"));
				a.telephone = rs.getInt("telephone");
				a.nom = rs.getString("nom");
				l.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	public static int createAnnonce(Annonce a) {
		try {
			renewConnection();
			if (a!= null) {
				if (a.id > 0)
					createAnnonce.setInt(1, a.id);
				else
					createAnnonce.setNull(1, java.sql.Types.INTEGER);
				createAnnonce.setInt(2, a.categorie);
				a.adresse.id = AdresseDAO.createAdresse(a.adresse);
				createAnnonce.setInt(3, a.adresse.id);
				createAnnonce.setString(4, a.nom);
				createAnnonce.setInt(5, a.telephone);
				System.out.println(a.adresse.id);
				if (createAnnonce.executeUpdate() >= 1) {
					ResultSet r = createAnnonce.getGeneratedKeys();
					r.next();
					return r.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static boolean modifyAnnonce(Annonce a) {
		try {
			renewConnection();
			System.out.println(new ObjectMapper().writeValueAsString(a));
			boolean ok = AdresseDAO.modifyAdresse(a.adresse);
			if (a!= null && a.id > 0 && ok) {
				modifyAnnonce.setInt(1, a.categorie);
				modifyAnnonce.setString(2, a.nom);
				modifyAnnonce.setInt(3, a.telephone);
				modifyAnnonce.setInt(4, a.id);
				if (modifyAnnonce.executeUpdate() >= 1)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteAnnonce(Annonce a) {
		try {
			renewConnection();
			if (a!= null && a.id > 0) {
				deleteAnnonce.setInt(1, a.id);
				if (deleteAnnonce.executeUpdate() >= 1)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
