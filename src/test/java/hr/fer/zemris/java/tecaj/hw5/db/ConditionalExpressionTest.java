package hr.fer.zemris.java.tecaj.hw5.db;

import hr.fer.zemris.java.tecaj.hw5.db.fields.FirstNameFieldGetter;
import hr.fer.zemris.java.tecaj.hw5.db.operators.DifferentComparisonOperator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class is used for testing {@link ConditionalExpression} class. Coverage is 100%.
 * @author Zemunik
 * @version 1.0
 */
public class ConditionalExpressionTest {

	@Test
	public void constructorAndGetters_ValidArgumentsGiven_ShouldReturnValidParameters(){
		FirstNameFieldGetter firstNameGetter = new FirstNameFieldGetter();
		DifferentComparisonOperator operator = new DifferentComparisonOperator();
		ConditionalExpression expression = new ConditionalExpression(firstNameGetter, 
				"Ante", operator);
		Assert.assertTrue(expression.getFieldValueGetter()  instanceof FirstNameFieldGetter);
		Assert.assertTrue(expression.getComparisonOperator() instanceof DifferentComparisonOperator);
		Assert.assertEquals("Ante", expression.getStringLiteral());
	}
}
