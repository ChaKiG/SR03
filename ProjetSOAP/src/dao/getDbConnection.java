package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class getDbConnection {
	static Connection connection = null;
	
	/* LOCAL DB */
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";   
	static final String DB_URL="jdbc:mysql://127.0.0.1:3306/projet_soap"; 
	static final String USER = "projet_soap"; 
	static final String PASS = "projet_soap";
	
	
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
