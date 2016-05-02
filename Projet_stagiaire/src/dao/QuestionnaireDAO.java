package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.Questionnaire;

public class QuestionnaireDAO {

	private static Connection c = null;
	private static PreparedStatement getQuestionnaires = null;
	private static PreparedStatement createQuestionnaire = null;
	private static PreparedStatement deleteQuestionnaire = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getQuestionnaires = c.prepareStatement("SELECT * FROM questionnaire");
				createQuestionnaire = c.prepareStatement("SELECT * from questionnaire");
				deleteQuestionnaire = c.prepareStatement("SELECT * from questionnaire");
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
				q.utilisateur_id = rs.getInt("utilisateur_id");
				q.nom = rs.getString("nom");
				q.sujet_id = rs.getInt("sujet_id");
				l.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	
}
