package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import beans.Questionnaire;
import beans.Sujet;
import beans.Utilisateur;

public class QuestionnaireDAO {

	private static Connection c = null;
	private static PreparedStatement getQuestionnaires = null;
	private static PreparedStatement getQuestionnaire = null;
	private static PreparedStatement createQuestionnaire = null;
	private static PreparedStatement deleteQuestionnaire = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getQuestionnaires = c.prepareStatement("SELECT * FROM questionnaire");
				getQuestionnaire = c.prepareStatement("SELECT * FROM questionnaire WHERE id = ?");
				createQuestionnaire = c.prepareStatement("INSERT INTO questionnaire("
														+ "id, utilisateur_id, nom, sujet_id)"
														+ "VALUES(?,?,?,?)");
				deleteQuestionnaire = c.prepareStatement("DELETE FROM questionnaire WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Questionnaire> getQuestionnaires() {
		List<Questionnaire> l = new ArrayList<Questionnaire>();
		try {
			renewConnection();
			ResultSet rs = getQuestionnaires.executeQuery();			
			while ( rs.next() ) {
				Questionnaire q = new Questionnaire();
				q.id = rs.getInt("id");
				q.nom = rs.getString("nom");
				q.utilisateur = UtilisateurDAO.getUtilisateur(rs.getInt("utilisateur_id"));
				q.sujet = SujetDAO.getSujet(rs.getInt("sujet_id"));
				l.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	
	public static Questionnaire getQuestionnaire(int id) {
		Questionnaire q = null;
		try {
			renewConnection();
			getQuestionnaire.setInt(1,  id);
			ResultSet rs = getQuestionnaire.executeQuery();			
			if ( rs.next() ) {
				q = new Questionnaire();
				q.id = rs.getInt("id");
				q.nom = rs.getString("nom");
				q.utilisateur = UtilisateurDAO.getUtilisateur(rs.getInt("utilisateur_id"));
				q.sujet = SujetDAO.getSujet(rs.getInt("sujet_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return q;
	}
	
	
	
	
	public static boolean createQuestionnaire(Questionnaire q) {
		try {
			renewConnection();
			if (q.id != null && q.id > 0)
				createQuestionnaire.setInt(1, q.id);
			else
				createQuestionnaire.setNull(1, java.sql.Types.INTEGER);
			createQuestionnaire.setInt(2, q.utilisateur.id);
			createQuestionnaire.setString(3, q.nom);
			createQuestionnaire.setInt(4, q.sujet.id);
			if (createQuestionnaire.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	
	
	public static boolean deleteQuestionnaire(Questionnaire q) {
		try {
			renewConnection();
			if (q.id != null && q.id > 0) {
				List<Question> l = QuestionDAO.getQuestions(q);
				for (Question qu : l) {
					QuestionDAO.deleteQuestion(qu);
				}
				deleteQuestionnaire.setInt(1, q.id);
				if (deleteQuestionnaire.executeUpdate() >= 1) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
