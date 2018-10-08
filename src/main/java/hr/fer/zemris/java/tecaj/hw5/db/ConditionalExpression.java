package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.db.fields.IFieldValueGetter;
import hr.fer.zemris.java.tecaj.hw5.db.operators.IComparisonOperator;

/**
 * Class represents complete conditional expression of query.
 * @author Zemunik
 * @version 1.0
 */
public class ConditionalExpression {

	/** Field value of the expression */
	private IFieldValueGetter fieldValueGetter;
	/** Comparative string in the expression */
	private String stringLiteral;
	/** Operator of the expression */
	private IComparisonOperator comparisonOperator;
	
	/**
	 * Constructor sets all attributes of the class.
	 * @param fieldValueGetter given {@link IFieldValueGetter} startegy
	 * @param queryString given string of the eypression
	 * @param comparisonOperator given {@link IComparisonOperator} startegy
	 */
	public ConditionalExpression(IFieldValueGetter fieldValueGetter,
			String queryString, IComparisonOperator comparisonOperator){
		this.fieldValueGetter = fieldValueGetter;
		this.stringLiteral = queryString;
		this.comparisonOperator = comparisonOperator;
	}

	/**
	 * Getter for fieldValueGetter attribute
	 * @return fieldValueGetter attribute
	 */
	public IFieldValueGetter getFieldValueGetter() {
		return fieldValueGetter;
	}

	/**
	 * Getter for stringLiteral attribute
	 * @return stringLiteral attribute
	 */
	public String getStringLiteral() {
		return stringLiteral;
	}

	/**
	 * Getter for comparisonOperator attribute
	 * @return comparisonOperator attribute
	 */
	public IComparisonOperator getComparisonOperator() {
		return comparisonOperator;
	}
	
	
}
