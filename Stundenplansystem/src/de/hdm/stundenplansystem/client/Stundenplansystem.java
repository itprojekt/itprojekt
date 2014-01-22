package de.hdm.stundenplansystem.client;

import de.hdm.stundenplansystem.client.CreateDozent;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Stundenplansystem implements EntryPoint {
	
	final VerticalPanel contentPanel = new VerticalPanel();
	final MenuBar menuWidget = new MenuBar();
	
	public void onModuleLoad() {
		// Make a command that we will execute from all leaves.

		Command dozentenverwaltung = new Command() {
			public void execute() {
				CreateDozent neuerDozent = new CreateDozent();
				RootPanel.get("content_wrap").clear();
				RootPanel.get("content_wrap").add(neuerDozent);
				
			}
		};

		Command lvverwaltung = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		Command zeitslotverwaltung = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		Command raumverwaltung = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		Command smvverwaltung = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		Command raumbuchen = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		Command dozentenplan = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		Command raumplan = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		Command smvplan = new Command() {
			public void execute() {
				Window.alert("blubbfisch");
			}
		};

		// Make some sub-menus that we will cascade from the top menu.
		MenuBar verwaltungMenu = new MenuBar(true);
		verwaltungMenu.addItem("Dozent", dozentenverwaltung);
		verwaltungMenu.addItem("Lehrveranstaltung", lvverwaltung);
		verwaltungMenu.addItem("Zeitslot", zeitslotverwaltung);
		verwaltungMenu.addItem("Raum", raumverwaltung);
		verwaltungMenu.addItem("Semesterverband", smvverwaltung);

		MenuBar raumbuchungsMenu = new MenuBar(true);
		raumbuchungsMenu.addItem("Raumbuchung", raumbuchen);

		MenuBar reportingMenu = new MenuBar(true);
		reportingMenu.addItem("Dozentenplan", dozentenplan);
		reportingMenu.addItem("Raumplan", raumplan);
		reportingMenu.addItem("Semesterverbandplan", smvplan);

		// Make a new menu bar, adding a few cascading menus to it.
		MenuBar menu = new MenuBar();
		menu.addItem("Verwaltung", verwaltungMenu);
		menu.addItem("Raumbuchung", raumbuchungsMenu);
		menu.addItem("Report", reportingMenu);

		// Add it to the root panel.

		RootPanel.get("menu").add(menu);
	}

}
