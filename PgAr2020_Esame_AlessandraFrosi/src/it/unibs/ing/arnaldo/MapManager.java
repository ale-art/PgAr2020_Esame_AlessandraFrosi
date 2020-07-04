package it.unibs.ing.arnaldo;

import java.util.ArrayList;

import util.mylib.InputDati;
import util.mylib.MyMenu;

/**
 * <b>Method</B> <br>
 * 
 * I splitted the two mangers this one will handle a single map chosen by the
 * player at the beginning of the okay
 * 
 * @author alessandra Frosi
 *
 */
public class MapManager {

	private Map map;
	private Player player;
	private MyMenu mainMenu;

	/**
	 * <b>Constructor</B> <br>
	 * 
	 * @param map
	 * @param player
	 */
	public MapManager(Map map, Player player) {
		super();
		this.map = map;
		this.player = player;
		this.mainMenu = new MyMenu("Welcome to UnyPoly,let's play", new String[] { "Throw the cube" });
	}

	/**
	 * <b>Method</B> <br>
	 * using the main menu with basic function
	 * 
	 */
	public void useMenu() {
		int choice = 0;
		do {
			choice = this.mainMenu.scegli();
			switch (choice) {
			case 1:
				this.player.throwYourCube(this.map.getSize());
				this.move();
				this.check();
				break;
			case 2:
				System.out.println(this.player.getPosition());
			case 3:
				System.out.println(this.player.getMoney());
				break;
			}
		} while (choice != 0);
	}

	public void move() {
		
		Cell c = this.map.getCellsUsingPosition(this.player.getPosition());
		if (c instanceof StartingPoint) {
			// nothing here
			this.manageStartingPoint((StartingPoint) c);
		}
		if (c instanceof Accident) {
			// lose money
			this.manageAccident((Accident) c);

		}
		if (c instanceof Probability) {
			// earn money
			this.manageProbability((Probability) c);
		}
		if (c instanceof Station) {
			// move to another station
			this.manageStation((Station) c);
		}
	}

	public void manageStation(Station s) {
		ArrayList<Station> stations = new ArrayList<Station>();
		stations.addAll(this.map.getStationes());
		stations.remove(s);
		for (Station t : stations) {
			System.out.println(t.getName());
		}
		String name = InputDati.leggiStringaNonVuota("Enter the name of one of the previous station");
		int newPosition = this.map.lookFor(name);
		do {
			if (newPosition != 0) {
				player.calculateNewPosition(newPosition,this.map.getSize());
			} else {
				System.out.println("You type a wrong name");
			}
		} while (newPosition != 0);

	}

	public void manageStartingPoint(StartingPoint c) {
		System.out.println("You are on the Starting Point, go on!");
	}

	public void manageAccident(Accident c) {
		System.out.println("Ops, you are on a Accident Cell");
		System.out.println(c.getMessage());
		this.player.loseMoney(c.getMoneyLost());

	}

	public void manageProbability(Probability c) {
		System.out.println("Great, you are on a Probability Cell");
		System.out.println(c.getMessage());
		System.out.println(c.getEarnedMoney());
	}

	/**
	 * <b>Method</b> <br>
	 * starting a new play and constantly checking the status of the
	 * player <br>
	 */
	public void check() {
		if (this.player.hasLost() || this.player.hasWin()) {
			this.declareWinnerOrLoser();
		} else {
			this.useMenu();
		}
	}

	private void declareWinnerOrLoser() {
		if (this.player.hasLost()) {
			System.out.println("You Lost");
		} else {
			System.out.println("You win");
		}

	}
}
