package hr.fer.zemris.java.tecaj.hw5.db.fields;

import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;

import org.junit.Assert;
import org.junit.Test;

public class JmbagFieldGetterTest {

	@Test
	public void get_ValidStudentRecordGiven_JmbagExpected(){
		StudentRecord record = new StudentRecord("0000000002", "Bakamović", 
				"Petra", 3);
		JmbagFieldGetter jmbagNameGetter = new JmbagFieldGetter();
		Assert.assertEquals(jmbagNameGetter.get(record), "0000000002");
	}
}
