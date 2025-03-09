/**
 * 
 */
package backend;

import java.util.ArrayList;

/**
 * @author diogopacheco
 *
 */
public class MyServiceImplementation implements MyServiceInterface {

	private ArrayList<Element> myElements;
	
	/**
	 * Creates an empty instance of my service.
	 */
	public MyServiceImplementation() {
		this.myElements = new ArrayList<Element>();
	}
	
	@Override
	public int getNumberOfElements() {
		return this.myElements.size();
	}

	@Override
	public int createElement(String name) {
		Element element = new Element(name);
		this.myElements.add(element);
		
		return element.getId();
	}

	@Override
	public String getElementName(int id) {
		return Element.getElementNameById(id, myElements);
	}

}
