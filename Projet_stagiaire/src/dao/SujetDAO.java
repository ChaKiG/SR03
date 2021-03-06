package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.Sujet;

public class SujetDAO {

	private static Connection c = null;
	private static PreparedStatement getSujets = null;
	private static PreparedStatement getSujetId = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getSujets = c.prepareStatement("SELECT * FROM sujet");
				getSujetId = c.prepareStatement("SELECT * FROM sujet WHERE id = ?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Sujet> getSujets() {
		List<Sujet> l = new ArrayList<Sujet>();
		
		try {
			renewConnection();
			ResultSet rs = getSujets.executeQuery();			
			while ( rs.next() ) {
				Sujet s = new Sujet();
				s.id = rs.getInt("id");
				s.nom = rs.getString("nom");
				l.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return l;
	}
	
	
	public static Sujet getSujet(int id) {
		Sujet s = null;
		try {
			renewConnection();
			getSujetId.setInt(1, id);
			ResultSet rs = getSujetId.executeQuery();			
			if ( rs.next() ) {
				s = new Sujet();
				s.id = rs.getInt("id");
				s.nom = rs.getString("nom");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return s;
	}
	
}
