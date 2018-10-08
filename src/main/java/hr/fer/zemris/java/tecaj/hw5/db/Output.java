package hr.fer.zemris.java.tecaj.hw5.db;

import java.util.List;

/**
 * Class is used for printing results of the query on standard output.
 * @author Zemunik
 * @version 1.0
 */
public class Output {

	/**
	 * Method prints message if result of the query is zero entries.
	 */
	public void printZeroRecordsSelected(){
		System.out.println("Records selected: 0");
	}
	
	/**
	 * Method prints given student record in the table.
	 * @param studentRecord given student record
	 */
	public void printStudentRecord(StudentRecord studentRecord){
		System.out.println("Using index for record retrieval.");
		int jmbagLength = studentRecord.getJmbag().length();
		int lastNameLength = studentRecord.getLastName().length();
		int firstNameLength = studentRecord.getFirstName().length();
		jmbagLength = jmbagLength + 2;
		lastNameLength = lastNameLength + 2;
		firstNameLength = firstNameLength + 2;
		printTableLimit(jmbagLength, lastNameLength, firstNameLength);
		
		String jmbagFormat = "|%-" + jmbagLength + "s|";
		String lastNameFormat = "%-" + lastNameLength + "s|";
		String firstNameFormat = "%-" + firstNameLength + "s|";
		String gradeFormat = "%-" + 3 + "s|";
		System.out.format(jmbagFormat, studentRecord.getJmbag());
		System.out.format(lastNameFormat, studentRecord.getLastName());
		System.out.format(firstNameFormat, studentRecord.getFirstName());
		System.out.format(gradeFormat, studentRecord.getGrade());
		System.out.println();
		printTableLimit(jmbagLength, lastNameLength, firstNameLength);
		System.out.println("Records selected: 1");
		
	}
	
	/**
	 * Method prints table limit before/after printing content of the table.
	 * @param jmbagLength length of the longest jmbag in the table 
	 * @param lastNameLength length of the longest last name in the table
	 * @param firstNameLength length of the longest first name in the table
	 */
	private void printTableLimit(int jmbagLength, int lastNameLength, int firstNameLength){
		System.out.print("+");
		for(int i = 0; i < jmbagLength; i++){
			System.out.print("=");
		}
		System.out.print("+");
		for(int i = 0;i < lastNameLength; i++){
			System.out.print("=");
		}
		System.out.print("+");
		for(int i = 0;i < firstNameLength; i++){
			System.out.print("=");
		}
		System.out.print("+");
		for(int i = 0;i < 3; i++){
			System.out.print("=");
		}
		System.out.print("+");
		System.out.println();
	}
	
	/**
	 * Method prints given list of student's records in the table.
	 * @param filterList given list of student's records
	 */
	public void printListStudentRecords(List<StudentRecord> filterList){
		
		if(filterList.size() == 0){
			System.out.println("Records selected: 0");
			return;
		}
		int maxJmbagLen = 0, maxLastNameLen = 0, maxFirstNameLen = 0;
		int tempLength = 0;
		for(StudentRecord record: filterList){
			tempLength = record.getJmbag().length(); 
			if(tempLength > maxJmbagLen){
				maxJmbagLen = tempLength;
			}
			tempLength = record.getLastName().length();
			if(tempLength > maxLastNameLen){
				maxLastNameLen = tempLength;
			}
			tempLength = record.getFirstName().length();
			if(tempLength > maxFirstNameLen){
				maxFirstNameLen = tempLength;
			}
		}
		
		maxJmbagLen = maxJmbagLen + 2;
		maxLastNameLen = maxLastNameLen + 2;
		maxFirstNameLen = maxFirstNameLen + 2;
		
		printTableLimit(maxJmbagLen, maxLastNameLen, maxFirstNameLen);
		String jmbagFormat = "|%-" + maxJmbagLen + "s|";
		String lastNameFormat = "%-" + maxLastNameLen + "s|";
		String firstNameFormat = "%-" + maxFirstNameLen + "s|";
		String gradeFormat = "%-" + 3 + "s|";
		
		for(StudentRecord record: filterList){
			System.out.format(jmbagFormat, record.getJmbag());
			System.out.format(lastNameFormat, record.getLastName());
			System.out.format(firstNameFormat, record.getFirstName());
			System.out.format(gradeFormat, record.getGrade());
			System.out.println();
		}
		
		printTableLimit(maxJmbagLen, maxLastNameLen, maxFirstNameLen);
		System.out.println("Records selected: " + filterList.size());
	}
	
}
