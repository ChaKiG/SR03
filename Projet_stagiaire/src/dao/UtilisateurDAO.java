package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import beans.Utilisateur;


public class UtilisateurDAO {
	private static Connection c = null;

	private static PreparedStatement getUserById = null;
	private static PreparedStatement getUserByMail = null;
	private static PreparedStatement createUser = null;
	private static PreparedStatement modifyUser = null;
	//private static PreparedStatement deleteUser = null;

		
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getUserById = c.prepareStatement("SELECT * FROM utilisateur WHERE id = ?");
				getUserByMail = c.prepareStatement("SELECT * FROM utilisateur WHERE mail = ?");
				createUser = c.prepareStatement("INSERT INTO utilisateur(id, mail, mot_de_passe, type_utilisateur, active, telephone, societe, creation) VALUES(?,?,?,?,?,?,?,?)");
				modifyUser = c.prepareStatement("UPDATE utilisateur SET "
						+ "mail = ?, "
						+ "mot_de_passe = ?, "
						+ "telephone = ?, "
						+ "societe = ? "
						+ "WHERE id = ?");
				//deleteUser = c.prepareStatement("SELECT * from utilisateur");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Utilisateur getUtilisateur(String mail) {
		Utilisateur u = null;
		try {
			renewConnection();
			getUserByMail.setString(1, mail);
			ResultSet rs = getUserByMail.executeQuery();			
			if ( rs.next() ) {
				u = new Utilisateur();
				u.id = rs.getInt("id");
				u.mail = rs.getString("mail");
				u.mot_de_passe = rs.getString("mot_de_passe");
				u.type_utilisateur = rs.getInt("type_utilisateur");
				u.active = rs.getInt("active");
				u.telephone = rs.getString("telephone");
				u.societe = rs.getString("societe");
				u.creation = rs.getDate("creation");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return u;
	}
	public static Utilisateur getUtilisateur(int id) {
		Utilisateur u = null;
		try {
			renewConnection();
			getUserById.setInt(1, id);
			ResultSet rs = getUserById.executeQuery();			
			if ( rs.next() ) {
				u = new Utilisateur();
				u.id = rs.getInt("id");
				u.mail = rs.getString("mail");
				u.mot_de_passe = rs.getString("mot_de_passe");
				u.type_utilisateur = rs.getInt("type_utilisateur");
				u.active = rs.getInt("active");
				u.telephone = rs.getString("telephone");
				u.societe = rs.getString("societe");
				u.creation = rs.getDate("creation");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return u;
	}

	public static boolean createUser(Utilisateur u) {
		System.out.println(u.mail);
		System.out.println(u.mot_de_passe);
		System.out.println(u.societe);
		System.out.println(u.telephone);
		System.out.println(u.type_utilisateur);
		System.out.println(u.active);
		System.out.println(u.creation.toString());
		if ( u == null ||
				u.mail == null ||
				u.mail.equals("") ||
				u.mot_de_passe == null ||
				u.mot_de_passe.equals("") ||
				u.societe == null ||
				u.societe.equals("") ||
				u.telephone == null ||
				u.telephone.equals("") ||
				u.type_utilisateur < 0 ||
				u.active < 0)
			return false;
		try {
			renewConnection();
			if (u.id != null && u.id > 0)
				createUser.setInt(1, u.id);
			else
				createUser.setNull(1, java.sql.Types.INTEGER);
			createUser.setString(2, u.mail);
			createUser.setString(3, u.mot_de_passe);
			createUser.setInt(4, u.type_utilisateur);
			createUser.setInt(5, u.active);
			createUser.setString(6, u.telephone);
			createUser.setString(7, u.societe);
			createUser.setDate(8, new java.sql.Date(u.creation.getTime()));
			if (createUser.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	
	
	
	public static boolean modifyUser(Utilisateur u) {
		try {
			renewConnection();
			modifyUser.setString(1, u.mail);
			modifyUser.setString(2, u.mot_de_passe);
			modifyUser.setString(3, u.telephone);
			modifyUser.setString(4, u.societe);
			modifyUser.setInt(5, u.id);
			if (modifyUser.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	
}
