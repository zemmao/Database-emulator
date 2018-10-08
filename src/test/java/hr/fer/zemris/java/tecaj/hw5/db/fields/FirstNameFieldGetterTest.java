package hr.fer.zemris.java.tecaj.hw5.db.fields;

import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;

import org.junit.Assert;
import org.junit.Test;

public class FirstNameFieldGetterTest {

	@Test
	public void get_ValidStudentRecordGiven_FirstNameExpected(){
		StudentRecord record = new StudentRecord("0000000002", "Bakamović", 
				"Petra", 3);
		FirstNameFieldGetter firstNameGetter = new FirstNameFieldGetter();
		Assert.assertEquals(firstNameGetter.get(record), "Petra");
	}
	
}
