package it.unibs.ing.arnaldo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import util.mylib.MyMenu;
/**
 * <b>Class</B> <br>
 * the general map where the player can play <br>
 * @author alessandra frosi
 *
 */
public class Map {
	/**
	 * <b>Attribute</B> <br>
	 * using a map to speed the procedure
	 */
	private HashMap<Integer, Cell> cells;
	private int size;
	private String nameMap;
	
	public Map() {
		super();
	}
	public Map(HashMap<Integer, Cell> cells, int size, String nameMap) {
		super();
		this.cells = cells;
		this.size = size;
		this.nameMap = nameMap;
	}

	public HashMap<Integer, Cell> getCells() {
		return cells;
	}

	public int getSize() {
		return size;
	}

	public String getNameMap() {
		return nameMap;
	}
	
	public ArrayList<Station> getStationes(){
		ArrayList<Station> stations=new ArrayList<Station>();
		Iterator<Entry<Integer, Cell>> it = this.cells.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry<Integer, Cell> pair = (HashMap.Entry<Integer, Cell>) it.next();
			if (pair.getValue().getClass().isInstance(Station.class)) {
				stations.add((Station) pair.getValue());
			}

		}
		return stations;
	}

	/**
	 * 
	 * using iterator it will look for a specific cell
	 * 
	 * @param the position alias the id
	 * @return the specific cell
	 */
	public Cell getCellsUsingPosition(int p) {
		Iterator<Entry<Integer, Cell>> it = this.cells.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry<Integer, Cell> pair = (HashMap.Entry<Integer, Cell>) it.next();
			if (pair.getKey().equals(p)) {
				return pair.getValue();
			}

		}
		//never happen
		return null;
	}
	
	@Override
	public String toString() {
		return "The " +this.nameMap +"map contains  " +this.size +"cells";
	}
	
	public int lookFor(String name) throws NullPointerException {
		Iterator<Entry<Integer, Cell>> it = this.cells.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry<Integer, Cell> pair = (HashMap.Entry<Integer, Cell>) it.next();
			if (pair.getValue().getName().contentEquals(name)) {
				return pair.getKey();
			}

		}
		//can happen
		return 0;
		
	}
	

}
