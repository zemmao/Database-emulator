	package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.db.fields.FirstNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fields.IFieldValueGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fields.JmbagFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fields.LastNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.operators.DifferentComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.EqualsComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.GreaterComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.GreaterEqualsComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.IComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.LessComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.LessEqualsComparisonOperator;

/**
 * Class implements parsing input query into three parts: fieldName, operatorName and 
 * stringInQuery. It offers getters for these three attributes.
 * @author Zemunik
 * @version 1.0
 */
public class QueryParser {

	/** Part of the input query in form, for example: lastName = "B*" */
	private String inputQuery;
	/** Instance of the field in query */
	private IFieldValueGetter fieldName;
	/** Instance of the operator in query */
	private IComparisonOperator operatorName;
	/** Comparative string in the query */
	private String stringInQuery;
	
	
	/**
	 * Method receives one part of query, for example: lastName="B*" and calls method 
	 * for parsing it.
	 * @param query part of input query string
	 */
	public QueryParser(String query){
		this.inputQuery = query;
		parseQuery();
	}
	
	/**
	 * Method parses input query string into: field name, operator symbol and string literal.
	 */
	private void parseQuery(){
		inputQuery = inputQuery.trim();
		String[] queryParts = inputQuery.split("(?=[<,>,=,!])",2);	
		setFieldName(queryParts[0].trim());
		
		/*queryParts[1] is the rest of the query*/
		String restOfQuery = queryParts[1];
		String operator = "" + restOfQuery.charAt(0);
		restOfQuery = restOfQuery.substring(1);
		char currentChar = restOfQuery.charAt(0);
		
		while(currentChar != '"'){
			if(currentChar == '\t' || currentChar == ' '){
				restOfQuery = restOfQuery.substring(1);
				currentChar = restOfQuery.charAt(0);
				continue;
			} else{
				operator = operator + currentChar;
				restOfQuery = restOfQuery.substring(1);
				break;
			}
		}
		setOperatorName(operator);
		
		/*At this point, restOfQuery should consist only string literal.*/
		setQueryString(restOfQuery);
		
	}
	
	/**
	 * Method sets field to one of the classes that implement {@link IFieldValueGetter}.
	 * @param fieldName received field name
	 * @throws IllegalArgumentException if field name is invalid
	 */
	private void setFieldName(String fieldName){
		fieldName = fieldName.trim();
		if(fieldName.toLowerCase().equals("jmbag")){
			this.fieldName = new JmbagFieldGetter();
		} else if(fieldName.toLowerCase().equals("lastname")){
			this.fieldName = new LastNameFieldGetter();
		}else if(fieldName.toLowerCase().equals("firstname")){
			this.fieldName = new FirstNameFieldGetter();
		} else{
			/*Invalid field name*/
			throw new IllegalArgumentException("Invalid field name was provided.");
		}
	}
	
	/**
	 * Method sets operator to one of the classes that implement {@link IComparisonOperator}.
	 * @param operator received operator 
	 * @throws IllegalArgumentException if operator is invalid
	 */
	private void setOperatorName(String operator){
		if(operator.length() == 1){
			if(operator.equals(">")){
				this.operatorName = new GreaterComparisonOperator();
			} else if(operator.equals("<")){
				this.operatorName = new LessComparisonOperator();
			} else if(operator.equals("=")){
				this.operatorName = new EqualsComparisonOperator();
			} else{
				throw new IllegalArgumentException("Invalid operator was provided.");
			}
		} else{
			/*Operator length is two.*/
			if(operator.equals(">=")){
				this.operatorName = new GreaterEqualsComparisonOperator();
			} else if(operator.equals("<=")){
				this.operatorName = new LessEqualsComparisonOperator();
			} else if(operator.equals("!=")){
				this.operatorName = new DifferentComparisonOperator();
			} else{
				throw new IllegalArgumentException("Invalid operator was provided.");
			}
		}
	}
	
	/**
	 * Method sets comparative string in  query.
	 * @param stringLiteral given string
	 * @throws IllegalArgumentException if string is invalid
	 */
	private void setQueryString(String stringLiteral){
		stringLiteral = stringLiteral.trim();
		int stringLiteralLength = stringLiteral.length();
		if(stringLiteralLength < 2){
			throw new IllegalArgumentException("Invalid string was provided.");
		}
		if(stringLiteral.charAt(0) != '"' || 
				stringLiteral.charAt(stringLiteralLength-1) != '"'){
			throw new IllegalArgumentException("Invalid string was provided.");
		}
		/*Remove quotes from string*/
		stringLiteral = stringLiteral.substring(1, stringLiteralLength-1);
		stringLiteral = stringLiteral.trim();
		stringLiteralLength = stringLiteral.length();
		String returnString = "";
		int currentIndex = 0;
		char currentChar;
		int numberOfStarSymobls = 0;
		
		while(currentIndex < stringLiteralLength){
			currentChar = stringLiteral.charAt(currentIndex);
			if(currentChar == '"'){
				throw new IllegalArgumentException("Invalid string was provided.");
			} else if(currentChar == '*' && this.operatorName instanceof EqualsComparisonOperator){
				numberOfStarSymobls++;
				if(numberOfStarSymobls > 1){
					throw new IllegalArgumentException("Invalid string was provided.");
				}
				returnString = returnString + currentChar;
				currentIndex++;
			} else{
				returnString = returnString + currentChar;
				currentIndex++;
			}
		}
		
		this.stringInQuery = returnString;
	}

	/**
	 * Getter for field of the query.
	 * @return instance of the field
	 */
	public IFieldValueGetter getFieldName() {
		return fieldName;
	}

	/**
	 * Getter for operator of the query.
	 * @return instance of the operator
	 */
	public IComparisonOperator getOperatorName() {
		return operatorName;
	}

	/**
	 * Getter for comparative string of the query.
	 * @return comparative string of the query
	 */
	public String getQueryString() {
		return stringInQuery;
	}
	
}
