package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Date;

import beans.Utilisateur;


public class UtilisateurDAO {
	private static Connection c = null;
	private static PreparedStatement checkUser = null;
	private static PreparedStatement createUser = null;
	private static PreparedStatement modifyUser = null;
	private static PreparedStatement deleteUser = null;
	
	
	
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				checkUser = c.prepareStatement("SELECT * FROM utilisateur WHERE mail = ?");
				createUser = c.prepareStatement("INSERT INTO utilisateur (mail, mot_de_passe, type_utilisateur, active, telephone, societe, creation) VALUES (?,?,?,?,?,?,?)");
				modifyUser = c.prepareStatement("SELECT * from utilisateur");
				deleteUser = c.prepareStatement("SELECT * from utilisateur");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Utilisateur getUtilisateur(String mail) {
		Utilisateur u = null;
		try {
			renewConnection();
			checkUser.setString(1, mail);
			ResultSet rs = checkUser.executeQuery();			
			if ( rs.next() ) {
				u = new Utilisateur();
				u.id = rs.getInt("id");
				u.mail = rs.getString("mail");
				u.mot_de_passe = rs.getString("mot_de_passe");
				u.type_utilisateur = rs.getInt("type_utilisateur");
				u.active = rs.getBoolean("active");
				u.telephone = rs.getString("telephone");
				u.societe = rs.getString("societe");
				u.creation = rs.getDate("creation");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return u;
	}
	
	public static Utilisateur createUtilisateur(String mail, String mot_de_passe, int type_utilisateur, boolean active, String telephone, String societe) {
		Utilisateur u = null;
		try {
			//(id, mail, mot_de_passe, type_utilisateur, active, telephone, societe, creation)
			renewConnection();
			createUser.setString(1, mail);
			createUser.setString(2, mot_de_passe);
			createUser.setInt(3, type_utilisateur);
			createUser.setBoolean(4, active);
			createUser.setString(5, telephone);
			createUser.setString(6, societe);
			java.util.Date dateUtil = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
			createUser.setDate(7, sqlDate);
			createUser.executeQuery();			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return u;
	}
	
	
	
	

}
