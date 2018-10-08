package hr.fer.zemris.java.tecaj.hw5.db.operators;

import org.junit.Assert;
import org.junit.Test;

public class LessEqualsComparisonOperatorTest {

	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue(){
		LessEqualsComparisonOperator operator = new LessEqualsComparisonOperator();
		Assert.assertTrue(operator.satisfied("Čipić", "Čipić"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse(){
		LessEqualsComparisonOperator operator = new LessEqualsComparisonOperator();
		Assert.assertFalse(operator.satisfied("Žuljević", "Čipić"));
	}
}
