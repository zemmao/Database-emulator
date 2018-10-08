package hr.fer.zemris.java.tecaj.hw5.observer2;

/**
 * Class writes to the standard output double value of the current value which is stored in 
 * Subject. After writing the double value for the second time, the observer automatically 
 * de-registers itself from the subject.
 * @author Zemunik
 * @version 1.0
 */
public class DoubleValue implements IntegerStorageObserver{

	/** Counts how many times this observer has been called since its registration */
	private int modificationCounter = 0;
	
	@Override
	public void valueChanged(IntegerStorageChange istorageChange) {
		modificationCounter++;
		int doubleValue = istorageChange.getCurrentValue() * 2;
		System.out.println("Double value: " + doubleValue);
		if(modificationCounter == 2){
			IntegerStorage iStorage = istorageChange.getintegerStorage();
			iStorage.removeObserver(this);
		}
		
	}

}
