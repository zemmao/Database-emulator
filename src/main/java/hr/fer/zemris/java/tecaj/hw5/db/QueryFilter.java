package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.db.fields.JmbagFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.operators.EqualsComparisonOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class represents filter for given query. It contains all parts of query in expressionList and
 * evaluates whether given student record satisfies all of them.
 * @author Zemunik
 * @version 1.0
 */
public class QueryFilter implements IFilter{

	/** Contains all parts of given query */
	private List<ConditionalExpression> expressionList = new ArrayList<ConditionalExpression>();
	/** Variable used for memorizing if given query has part like this: jmbag = "...."*/
	private String jmbag = null;
	
	/**
	 * Constructor builds expressionList from given query.
	 * @param query given query
	 * @throws IllegalArgumentException if invalid input query was provided
	 */
	public QueryFilter(String query) {
		
		query = query.trim();
		if(query.endsWith("and")){
			throw new IllegalArgumentException("Invalid input query");
		}
		
		ConditionalExpression expression = null;
		
		/*Variable jmbagFound remembers if jmbag="..." has been found. If this expression
		 * has already been found, don't put it in variable jmbag, but add it to expressionList.*/
		boolean jmbagFound = false;
		String[] queryParts = query.split("and");
		QueryParser queryParser = null;
		for(String queryPart: queryParts){
			queryParser = new QueryParser(queryPart);
			if(queryParser.getFieldName() instanceof JmbagFieldGetter &&
					queryParser.getOperatorName() instanceof EqualsComparisonOperator &&
					!queryParser.getQueryString().contains("*") && jmbagFound == false){
				jmbag = queryParser.getQueryString();
				jmbagFound = true;
			} else{
				expression = new ConditionalExpression(
						queryParser.getFieldName(), queryParser.getQueryString(), 
						queryParser.getOperatorName());
				expressionList.add(expression);
			}
		}
	}

	@Override
	public boolean accepts(StudentRecord record) {
		
		for(ConditionalExpression expression: expressionList){
			boolean recordSatisfies = expression.getComparisonOperator().
					satisfied(expression.getFieldValueGetter().get(record), 
								expression.getStringLiteral());
			if(recordSatisfies == true){
				continue;
			} else{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Factory method that returns jmbag if query has part: jmbag = "...."
	 * @return jmbag if that attribute has been set, empty string itherwise
	 */
	public Optional<String> getJMBAG(){
		if(jmbag == null){
			return Optional.empty();
		} else{
			return Optional.of(jmbag);
		}
	}

}
