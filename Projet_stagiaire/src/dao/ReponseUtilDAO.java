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
	private static PreparedStatement deleteReponseUtil = null;
	
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getReponseUtil = c.prepareStatement("SELECT * FROM reponseUtil WHERE question_id = ?");
				createReponseUtil = c.prepareStatement("INSERT INTO reponseUtil( "
														+ "id, parcours, reponse) "
														+ "VALUES(?,?,?) ");
				deleteReponseUtil = c.prepareStatement("DELETE FROM reponseUtil WHERE id = ?");
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
			getReponseUtil.setInt(1, q.id);
			ResultSet rs = getReponseUtil.executeQuery();
			if (rs.next()) {
				r = new ReponseUtil();
				r.id = rs.getInt("id");
				r.parcours = ParcoursDAO.getParcours(rs.getInt("parcours"));
				r.reponse = ReponseDAO.getReponse(rs.getInt("reponse"));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	
	public static boolean createReponseUtil(ReponseUtil r) {
		if (r == null)
			return false;
		try {
			renewConnection();
			if (r.id > 0)
				createReponseUtil.setInt(1, r.id);
			else
				createReponseUtil.setNull(1, java.sql.Types.INTEGER);
			createReponseUtil.setInt(2, r.parcours.id);
			createReponseUtil.setInt(3, r.reponse.id);
			if (createReponseUtil.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	
	public static boolean createReponseUtil(int parcours_id, int reponse_id) {
		try {
			renewConnection();
			createReponseUtil.setNull(1, java.sql.Types.INTEGER);
			createReponseUtil.setInt(2, parcours_id);
			createReponseUtil.setInt(3, reponse_id);
			if (createReponseUtil.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	
	
	
	public static boolean deleteReponseUtil(ReponseUtil r) {
		if (r == null || r.id <=0)
			return false;
		try {
			renewConnection();
			deleteReponseUtil.setInt(1, r.id);
			if (createReponseUtil.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
}