package hr.fer.zemris.java.tecaj.hw5.db.operators;

/**
 * Strategy interface which is responsible for implementing comparison operator.
 * @author Zemunik
 * @version 1.0
 */
public interface IComparisonOperator {

	/**
	 * Method compares given two values and returns true if comparison is satisfied for this 
	 * operator.
	 * @param value1 given first string
	 * @param value2  given second string
	 * @return true if comparison is satisfied for this operator, false otherwise
	 */
	public boolean satisfied(String value1, String value2);
}
