package hr.fer.zemris.java.tecaj.hw5.db.operators;

/**
 * Class is responsible for implementing not equal to comparison operator.
 * @author Zemunik
 * @version 1.0
 */
public class DifferentComparisonOperator implements IComparisonOperator{

	@Override
	public boolean satisfied(String value1, String value2) {
		return !value1.equals(value2);
	}

}
