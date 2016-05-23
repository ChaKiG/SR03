package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Parcours;
import beans.ReponseUtil;

public class ReponseUtilDAO {

	private static Connection c = null;
	private static PreparedStatement getReponseUtil = null;
	private static PreparedStatement getReponsesUtil = null;
	private static PreparedStatement createReponseUtil = null;
	private static PreparedStatement deleteReponsesUtil = null;
	
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getReponsesUtil = c.prepareStatement("SELECT * FROM reponse_util WHERE parcours_id = ?");
				getReponseUtil = c.prepareStatement("SELECT * FROM reponse_util WHERE id = ?");
				createReponseUtil = c.prepareStatement("INSERT INTO reponse_util( "
														+ "id, parcours_id, reponse_id) "
														+ "VALUES(?,?,?) ");
				deleteReponsesUtil = c.prepareStatement("DELETE FROM reponse_util WHERE parcours_id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		
	public static List<ReponseUtil> getReponsesUtil(Parcours p) {
		List<ReponseUtil> l = new ArrayList<ReponseUtil>();
		try {
			renewConnection();
			getReponsesUtil.setInt(1, p.id);
			ResultSet rs = getReponsesUtil.executeQuery();
			while (rs.next()) {
				ReponseUtil r = new ReponseUtil();
				r.id = rs.getInt("id");
				r.parcours = ParcoursDAO.getParcours(rs.getInt("parcours_id"));
				r.reponse = ReponseDAO.getReponse(rs.getInt("reponse_id"));
				l.add(r);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	public static ReponseUtil getReponseUtil(int reponseUtil_id) {
		ReponseUtil r = null;
		try {
			renewConnection();
			getReponseUtil.setInt(1, reponseUtil_id);
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

	
	
	
	public static boolean deleteReponseUtil(int parcours_id) {
		try {
			renewConnection();
			deleteReponsesUtil.setInt(1, parcours_id);
			if (deleteReponsesUtil.executeUpdate() >= 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
}