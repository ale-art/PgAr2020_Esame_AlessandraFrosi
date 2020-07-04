package it.unibs.ing.arnaldo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * <b>Classe</b> <br>
 * xml reader
 * 
 * @author Alessandra Frosi
 *
 */
public class XmlManager {
	/**
	 * 
	 * @param filePath
	 * @return a map rapresenting the map choseon by the player
	 * @throws XMLStreamException
	 * @throws FileNotFoundException
	 */
	public static Map readCells(String filePath) throws XMLStreamException, FileNotFoundException {
		HashMap<Integer, Cell> cells = new HashMap<Integer, Cell>();
		String nameMap = null;
		int size=0;
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		XMLStreamReader xmlr = null;

		try {
			xmlr = xmlif.createXMLStreamReader(filePath, new FileInputStream(filePath));

			while (xmlr.hasNext()) {
				/**
				 * For each start element with name "cell" it took its data and save them into
				 * the map
				 */
				if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("map")) {
					size=Integer.parseInt(xmlr.getAttributeValue(0));
					nameMap = xmlr.getAttributeValue(1);
				}
				if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("cell")) {
					int id = Integer.parseInt(xmlr.getAttributeValue(0));
					//System.out.println(id);
					String name = xmlr.getAttributeValue(1);
					//System.out.println(name);
					String type = xmlr.getAttributeValue(2);
					if (type.contentEquals("iniziale")) {
						cells.put(id, new StartingPoint(name));
					}
					if (type.contentEquals("probabilita")) {
						xmlr.next();
						xmlr.next();
						double value = Double.parseDouble(xmlr.getAttributeValue(0));
						xmlr.nextTag();
						xmlr.nextTag();
						xmlr.nextTag();
						String message1 = xmlr.getAttributeValue(0);
						xmlr.next();
						xmlr.nextTag();
						String message2 = xmlr.getAttributeValue(0);
						xmlr.nextTag();
						xmlr.next();
						String message = message1 + "\n" + message2;
						cells.put(id, new Probability(name, message, value));
					}
					if (type.contentEquals("imprevisto")) {
						xmlr.next();
						xmlr.next();
						double value = Double.parseDouble(xmlr.getAttributeValue(0));
						xmlr.nextTag();
						xmlr.nextTag();
						xmlr.nextTag();
						String message1 = xmlr.getAttributeValue(0);
						xmlr.next();
						xmlr.nextTag();
						String message2 = xmlr.getAttributeValue(0);
						xmlr.nextTag();
						xmlr.next();
						String message = message1 + "\n" + message2;
						//System.out.println(message);
						cells.put(id, new Accident(name, message, value));
					}
					if (type.contentEquals("stazione")) {
						cells.put(id, new Station(name));
					}

				}
				xmlr.next();

			}

			xmlr.close();

		} catch (FileNotFoundException |

				XMLStreamException e) {
			throw e;
		}

		Map map = new Map(cells, size,nameMap);
		return map;
	}
}
