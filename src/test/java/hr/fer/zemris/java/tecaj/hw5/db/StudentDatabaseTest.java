package hr.fer.zemris.java.tecaj.hw5.db;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class is used for testing {@link StudentDatabase} class. Coverage is 100%.
 * @author Zemunik
 * @version 1.0
 */
public class StudentDatabaseTest {

	@Test
	public void constructorAndforJMBAG_ValidDefinitionListGiven_ShouldReturnValidParameter(){
		List<String> definitionsList = new ArrayList<String>();
		definitionsList.add("0000000001	Akšamović	Marin	5");
		definitionsList.add("0000000002	Bakamović	Petra	3");
		definitionsList.add("");
		StudentDatabase database = new StudentDatabase(definitionsList);
		StudentRecord record = database.forJMBAG("0000000001");
		Assert.assertEquals(record.getLastName(), "Akšamović");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructor_InvalidNumberOfArguments_ShouldThrowException(){
		List<String> definitionsList = new ArrayList<String>();
		definitionsList.add("0000000001	Akšamović	Marin	5	1");
		definitionsList.add("0000000002	Bakamović	Petra	3");
		new StudentDatabase(definitionsList);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructor_InvalidGradeString_ShouldThrowException(){
		List<String> definitionsList = new ArrayList<String>();
		definitionsList.add("0000000001	Akšamović	Marin	a");
		definitionsList.add("0000000002	Bakamović	Petra	3");
		new StudentDatabase(definitionsList);
	}
	
	@Test
	public void filter_ValidFilterGiven_ShouldReturnFilterList(){
		List<String> definitionsList = new ArrayList<String>();
		definitionsList.add("0000000001	Akšamović	Marin	5");
		definitionsList.add("0000000002	Bakamović	Petra	3");
		definitionsList.add("0000000003	Župić	Ivo	2");
		StudentDatabase database = new StudentDatabase(definitionsList);
		String query = "lastName < \"Vuk\"";
		QueryFilter filter = new QueryFilter(query);
		Assert.assertTrue(database.filter(filter).size() == 2);
	}
}
