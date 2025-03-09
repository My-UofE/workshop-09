package backend;

/**
 * This interface defines the contract between the backend and the frontend.
 *
 */
public interface MyServiceInterface {

	/**
	 * Create an element within the system.
	 * @param name The name of the element.
	 * @return The ID of the created element.
	 * @throws IllegalArgumentException if name is empty or null.
	 */
	int createElement(String name) throws IllegalArgumentException;
	
	/**
	 * Get an element by its ID.
	 * @param id ID of the element within the system.
	 * @return The name associated with the ID.
	 */
	String getElementName(int id);
	
	/**
	 * This methods retrieves the number of created elements.
	 * @return The number of elements created in the system.
	 */
	int getNumberOfElements();
}
