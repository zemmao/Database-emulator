package hr.fer.zemris.java.tecaj.hw5.observer1;

/**
 * Observer interface which contains Concrete Observers (concrete actions) that will
 * be invoked by Subject object. 
 * @author Zemunik
 * @version 1.0
 */
public interface IntegerStorageObserver {

	/**
	 * Concrete Observer method that observer classes should implement.
	 * @param istorage instance of Subject class in Observer pattern
	 */
	public void valueChanged(IntegerStorage istorage);
}
