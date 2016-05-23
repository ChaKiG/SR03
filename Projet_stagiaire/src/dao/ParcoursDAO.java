package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.Parcours;

public class ParcoursDAO {

	private static Connection c = null;
	private static PreparedStatement getParcours = null;
	private static PreparedStatement getParcours2 = null;
	private static PreparedStatement createParcours = null;
	private static PreparedStatement updateParcours = null;
	private static PreparedStatement deleteParcours = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getParcours = c.prepareStatement("SELECT * FROM parcours WHERE id = ?");
				getParcours2 = c.prepareStatement("SELECT * FROM parcours WHERE questionnaire_id = ? AND utilisateur_id = ? ");
				createParcours = c.prepareStatement("INSERT INTO parcours( "
													+ "id, questionnaire_id, utilisateur_id, score, duree) "
													+ "VALUES(?,?,?,?,?) ");
				updateParcours = c.prepareStatement("UPDATE parcours SET "
													+ "score = ?, duree = ? "
													+ "WHERE id = ? ");
				deleteParcours = c.prepareStatement("DELETE FROM parcours WHERE questionnaire_id = ? AND utilisateur_id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Parcours getParcours(int parcours_id) {
		Parcours p = null;
		try {
			renewConnection();
			getParcours.setInt(1, parcours_id);
			ResultSet rs = getParcours.executeQuery();			
			if ( rs.next() ) {
				p = new Parcours();
				p.id = rs.getInt("id");
				p.questionnaire = QuestionnaireDAO.getQuestionnaire(rs.getInt("questionnaire_id"));
				p.utilisateur = UtilisateurDAO.getUtilisateur(rs.getInt("utilisateur_id"));
				p.score = rs.getInt("score");
				p.duree = rs.getTime("duree");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return p;
	}
	public static Parcours getParcours(int questionnaire_id, int utilisateur_id) {
		Parcours p = null;
		try {
			renewConnection();
			getParcours2.setInt(1, questionnaire_id);
			getParcours2.setInt(2, utilisateur_id);
			ResultSet rs = getParcours2.executeQuery();			
			if ( rs.next() ) {
				p = new Parcours();
				p.id = rs.getInt("id");
				p.questionnaire = QuestionnaireDAO.getQuestionnaire(rs.getInt("questionnaire_id"));
				p.utilisateur = UtilisateurDAO.getUtilisateur(rs.getInt("utilisateur_id"));
				p.score = rs.getInt("score");
				p.duree = rs.getTime("duree");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return p;
	}
	
	
	
	public static boolean createParcours(Parcours p) {
		try {
			renewConnection();
			if (p.id != null && p.id > 0)
				createParcours.setInt(1, p.id);
			else
				createParcours.setNull(1, java.sql.Types.INTEGER);
			createParcours.setInt(2, p.questionnaire.id);
			createParcours.setInt(3, p.utilisateur.id);
			createParcours.setInt(4, p.score);
			createParcours.setTime(5, p.duree);
			if (createParcours.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	
	public static boolean updateParcours(Parcours p) {
		try {
			renewConnection();
			updateParcours.setInt(1, p.score);
			updateParcours.setTime(2, p.duree);
			updateParcours.setInt(3, p.id);
			if (updateParcours.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	public static boolean deleteParcours(int questionnaire_id, int utilisateur_id) {
		try {
			renewConnection();
			deleteParcours.setInt(1, questionnaire_id);
			deleteParcours.setInt(2, utilisateur_id);
			if (deleteParcours.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

}
