package hr.fer.zemris.java.tecaj.hw5.observer2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents Subject in Observer pattern with its necessary methods.
 * @author Zemunik
 * @version 1.0
 */
public class IntegerStorage {

	/** Integer value whose change notifies Observer classes*/
	private int value;
	/** List of instances that implement Observer interface */
	private List<IntegerStorageObserver> observers = null;
	
	/**
	 * Constructor that sets value attribute.
	 * @param initialValue given initsal value
	 */
	public IntegerStorage(int initialValue) {
		this.value = initialValue;
	}
	
	/**
	 * Method is used to register a concrete action with this object.
	 * @param observer instance of Observer interface
	 */
	public void addObserver(IntegerStorageObserver observer) {
		if(observers == null){
			observers = new ArrayList<IntegerStorageObserver>();
			observers.add(observer);
		} else{
			if(!observers.contains(observer)){
				observers.add(observer);
			}
		}
	}
	
	/**
	 * Method is used to remove registered concrete action connected with this object.
	 * @param observer instance of Observer interface
	 */
	public void removeObserver(IntegerStorageObserver observer) {
		if(observers == null){
			return;
		} else{
			if(observers.contains(observer)){
				observers.remove(observer);
			}
		}
	}
	
	/**
	 * Method removes all registered concrete actions connected with this object.
	 */
	public void clearObservers() {
		if(observers != null){
			observers.clear();
		}
	}
	
	/**
	 * Getter for value attribute
	 * @return value attribute
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Method sets new value to the attribute. If value has changed, method notifies all
	 * registered observers using created {@link IntegerStorageChange} instance. 
	 * @param value given value
	 */
	public void setValue(int value) {
		// Only if new value is different than the current value:
		if(this.value!=value) {
			int previousValue = this.value;
			this.value = value;
			IntegerStorageChange iStorageChange = new IntegerStorageChange(this, 
					previousValue, this.value);
			
			// Notify all registered observers
			if(observers!=null) {
				List<IntegerStorageObserver> tempList = 
						new ArrayList<IntegerStorageObserver>(this.observers);
				for(IntegerStorageObserver observer : tempList) {
					observer.valueChanged(iStorageChange);
				}
			}
		}
	}
}
