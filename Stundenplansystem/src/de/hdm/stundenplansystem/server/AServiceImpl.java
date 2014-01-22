package de.hdm.stundenplansystem.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;



import de.hdm.stundenplansystem.client.AService;
import de.hdm.stundenplansystem.server.db.*;
import de.hdm.stundenplansystem.shared.bo.*;

public class AServiceImpl extends RemoteServiceServlet implements AService {

	private static final long serialVersionUID = 1L;
	private DozentMapper dMapper = null;

	/**
	 * Initialize all database-mapper and extends service-servlet
	 */
	public void init() throws IllegalArgumentException {
		this.dMapper = DozentMapper.dozentMapper();

	}

	// ##################################################################################################
	// GET
	// ##################################################################################################

	@Override
	public void insertDozent(Dozent d) {
		init(); 
		dMapper.insertDozent(d);
	}

	@Override
	public ArrayList<Dozent> getAllDozents() throws IllegalArgumentException {
		init(); // Initialize all mappers
		ArrayList<Dozent> listit = dMapper.getAllDozenten();
		if (!listit.isEmpty()) {
			return listit;
		} else {
			return null;
		}
	}


public void deleteDozent(int dID) {
	init(); 
	dMapper.deleteDozent(dID);
}
}
