package de.hdm.stundenplansystem.client;


import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.stundenplansystem.shared.bo.*;



@RemoteServiceRelativePath("asyncservice")

public interface AService extends RemoteService {
	
	
	void insertDozent(Dozent d);
	void updateDozent(Dozent d);

	ArrayList<Dozent> getAllDozents() throws IllegalArgumentException;

	void deleteDozent(int dID) throws IllegalArgumentException;

	
	
	
}
