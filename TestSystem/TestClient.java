import backend.MyServiceImplementation;
import backend.MyServiceInterface;

public class TestClient{

	public static void main(String[] args) {
		
		System.out.println("Testing my system integration.");
		
		MyServiceInterface myService = new MyServiceImplementation();
		
		System.out.println("Before creating elements, my system has " + myService.getNumberOfElements() + " elements.");
		
		int id = myService.createElement("my first element");
		
		System.out.println("Element created. Id = " + id);
		
		System.out.println("After creating one element, my system has " + myService.getNumberOfElements() + " elements.");
		
		System.out.println("What is the name of the element ID=10? " + myService.getElementName(10));
		
		System.out.println("What is the name of the element created? " + myService.getElementName(id));
	}
}
