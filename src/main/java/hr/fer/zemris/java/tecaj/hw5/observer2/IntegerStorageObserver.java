package hr.fer.zemris.java.tecaj.hw5.observer2;

/**
 * Observer interface which contains Concrete Observers (concrete actions) that will
 * be invoked by Subject object. 
 * @author Zemunik
 * @version 1.0
 */
public interface IntegerStorageObserver {

	/**
	 * Concrete Observer method that observer classes should implement.
	 * @param istorageChange instance that is passed to all registered observers in Subject
	 */
	public void valueChanged(IntegerStorageChange istorageChange);
}
