package hr.fer.zemris.java.tecaj.hw5.db.operators;

import org.junit.Assert;
import org.junit.Test;

public class DifferentComparisonOperatorTest {

	@Test
	public void satisfied_DifferentStringsGiven_ShouldReturnTrue(){
		DifferentComparisonOperator operator = new DifferentComparisonOperator();
		String firstString = "Ante";
		String secondString = "Ivan";
		Assert.assertTrue(operator.satisfied(firstString, secondString));
	}
	
	@Test
	public void satisfied_DifferentStringsGiven_ShouldReturnFalse(){
		DifferentComparisonOperator operator = new DifferentComparisonOperator();
		String firstString = "Ante";
		String secondString = "Ante";
		Assert.assertFalse(operator.satisfied(firstString, secondString));
	}
}
