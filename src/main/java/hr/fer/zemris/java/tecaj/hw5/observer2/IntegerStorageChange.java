package hr.fer.zemris.java.tecaj.hw5.observer2;

/**
 * Class encapsulates information: a reference to {@link IntegerStorage}, the value of stored 
 * integer before the change has occurred and the new value of currently stored integer.
 * @author Zemunik
 * @version 1.0
 */
public class IntegerStorageChange {

	/** Reference to Subject object that created this instance */
	private IntegerStorage integerStorage;
	/** Value of stored integer before the change in Subject */
	private int previousValue;
	/** New value of currently stored integer in Subject */
	private int currentValue;
	
	/**
	 * Constructor that sets all attributes.
	 * @param iStorage given reference to {@link IntegerStorage}
	 * @param previousValue given value of stored integer before the change in Subject
	 * @param currentValue given new value of currently stored integer in Subject
	 */
	public IntegerStorageChange(IntegerStorage iStorage, int previousValue,
			int currentValue) {
		this.integerStorage = iStorage;
		this.previousValue = previousValue;
		this.currentValue = currentValue;
	}

	/**
	 * Getter for Subject object reference
	 * @return {@link IntegerStorage} reference
	 */
	public IntegerStorage getintegerStorage() {
		return integerStorage;
	}

	/**
	 * Getter for previousValue attribute
	 * @return previousValue
	 */
	public int getPreviousValue() {
		return previousValue;
	}

	/**
	 * Getter for currentValue attribute
	 * @return currentValue
	 */
	public int getCurrentValue() {
		return currentValue;
	}
	
	
}
