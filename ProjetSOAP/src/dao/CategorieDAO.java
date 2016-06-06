package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Categorie;



public class CategorieDAO {
	private static Connection c = null;
	private static PreparedStatement addCategorie = null;
	private static PreparedStatement getCategorie = null;
	private static PreparedStatement getCategories = null;
	private static PreparedStatement delCategorie = null;
	
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				addCategorie = c.prepareStatement("INSERT INTO categorie(id, nom) VALUES(?,?)");
				getCategorie = c.prepareStatement("SELECT * FROM categorie WHERE id = ?");
				getCategories = c.prepareStatement("SELECT * FROM categorie");
				delCategorie = c.prepareStatement("DELETE FROM categorie WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int addCategorie(Categorie c) {
		try {
			renewConnection();
			if (c.id > 0)
				addCategorie.setInt(1, c.id);
			else
				addCategorie.setNull(1, java.sql.Types.INTEGER);
			addCategorie.setString(2, c.nom);
			if ( addCategorie.executeUpdate() >= 1) {
				return addCategorie.getGeneratedKeys().getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -1;
	}
	
	
	public static List<Categorie> getCategories() {
		List<Categorie> l = new ArrayList<Categorie>();
		try {
			renewConnection();
			ResultSet rs = getCategories.executeQuery();			
			while ( rs.next() ) {
				Categorie c = new Categorie();
				c.id = rs.getInt("id");
				c.nom = rs.getString("nom");
				l.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	public static Categorie getCategorie(int categorie_id) {
		Categorie c = null;
		try {
			renewConnection();
			getCategorie.setInt(1, categorie_id);
			ResultSet rs = getCategorie.executeQuery();			
			if ( rs.next() ) {
				c = new Categorie();
				c.id = rs.getInt("id");
				c.nom = rs.getString("nom");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return c;
	}
	
	public static boolean delCategorie(int categorie_id) {
		try {
			renewConnection();
			delCategorie.setInt(1, categorie_id);
			if ( delCategorie.executeUpdate() >= 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
}