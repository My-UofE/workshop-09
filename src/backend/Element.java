/**
 * 
 */
package backend;

import java.util.ArrayList;

/**
 * This class represent my element.
 * 
 */
public class Element {
	
	private static int idCounter = 0;
	
	private int id;
	
	private String name;
	
	/**
	 * Create a new element with a given name.
	 * @param name
	 */
	public Element(String name) {
		if(name == null || name.trim() == "") {
			throw new IllegalArgumentException("Name is not valid.");
		}
		this.name = name;
		this.id = ++idCounter;
	}
	
	/**
	 * Get the element's name.
	 * @return The name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the element's ID.
	 * @return The ID.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * This method search for an element within a list of elements trying to match its ID. 
	 * @param id ID to be used in the search.
	 * @param elementList List with elements to search.
	 * @return The element name if there an element is found, null otherwise.
	 */
	public static String getElementNameById(int id, ArrayList<Element> elementList) {
		String name = null; // element not found.
		for(Element element: elementList) {
			if(element.getId() == id) {
				name = element.getName();
				break;
			}
		}
		return name;
	}
}
