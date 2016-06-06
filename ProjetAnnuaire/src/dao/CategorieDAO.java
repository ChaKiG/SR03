package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import beans.Categorie;

public class CategorieDAO {

	private static Connection c = null;
	private static PreparedStatement getCategories = null;
	private static PreparedStatement getCategorie = null;
	private static PreparedStatement createCategorie = null;
	private static PreparedStatement modifyCategorie = null;
	private static PreparedStatement deleteCategorie = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					DBConnection.closeConnection();
				c = DBConnection.getConnection();
				getCategories = c.prepareStatement("SELECT * FROM categorie ORDER BY ordre ASC");
				getCategorie = c.prepareStatement("SELECT * FROM categorie WHERE id = ?");
				createCategorie = c.prepareStatement("INSERT INTO categorie( "
														+ "id, titre) "
														+ "VALUES(?,?) ", Statement.RETURN_GENERATED_KEYS);
				modifyCategorie = c.prepareStatement("UPDATE categorie SET "
														+ "titre = ? "
														+ "WHERE id = ? ");
				deleteCategorie = c.prepareStatement("DELETE FROM categorie WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Categorie> getCategories() {
		List<Categorie> l = new ArrayList<Categorie>();
		try {
			renewConnection();
			ResultSet rs = getCategories.executeQuery();
			while ( rs.next() ) {
				Categorie ca = new Categorie();
				ca.setId( rs.getInt("id"));
				ca.setTitre(rs.getString("titre"));
				l.add(ca);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	
	public static Categorie getCategorie(int id) {
		Categorie ca = null;
		try {
			renewConnection();
			getCategorie.setInt(1, id);
			ResultSet rs = getCategorie.executeQuery();			
			if ( rs.next() ) {
				ca = new Categorie();
				ca.setId( rs.getInt("id"));
				ca.setTitre(rs.getString("titre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ca;
	}
	
	public static int createQuestion(Categorie ca) {
		try {
			renewConnection();
			if (ca.getId() > 0)
				createCategorie.setInt(1, ca.getId());
			else
				createCategorie.setNull(1, java.sql.Types.INTEGER);
			createCategorie.setString(2, ca.getTitre());
			if (createCategorie.executeUpdate() >= 1) {
				ResultSet r = createCategorie.getGeneratedKeys();
				r.next();
				return r.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -1;
	}
	
	
	
	public static boolean modifyCategorie(Categorie ca) {
		try {
			renewConnection();
			if (ca.getId() > 0){
				modifyCategorie.setString(1, ca.getTitre());
				modifyCategorie.setInt(2, ca.getId());
				if (modifyCategorie.executeUpdate() >= 1)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	
	public static boolean deleteQuestion(Categorie ca) {
		try {
			renewConnection();
			if (ca.getId() > 0) {
				deleteCategorie.setInt(1, ca.getId());
				if (deleteCategorie.executeUpdate() >= 1)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
