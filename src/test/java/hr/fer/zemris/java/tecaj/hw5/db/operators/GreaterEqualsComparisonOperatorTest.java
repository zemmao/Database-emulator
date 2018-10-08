package hr.fer.zemris.java.tecaj.hw5.db.operators;

import org.junit.Assert;
import org.junit.Test;

public class GreaterEqualsComparisonOperatorTest {

	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue(){
		GreaterEqualsComparisonOperator operator = new GreaterEqualsComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "Čipić"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse(){
		GreaterEqualsComparisonOperator operator = new GreaterEqualsComparisonOperator();
		Assert.assertFalse(operator.satisfied("Čipić", "Žuljević"));
	}
	
}
