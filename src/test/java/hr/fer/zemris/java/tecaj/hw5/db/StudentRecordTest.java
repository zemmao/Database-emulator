package hr.fer.zemris.java.tecaj.hw5.db;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class is used for testing {@link StudentRecord} class. Coverage is 100%.
 * @author Zemunik
 * @version 1.0
 */
public class StudentRecordTest {

	@Test
	public void constructorAndGetters_ValidArgumentsGiven_ShouldReturnParameters(){
		StudentRecord record = new StudentRecord("0000000001", "Akšamović", "Marin Luka", 5);
		Assert.assertEquals(record.getJmbag(), "0000000001");
		Assert.assertEquals(record.getFirstName(), "Marin Luka");
		Assert.assertEquals(record.getLastName(), "Akšamović");
		Assert.assertEquals(record.getGrade(), 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkJmbag_InvalidJmbagGiven_ShouldThrowException(){
		new StudentRecord("00000asd01", "Akšamović", "Marin", 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkName_InvalidNameGiven_ShouldThrowException_Test1(){
		new StudentRecord("0000000001", "Akšamović", "Marin-And4", 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkName_InvalidNameGiven_ShouldThrowException_Test2(){
		new StudentRecord("0000000001", "Akšamović", "Marin-", 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkName_InvalidNameGiven_ShouldThrowException_Test3(){
		new StudentRecord("0000000001", "Akšamović", "Marin--Luka", 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkName_InvalidGradeGiven_ShouldThrowException_Test1(){
		new StudentRecord("0000000001", "Akšamović", "Marin", 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkName_InvalidGradeGiven_ShouldThrowException_Test2(){
		new StudentRecord("0000000001", "Akšamović", "Marin", 10);
	}
	
	@Test
	public void equals_NullObjectGiven_ShouldReturnFalse(){
		StudentRecord record = new StudentRecord("0000000001", "Akšamović", "Marin", 5);
		Assert.assertFalse(record.equals(null));
	}
	
	@Test
	public void equals_WrongInstanceObjectGiven_ShouldReturnFalse(){
		StudentRecord record = new StudentRecord("0000000001", "Akšamović", "Marin", 5);
		Assert.assertFalse(record.equals(new Integer(4)));
	}
	
	@Test
	public void equals_SameJmbagObjectGiven_ShouldReturnTrue(){
		StudentRecord firstRecord = new StudentRecord("0000000001", "Akšamović", "Marin", 5);
		StudentRecord secondRecord = new StudentRecord("0000000001", "Bakamović", "Petra", 4);
		Assert.assertTrue(firstRecord.equals(secondRecord));
	}
	
	@Test
	public void equals_SameJmbagObjectGiven_ShouldReturnFalse(){
		StudentRecord firstRecord = new StudentRecord("0000000001", "Akšamović", "Marin", 5);
		StudentRecord secondRecord = new StudentRecord("0000000002", "Bakamović", "Petra", 4);
		Assert.assertFalse(firstRecord.equals(secondRecord));
	}
	
	@Test (expected =IllegalArgumentException.class)
	public void checkName_EmptyStringGiven_ShouldThrowException(){
		new StudentRecord("0000000001", "	 ", "Marin", 5);
	}
	
}
