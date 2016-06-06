package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import beans.Adresse;

public class AdresseDAO {

	private static Connection c = null;
	private static PreparedStatement getAdresse = null;
	private static PreparedStatement createAdresse = null;
	private static PreparedStatement modifyAdresse = null;
	private static PreparedStatement deleteAdresse = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					DBConnection.closeConnection();
				c = DBConnection.getConnection();
				getAdresse = c.prepareStatement("SELECT * FROM adresse WHERE id = ?");
				createAdresse = c.prepareStatement("INSERT INTO adresse( "
														+ "id, numero,rue,ville,cp) "
														+ "VALUES(?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
				modifyAdresse = c.prepareStatement("UPDATE adresse SET "
														+ "numero = ?, rue = ?, ville = ?, cp = ?"
														+ "WHERE id = ? ");
				deleteAdresse = c.prepareStatement("DELETE FROM adresse WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Adresse getAdresse(int id) {
		Adresse a = null;
		try {
			renewConnection();
			getAdresse.setInt(1, id);
			ResultSet rs = getAdresse.executeQuery();			
			if ( rs.next() ) {
				a = new Adresse();
				a.setId( rs.getInt("id"));
				a.setNumero( rs.getInt("numero"));
				a.setRue(rs.getString("rue"));
				a.setVille(rs.getString("ville"));
				a.setCp(rs.getInt("cp"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return a;
	}
	
	public static int createAdresse(Adresse a) {
		try {
			renewConnection();
			if (a.getId() > 0)
				createAdresse.setInt(1, a.getId());
			else
				createAdresse.setNull(1, java.sql.Types.INTEGER);
			createAdresse.setInt(2, a.getNumero());
			createAdresse.setString(3, a.getRue());
			createAdresse.setString(4, a.getVille());
			createAdresse.setInt(5, a.getCp());
			if (createAdresse.executeUpdate() >= 1) {
				ResultSet r = createAdresse.getGeneratedKeys();
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
