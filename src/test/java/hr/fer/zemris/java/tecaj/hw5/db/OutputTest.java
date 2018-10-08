package hr.fer.zemris.java.tecaj.hw5.db;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class is used for testing {@link Output} class. Coverage is 100%.
 * @author Zemunik
 * @version 1.0
 */
public class OutputTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void printZeroRecordsSelected_ShouldPrintOnScreen(){
		Output output = new Output();
		output.printZeroRecordsSelected();
		String actual = "Records selected: 0";
		String received = outContent.toString();
		received = received.substring(0, received.length()-2);
		Assert.assertEquals(actual, received);
	}
	
	@Test
	public void printStudentRecord_StudentRecordGiven_ShouldPrintOnScreen(){
		StudentRecord record = new StudentRecord("0000000001", "Akšamović",
				"Marin", 2);
		Output output = new Output();
		output.printStudentRecord(record);
		String received = outContent.toString();
		String actual = "Using index for record retrieval.\r\n"
				+ "+============+===========+=======+===+\r\n"
				+ "|0000000001  |Akšamović  |Marin  |2  |\r\n"
				+ "+============+===========+=======+===+\r\n"
				+ "Records selected: 1";
		received = received.substring(0, received.length()-2);
		Assert.assertEquals(actual, received);
	}
	
	@Test
	public void printListStudentRecords_ListOfStudentRecordsGiven_ShouldPrintOnScreen(){
		StudentRecord firstRecord = new StudentRecord("0000000001", "Akšamović",
				"Marin", 2);
		StudentRecord secondRecord = new StudentRecord("0000000002", "Bakamović",
				"Petra", 3);
		List<StudentRecord> list = new ArrayList<StudentRecord>();
		list.add(firstRecord);
		list.add(secondRecord);
		Output output = new Output();
		output.printListStudentRecords(list);
		String received = outContent.toString();
		String actual = "+============+===========+=======+===+\r\n"
				+ "|0000000001  |Akšamović  |Marin  |2  |\r\n"
				+ "|0000000002  |Bakamović  |Petra  |3  |\r\n"
				+ "+============+===========+=======+===+\r\n"
				+ "Records selected: 2";
		received = received.substring(0, received.length()-2);
		Assert.assertEquals(actual, received);
	}
	
	@Test
	public void printListStudentRecords_EmptyListGiven_ShouldPrintMessageOnScreen(){
		List<StudentRecord> list = new ArrayList<StudentRecord>();
		Output output = new Output();
		output.printListStudentRecords(list);
		String received = outContent.toString();
		received = received.substring(0, received.length()-2);
		String actual = "Records selected: 0";
		Assert.assertEquals(actual, received);
	}
}
