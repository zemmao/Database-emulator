package hr.fer.zemris.java.tecaj.hw5.db;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class is used for testing {@link QueryPreparation} class. Coverage is 100%.
 * @author Zemunik
 * @version 1.0
 */
public class QueryPreparationTest {

	@Test
	public void prepareQuery_ValidQueryGiven_ShouldReturnSecondPartOfQuery(){
		QueryPreparation queryPreparation = new QueryPreparation();
		String inputQuery = "query jmbag = \"0000000001\"";
		String received = queryPreparation.prepareQuery(inputQuery);
		String actual = "jmbag = \"0000000001\"";
		Assert.assertEquals(received, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void prepareQuery_InvalidQueryGiven_ShouldThrowException(){
		QueryPreparation queryPreparation = new QueryPreparation();
		queryPreparation.prepareQuery("quer jmbag=\"0000000003\"");
	}
}
