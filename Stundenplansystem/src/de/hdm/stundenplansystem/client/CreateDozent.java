package de.hdm.stundenplansystem.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;



import de.hdm.stundenplansystem.client.AService;
import de.hdm.stundenplansystem.client.AServiceAsync;
import de.hdm.stundenplansystem.shared.bo.Dozent;

public class CreateDozent extends Showcase {
	private final Button dozentAnlegen = new Button("Dozent anlegen");
	
	

	private final TextBox dozentVorname = new TextBox();
	private final TextBox dozentNachname = new TextBox();

	private final Label header = new Label();
	private final Label head_dozentanlegen = new Label();
	private final Label head_dozentverwalten = new Label();

	private final FlexTable dozententabelle = new FlexTable();

	private final HorizontalPanel oberesPanel = new HorizontalPanel();

	private final AServiceAsync ServiceObj = GWT.create(AService.class);
	private Dozent d;

	//void init(){
		
	//}
	
	void loadDozentList(){
		ServiceObj.getAllDozents(new AsyncCallback<ArrayList<Dozent>>() {
//ergebnis.get(i).getDozentID())
			@Override
			public void onSuccess(ArrayList<Dozent> ergebnis) {
				
				int firstRow = 1;
				for(int i = 0; i< ergebnis.size(); i++) {
					final Button deleteDozent = new Button("Loeschen");
														
					dozententabelle.setText(firstRow, 0, ergebnis.get(i).getVorname());
					dozententabelle.setText(firstRow, 1, ergebnis.get(i).getNachname());
					dozententabelle.setWidget(firstRow, 3, deleteDozent);
					firstRow++;
					final int dID = ergebnis.get(i).getDozentID();
					
					 deleteDozent.addClickHandler(new ClickHandler() {

						  public void onClick(ClickEvent event) {
							  ServiceObj.deleteDozent(dID,
										new AsyncCallback<Void>() {
											@Override
											public void onFailure(Throwable caught) {
												

											}

											@Override
											public void onSuccess(Void result) {
												Window.alert("Dozent erfolgreich geloescht");

											}
										});

						  }
						  });
					 
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("FAIL + sdsa");

			}
		});
	}
	
	public void onLoad() {
		dozentVorname.setText("Vorname");
		dozentNachname.setText("Nachname");
		header.setText("Dozentenverwaltung");

		head_dozentanlegen.setText("Dozent anlegen");
		head_dozentverwalten.setText("Dozent bearbeiten");

		header.setStylePrimaryName("h1");

		this.add(header);

		this.add(head_dozentanlegen);

		this.add(oberesPanel);
		oberesPanel.add(dozentVorname);
		oberesPanel.add(dozentNachname);
		oberesPanel.add(dozentAnlegen);

		this.add(head_dozentverwalten);
		this.add(dozententabelle);
		
		loadDozentList();
		
		dozententabelle.setText(0, 0, "Vorname");
		dozententabelle.setText(0, 1, "Nachname");
		dozententabelle.setText(0, 2, "Editieren");
		dozententabelle.setText(0, 3, "Loeschen");
		

		dozentAnlegen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// final String dVorname = dozentVorname.getText().trim();
				// final String dNachname = dozentNachname.getText().trim();
				/*
				 * if (!dVorname.matches("^[0-9A-Z\\.]{1,10}$")) {
				 * Window.alert("'" + dVorname + "' is not a valid symbol.");
				 * dozentVorname.selectAll(); return; }
				 */

				/*
				 * if (!dNachname.matches("^[0-9A-Z\\.]{1,10}$")) {
				 * Window.alert("'" + dNachname + "' is not a valid symbol.");
				 * dozentVorname.selectAll(); return; }
				 */

				// dozentVorname.setText("");
				// dozentNachname.setText("");

				d = new Dozent();
				d.setVorname(dozentVorname.getValue());
				d.setNachname(dozentNachname.getValue());

				ServiceObj.insertDozent(d, new AsyncCallback<Void>() {

					public void onSuccess(Void result) {
						Window.alert("Erfolgreich");
						loadDozentList();
					}

					public void onFailure(Throwable caught) {
						Window.alert("Fehlgeschlagen");
					}
					
					
					
					
					

				});
				//loadDozentList();
			}

		});
	}
}
