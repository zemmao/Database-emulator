package hr.fer.zemris.java.tecaj.hw5.observer1;

/**
 * Instances of this class write a square of the integer stored in the {@link IntegerStorage} 
 * to the standard output.
 * @author Zemunik
 * @version 1.0
 */
public class SquareValue implements IntegerStorageObserver{

	@Override
	public void valueChanged(IntegerStorage istorage) {
		int receivedValue = istorage.getValue();
		int squareValue = (int) Math.pow(receivedValue, 2);
		System.out.format("Provided new value: %d, square is %d%n", receivedValue, squareValue);
		
	}

}
