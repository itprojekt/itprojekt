package de.hdm.stundenplansystem.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;


import de.hdm.stundenplansystem.shared.bo.*;

public interface AServiceAsync {

	void insertDozent(Dozent d, AsyncCallback<Void> callback);


	
	void getAllDozents(AsyncCallback<ArrayList<Dozent>> callback)
			throws IllegalArgumentException;



	void deleteDozent(int dID, AsyncCallback<Void> callback) throws IllegalArgumentException;

}
