package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class getDbConnection {
	static Connection connection = null;
	
	/* LOCAL DB */
	/*static final String JDBC_DRIVER="com.mysql.jdbc.Driver";   
	static final String DB_URL="jdbc:mysql://127.0.0.1:3306/sr03p013"; 
	static final String USER = "projet_stagiaire"; 
	static final String PASS = "projet_stagiaire"; 
<<<<<<< HEAD
	
	/* UTC DB */
	/*static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	static final String DB_URL="jdbc:mysql://tuxa.sme.utc/sr03p013";
	static final String USER = "sr03p013";
	static final String PASS = "9kHfnmSW";
	*/
=======
	static Connection connection = null;*/
	
	/* UTC DB */
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	static final String DB_URL="jdbc:mysql://tuxa.sme.utc/sr03p013";
	static final String USER = "sr03p013";
	static final String PASS = "9kHfnmSW";
	static Connection connection = null;
	
>>>>>>> master
	

	public static Connection getConnection() {
		if (connection != null) {
			try {
				if (connection.isValid(2)) {
					return connection;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
			connection = null;
		}
		return connection;
	}
	
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}

	
	
}
