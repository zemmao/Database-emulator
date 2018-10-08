package hr.fer.zemris.java.tecaj.hw5.db.operators;

import org.junit.Assert;
import org.junit.Test;

public class GreaterComparisonOperatorTest {

	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue(){
		GreaterComparisonOperator operator = new GreaterComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "Antić"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse(){
		GreaterComparisonOperator operator = new GreaterComparisonOperator();
		Assert.assertFalse(operator.satisfied("Čipić", "Žuljević"));
	}
}
