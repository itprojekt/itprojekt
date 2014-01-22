package de.hdm.stundenplansystem.server.db;

import java.sql.*;
import java.util.ArrayList;


import de.hdm.stundenplansystem.server.db.DBConnection;
import de.hdm.stundenplansystem.shared.bo.Dozent;

public class DozentMapper {
	
	private static DozentMapper dozentMapper = null;
	public Connection con = DBConnection.connection();
	
	protected DozentMapper() {
	}
	
	public static DozentMapper dozentMapper() {
		if (dozentMapper == null) {
			dozentMapper = new DozentMapper();
		}
		return dozentMapper;
	}
	//Dozenten anlegen
	public void insertDozent(Dozent d) {
		Connection con = DBConnection.connection();
		try {
			Statement state = con.createStatement();
			String sqlquery = "INSERT INTO dozent (vorname, nachname)VALUES ("
					+ "'"
					+ d.getVorname()
					+ "', '"
					+ d.getNachname() +
					"') ;";
			state.executeUpdate(sqlquery);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Dozenten auslesen
	public ArrayList<Dozent> getAllDozenten() {
		Connection con = DBConnection.connection();
		ArrayList<Dozent> resultList = new ArrayList<>();

		try {
			Statement state = con.createStatement();
			ResultSet ergebnis = state.executeQuery("SELECT * FROM dozent");

			while (ergebnis.next()) {
				Dozent d = new Dozent(); // Create new person-object to fill
											// with values from database
				d.setDozentID(ergebnis.getInt("DozentID"));
				d.setVorname(ergebnis.getString("Vorname"));
				d.setNachname(ergebnis.getString("Nachname"));
				resultList.add(d); // Add person-object to Arraylist
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultList;
	}
	
public void deleteDozent(int dID) {
	try {
		Statement state = this.con.createStatement();
							state.executeUpdate("DELETE FROM dozent WHERE DozentID="+dID+";");
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
	
	


