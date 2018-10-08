package hr.fer.zemris.java.tecaj.hw5.observer1;

/**
 * Class counts (and writes to the standard output) the number of times value stored integer 
 * (in Subject) has been changed since the registration.
 * @author Zemunik
 * @version 1.0
 */
public class ChangeCounter implements IntegerStorageObserver{

	/** Counter attribute */
	private int counter = 0;
	
	@Override
	public void valueChanged(IntegerStorage istorage) {
		counter++;
		System.out.println("Number of value changes since tracking: " + counter);
		
	}

}
