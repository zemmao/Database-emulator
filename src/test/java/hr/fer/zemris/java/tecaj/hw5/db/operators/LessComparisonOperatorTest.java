package hr.fer.zemris.java.tecaj.hw5.db.operators;

import org.junit.Assert;
import org.junit.Test;

public class LessComparisonOperatorTest {

	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnTrue(){
		LessComparisonOperator operator = new LessComparisonOperator();
		Assert.assertTrue(operator.satisfied("Antić", "Čipić"));
	}
	
	@Test
	public void satisfied_TwoStringsGiven_ShouldReturnFalse(){
		LessComparisonOperator operator = new LessComparisonOperator();
		Assert.assertFalse(operator.satisfied("Žuljević", "Čipić"));
	}
}
