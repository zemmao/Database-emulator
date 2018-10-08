package hr.fer.zemris.java.tecaj.hw5.db.operators;

import org.junit.Assert;
import org.junit.Test;

public class EqualsComparisonOperatorTest {

	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "Čipić"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue_StarAtTheEnd(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "Čip*"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse_StarAtTheEnd(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertFalse(operator.satisfied("Čipić", "Čiz*"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue_StarAtTheBeginning(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "*pić"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse_StarAtTheBeginning(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertFalse(operator.satisfied("Čipić", "*zić"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue_StarInTheMiddle(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "Či*ć"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse_StarInTheMiddle_Test1(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertFalse(operator.satisfied("Čipić", "Či*č"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse_StarInTheMiddle_Test2(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertFalse(operator.satisfied("Čipić", "Ći*ć"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue_StarOnlySymbol(){
		EqualsComparisonOperator operator = new EqualsComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "*"));
	}
	
}
