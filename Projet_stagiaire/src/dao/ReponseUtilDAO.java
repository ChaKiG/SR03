package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import beans.Questionnaire;
import beans.ReponseUtil;

public class ReponseUtilDAO {

	private static Connection c = null;
	private static PreparedStatement getReponseUtil = null;
	private static PreparedStatement createReponseUtil = null;
	private static PreparedStatement modifyReponseUtil = null;
	private static PreparedStatement deleteReponseUtil = null;
	
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getReponseUtil = c.prepareStatement("SELECT * FROM reponseUtil WHERE question_id = ?");
				createReponseUtil = c.prepareStatement("INSERT INTO reponseUtil( "
														+ "id, question_id, ordre, texte) "
														+ "VALUES(?,?,?,?) ");
				modifyReponseUtil = c.prepareStatement("UPDATE question SET "
														+ "questionnaire_id = ?, ordre = ?, texte = ? "
														+ "WHERE id = ? ");
				deleteReponseUtil = c.prepareStatement("DELETE FROM question WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		
	public static List<ReponseUtil> getReponsesUtil(Questionnaire q) {
		List<ReponseUtil> l = new ArrayList<ReponseUtil>();
		List<Question> lq = QuestionDAO.getQuestions(q);
		for (Question question : lq) {
			ReponseUtil r = getReponseUtil(question);
			if (r != null)
				l.add(r);
		}
		return l;
	}
	
	public static ReponseUtil getReponseUtil(Question q) {
		ReponseUtil r = null;
		try {
			renewConnection();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	
	public static boolean createReponse(ReponseUtil r) {
		//p, utilisateur_id, reponse_id);
		
		return true;
	}
	public static boolean modifyReponse(ReponseUtil r) {
		//p, utilisateur_id, reponse_id);
		
		return true;
	}
}