package hr.fer.zemris.java.tecaj.hw5.db;

/**
 * Class is used for preparing input query for {@link QueryFilter} constructor.
 * @author Zemunik
 * @version 1.0
 */
public class QueryPreparation {

	/**
	 * Method removes key word "query" from input query string.
	 * @param inputQuery input query string
	 * @return input query without key word:query
	 * @throws IllegalArgumentException if first word of the query is not correct.
	 */
	public String prepareQuery(String inputQuery){
		/*splitQuery is array that consist of key word "query" and the rest of input query string*/
		String[] splitQuery = inputQuery.trim().split("[\\t|\\s]+",2);
		if(!splitQuery[0].toLowerCase().equals("query")){
			throw new IllegalArgumentException("Invalid input query string.");
		} else{
			return splitQuery[1];
		}
	}
	
}
