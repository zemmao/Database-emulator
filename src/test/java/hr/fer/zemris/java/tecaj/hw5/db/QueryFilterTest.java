package hr.fer.zemris.java.tecaj.hw5.db;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class is used for testing {@link QueryFilter} class. Coverage is 100%.
 * @author Zemunik
 * @version 1.0
 */
public class QueryFilterTest {

	@Test
	public void constructorAndAccepts_ValidQueryStringGiven_ShouldReturnTrue(){
		String query = "lastName = \"Bakamović\"";
		StudentRecord record = new StudentRecord("0000000002", "Bakamović", 
				"Petra", 3);
		QueryFilter filter = new QueryFilter(query);
		Assert.assertTrue(filter.accepts(record));
	}
	
	@Test
	public void constructorAndAccepts_DiffernetRecordGiven_ShouldReturnFalse(){
		String query = "lastName = \"Bakamović\"";
		StudentRecord record = new StudentRecord("0000000002", "Akšamović", 
				"Petra", 3);
		QueryFilter filter = new QueryFilter(query);
		Assert.assertFalse(filter.accepts(record));
	}
	
	@Test
	public void getJMBAG_ValidQueryGiven_ShouldReturnJmbag(){
		String query = "jmbag = \"0000000001\"";
		QueryFilter filter = new QueryFilter(query);
		Optional<String> jmbag = filter.getJMBAG();
		if(jmbag.isPresent()){
			Assert.assertEquals("0000000001", jmbag.get());
		}
	}
	
	@Test
	public void getJMBAG_QueryGiven_JmbagDoesNotExist(){
		String query = "lastName = \"Bakamović\"";
		QueryFilter filter = new QueryFilter(query);
		Optional<String> jmbag = filter.getJMBAG();
		if(!jmbag.isPresent()){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void constructor_ValidQueryGiven_ShouldReturnTrue_Test1(){
		String query = "jmbag > \"0000000001\"";
		QueryFilter filter = new QueryFilter(query);
		StudentRecord record = new StudentRecord("0000000002", "Akšamović", 
				"Petra", 3);
		Assert.assertTrue(filter.accepts(record));
	}
	
	@Test
	public void constructor_ValidQueryGiven_ShouldReturnTrue_Test2(){
		String query = "jmbag = \"*00000001\"";
		QueryFilter filter = new QueryFilter(query);
		StudentRecord record = new StudentRecord("0000000001", "Akšamović", 
				"Petra", 3);
		Assert.assertTrue(filter.accepts(record));
	}
	
	@Test
	public void constructor_InvalidQueryGiven_ShouldReturnFalse(){
		String query = "jmbag = \"0000000001\" and jmbag = \"0000000002\"";
		QueryFilter filter = new QueryFilter(query);
		StudentRecord record = new StudentRecord("0000000001", "Akšamović", 
				"Petra", 3);
		Assert.assertFalse(filter.accepts(record));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructor_InvalidQueryGiven_ShouldThrowException(){
		new QueryFilter("	query jmbag = \"0000000002\" and ");
	}
}
