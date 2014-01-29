package de.hdm.stundenplansystem.server.db;

import java.sql.*;
import com.google.appengine.api.rdbms.AppEngineDriver;

/**
 * Database-connection-mapper
 * 
 * @author R. Brixel, M. Stumpp, D. Evcenko, S. Ziemann, M. Mehlhorn, T. Glück
 * @version 1.0
 * @date 2013-05-29
 */
public class DBConnection {
	
	private static Connection con = null;
	//private static String url = "jdbc:google:rdbms://prof-thies.de:thies-bankproject:thies-bankproject/bankproject?user=demo&password=demo";
	
	/**
	 * Handles the database-connections for the GWT-Framework
	 * @return The database-connection object
	 */
	public static Connection connection() {
		if (con == null) { // If on init no connection established, create one
			try {
				
				DriverManager.registerDriver(new AppEngineDriver()); // Create driver from GWT-Package
				
				con = DriverManager.getConnection("jdbc:mysql://feltrin-immobilien.de:3306/itprojekt", "itprojekt", "itprojekt123");
				//con = DriverManager.getConnection("jdbc:google:rdbms://hdm1337:hdmsql/hotelverwaltung", "root", ""); // Create connection with user-credentials
			} 
			catch (SQLException e1) { // If an exception appears, ...
				con = null; // Leave "con" null
			
				e1.printStackTrace();
			}
		}

		return con; // If connection was created successfully, return the database-connection
	}
	
}
