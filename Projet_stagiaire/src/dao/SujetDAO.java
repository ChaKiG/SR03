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
	private static PreparedStatement createSujet = null;
	private static PreparedStatement deleteSujet = null;
	
	private static void renewConnection() {
		try {
			if (c == null || !c.isValid(2)) {
				if (c != null)
					getDbConnection.closeConnection();
				c = getDbConnection.getConnection();
				getSujets = c.prepareStatement("SELECT * FROM sujet");
				createSujet = c.prepareStatement("SELECT * from sujet");
				deleteSujet = c.prepareStatement("SELECT * from sujet");
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
	
}
