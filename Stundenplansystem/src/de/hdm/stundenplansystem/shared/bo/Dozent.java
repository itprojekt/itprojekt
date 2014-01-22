package de.hdm.stundenplansystem.shared.bo;

public class Dozent extends BusinessObject {
	private static final long serialVersionUID = 1L;
	
	private int dozID;
	private String vorname;
	private String nachname;
	
	public int getDozentID() {
		return dozID;
	}
	
	public void setDozentID(int dID) {
		dozID = dID;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String dVorname) {
		vorname = dVorname; 
		}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String dNachname) {
		nachname = dNachname;
	}
	

}
