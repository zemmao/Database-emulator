package hr.fer.zemris.java.tecaj.hw5.db.fields;

import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;

import org.junit.Assert;
import org.junit.Test;

public class LastNameFieldGetterTest {

	@Test
	public void get_ValidStudentRecordGiven_LastNameExpected(){
		StudentRecord record = new StudentRecord("0000000002", "Bakamović", 
				"Petra", 3);
		LastNameFieldGetter lastNameGetter = new LastNameFieldGetter();
		Assert.assertEquals(lastNameGetter.get(record), "Bakamović");
	}
}
