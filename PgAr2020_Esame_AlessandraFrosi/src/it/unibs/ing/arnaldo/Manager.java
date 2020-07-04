package it.unibs.ing.arnaldo;

import util.mylib.InputDati;
import util.mylib.MyMenu;

public class Manager {
	private MyMenu mainMenu;
	private Player player;
	private CollectionMaps maps;
	
	public Manager( Player player, CollectionMaps maps) {
		super();
		this.mainMenu = new MyMenu("Welcome to the archive of maps", new String[] {"Visualize the maps","Look for a map using the name and play"});
		this.player = player;
		this.maps = maps;
	}

	public void useMainMenu() {
		int choice = 0;
		do {
			choice = this.mainMenu.scegli();
			switch (choice) {
			case 1:
				this.maps.open();
				break;
			case 2:
				try {
					this.maps.open();
					MapManager m=new MapManager(this.maps.lookFor(InputDati.leggiStringaNonVuota("Enter the map name among the following maps")),this.player);
					m.check(); //start or check is the same method

				}catch(NullPointerException e) {
					System.out.println("Nothing found recheck the list");
				}
				
				break;
			}
		} while (choice != 0);
	}


}
