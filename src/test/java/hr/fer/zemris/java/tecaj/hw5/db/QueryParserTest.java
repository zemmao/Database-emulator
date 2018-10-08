package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.db.fields.FirstNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fields.JmbagFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.fields.LastNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.operators.DifferentComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.EqualsComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.GreaterComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.GreaterEqualsComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.LessComparisonOperator;
import hr.fer.zemris.java.tecaj.hw5.db.operators.LessEqualsComparisonOperator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class is used for testing {@link QueryParser} class. Coverage is 100%.
 * @author Zemunik
 * @version 1.0
 */
public class QueryParserTest {

	@Test
	public void parseQuery_ValidQueryGiven_ShouldReturnValidParameters_Test1(){
		QueryParser parser = new QueryParser("lastname=\"Bakamović\"");
		Assert.assertEquals("Bakamović", parser.getQueryString());
		Assert.assertTrue(parser.getOperatorName() instanceof EqualsComparisonOperator);
		Assert.assertTrue(parser.getFieldName() instanceof LastNameFieldGetter);
	}
	
	@Test
	public void parseQuery_ValidQueryGiven_ShouldReturnValidParameters_Test2(){
		QueryParser parser = new QueryParser("jmbag  > = \"0000000002\"");
		Assert.assertEquals("0000000002", parser.getQueryString());
		Assert.assertTrue(parser.getOperatorName() instanceof GreaterEqualsComparisonOperator);
		Assert.assertTrue(parser.getFieldName() instanceof JmbagFieldGetter);
	}
	
	@Test
	public void parseQuery_ValidQueryGiven_ShouldReturnValidParameters_Test3(){
		QueryParser parser = new QueryParser("firstname  <	= \"Petra\"");
		Assert.assertEquals("Petra", parser.getQueryString());
		Assert.assertTrue(parser.getOperatorName() instanceof LessEqualsComparisonOperator);
		Assert.assertTrue(parser.getFieldName() instanceof FirstNameFieldGetter);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void parseQuery_InvalidFieldNameGiven_ShouldThrowException(){
		new QueryParser("lastnameasd=\"Bakamović\"");
	}
	
	@Test
	public void setOperatorName_OperatorGreaterGiven_ShouldReturnValidParameters(){
		QueryParser parser = new QueryParser("lastname>\"Bakamović\"");
		Assert.assertTrue(parser.getOperatorName() instanceof GreaterComparisonOperator);
	}
	
	@Test
	public void setOperatorName_OperatorLessGiven_ShouldReturnValidParameters(){
		QueryParser parser = new QueryParser("lastname<\"Bakamović\"");
		Assert.assertTrue(parser.getOperatorName() instanceof LessComparisonOperator);
	}
	
	@Test
	public void setOperatorName_OperatorDifferentGiven_ShouldReturnValidParameters(){
		QueryParser parser = new QueryParser("lastname != \"Bakamović\"");
		Assert.assertTrue(parser.getOperatorName() instanceof DifferentComparisonOperator);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setOperatorName_InvalidOperatorGiven_ShouldThrowException_Test1(){
		new QueryParser("lastname <> \"Bakamović\"");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setOperatorName_InvalidOperatorGiven_ShouldThrowException_Test2(){
		new QueryParser("lastname ! \"Bakamović\"");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setQueryString_GivenStringTooShort_ShouldThrowException(){
		new QueryParser("lastname = \"");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setQueryString_GivenStringMissingQuotes_ShouldThrowException_Test1(){
		new QueryParser("lastname = \"a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setQueryString_GivenStringMissingQuotes_ShouldThrowException_Test2(){
		new QueryParser("lastname <=a\"");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setQueryString_QuotesInsideGivenString_ShouldThrowException(){
		new QueryParser("lastname = \"as\"\"");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setQueryString_TwoStarsInsideGivenString_ShouldThrowException(){
		new QueryParser("lastname = \"a**\"");
	}
	
	@Test
	public void setQueryString_ValidGivenString_ShouldReturnValidParametrs(){
		new QueryParser("lastname >= \"a*\"");
	}
}
