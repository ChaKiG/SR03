package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import beans.Questionnaire;

public class QuestionDAO {

	private static Connection c = null;
	private static PreparedStatement getQuestions = null;
	private static PreparedStatement createQuestion = null;
	private static PreparedStatement modifyQuestion = null;
	private static PreparedStatement deleteQuestion = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getQuestions = c.prepareStatement("SELECT * FROM question WHERE questionnaire_id = ?");
				createQuestion = c.prepareStatement("INSERT INTO question( "
														+ "id, questionnaire_id, ordre, texte) "
														+ "VALUES(?,?,?,?) ");
				deleteQuestion = c.prepareStatement("UPDATE question SET "
														+ "questionnaire_id = ?, ordre = ?, texte = ? "
														+ "WHERE id = ? ");
				deleteQuestion = c.prepareStatement("DELETE FROM question WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Question> getQuestions(Questionnaire q) {
		List<Question> l = new ArrayList<Question>();
		try {
			renewConnection();
			getQuestions.setInt(1, q.id);
			ResultSet rs = getQuestions.executeQuery();			
			while ( rs.next() ) {
				Question qu = new Question();
				qu.id = rs.getInt("id");
				qu.questionnaire_id = rs.getInt("questionnaire_id");
				qu.ordre = rs.getInt("ordre");
				qu.texte = rs.getString("texte");
				l.add(qu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	
	
	public static boolean createQuestion(Question q) {
		try {
			renewConnection();
			if (q.id != null && q.id > 0)
				createQuestion.setInt(1, q.id);
			else
				createQuestion.setNull(1, java.sql.Types.INTEGER);
			createQuestion.setInt(2, q.questionnaire_id);
			createQuestion.setInt(3, q.ordre);
			createQuestion.setString(4, q.texte);
			if (createQuestion.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	
	public static boolean modifyQuestion(Question q) {
		try {
			renewConnection();
			if (q.id != null && q.id > 0){
				modifyQuestion.setInt(1, q.id);
				modifyQuestion.setInt(2, q.questionnaire_id);
				modifyQuestion.setInt(3, q.ordre);
				modifyQuestion.setString(4, q.texte);
				if (modifyQuestion.executeUpdate() >= 1)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	
	public static boolean deleteQuestion(Question q) {
		try {
			renewConnection();
			if (q.id != null && q.id > 0) {
				deleteQuestion.setInt(1, q.id);
				if (deleteQuestion.executeUpdate() >= 1)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
