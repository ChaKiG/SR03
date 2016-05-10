package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import beans.Reponse;

public class ReponseDAO {
	private static Connection c = null;
	private static PreparedStatement getReponses = null;
	private static PreparedStatement addReponse = null;
	private static PreparedStatement deleteReponse = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getReponses = c.prepareStatement("SELECT * FROM reponse WHERE question_id = ?");
				addReponse = c.prepareStatement("INSERT INTO reponse(id, question_id, ordre, texte)"
												+ "VALUES( ?, ?, ?, ?)");
				deleteReponse = c.prepareStatement("DELETE FROM reponse WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Reponse> getReponses(Question q) {
		List<Reponse> l = new ArrayList<Reponse>();
		try {
			renewConnection();
			if (q.id != null && q.id > 0) {
				getReponses.setInt(1, q.id);
				ResultSet rs = getReponses.executeQuery();			
				while ( rs.next() ) {
					Reponse r = new Reponse();
					r.id = rs.getInt("id");
					r.question = QuestionDAO.getQuestion(rs.getInt("question_id"));
					r.ordre = rs.getInt("ordre");
					r.texte = rs.getString("texte");
					l.add(r);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	
	
	public static boolean createReponse(Reponse r) {
		try {
			renewConnection();
			if (r.id != null && r.id > 0)
				addReponse.setInt(1, r.id);
			else
				addReponse.setNull(1, java.sql.Types.INTEGER);
			addReponse.setInt(2, r.question.id);
			addReponse.setInt(3, r.ordre);
			addReponse.setString(4, r.texte);
			if (addReponse.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	
	
	public static boolean deleteReponse(Reponse r) {
		try {
			renewConnection();
			if (r.id != null && r.id > 0) {
				deleteReponse.setInt(1, r.id);
				if (deleteReponse.executeUpdate() >= 1) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
