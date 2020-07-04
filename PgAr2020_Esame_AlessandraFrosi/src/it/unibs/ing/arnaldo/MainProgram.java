package it.unibs.ing.arnaldo;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

public class MainProgram {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		Cube c=new Cube();
		Player p=new Player("piero", 0,1000,c);
		CollectionMaps cm=new CollectionMaps();
		Map map;
		map=XmlManager.readCells("/Users/ales/git/PgAr2020_Esame_AlessandraFrosi/PgAr2020_Esame_AlessandraFrosi/input/1) base (10).xml");
		MapManager m=new MapManager(map,p);
		m.check(); //check and start are the same thing;
		
	}

//	public static CollectionMaps insertMaps(){
//		CollectionMaps cm=new CollectionMaps();
//		Map map;
//		try {
//			map=XmlManager.readCells("/Users/ales/git/PgAr2020_Esame_AlessandraFrosi/PgAr2020_Esame_AlessandraFrosi/input/1) base (10).xml");
//			cm.insertANewMap(map);
//			//cm.insertANewMap("/Users/ales/git/PgAr2020_Esame_AlessandraFrosi/PgAr2020_Esame_AlessandraFrosi/input/1) base (10) copy.xml");
//		} catch (FileNotFoundException | XMLStreamException e) {
//			e.printStackTrace();
//			System.out.println("This file does not exist or cannot be read");
//		}
//		return cm;
//	}

}
