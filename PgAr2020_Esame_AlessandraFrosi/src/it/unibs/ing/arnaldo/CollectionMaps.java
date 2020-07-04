package it.unibs.ing.arnaldo;

import java.util.ArrayList;


/**
 * <b>Class</B> <br>
 * a collection of all the different maps this class stands for a general
 * archive where you can look for a specific {@code Map}
 * 
 * @author Alessandra Frosi
 *
 */
public class CollectionMaps {
	private ArrayList<Map> maps;

	public CollectionMaps() {
		super();
	}
	
	public void insertANewMap(Map map){
		this.maps.add(map);
	}
/**
 * <b>Metodo</B> <br>
 * Visualise all the maps among you can chose 
 * 
 */
	public void open() {
		for (Map m : this.maps) {
			System.out.println(m.toString());
		}
	}

	public Map lookFor(String nameMap) throws NullPointerException{
		for(Map m:this.maps) {
			if(m.getNameMap().contentEquals(nameMap)){
				return m;
			}
		}
		//handle NullPointerException
		return null;
	}
}
