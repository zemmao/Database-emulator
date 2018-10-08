package hr.fer.zemris.java.tecaj.hw5.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class represents database consists of student's records. Records are saved in list and in
 * hash map.
 * @author Zemunik
 * @version 1.0
 */
public class StudentDatabase {

	/** List of student's records*/
	private List<StudentRecord> studentRecordList;
	/** Map that connects jmbag string with record instance.*/
	private Map<String, StudentRecord> index;
	
	/**
	 * Constructor converts input file data to list of {@link StudentRecord} instances. Also, 
	 * it builds map index.
	 * @param definitionsList content of input file data
	 */
	public StudentDatabase(List<String> definitionsList){
		
		studentRecordList = new ArrayList<StudentRecord>();
		index = new HashMap<String, StudentRecord>();
		StudentRecord studentRecord = null;
		for(String definition: definitionsList){
			definition = definition.trim();
			if(definition.isEmpty()){
				continue;
			}
			String[] parameters = definition.split("[\\t]+");
			int paramsLength = parameters.length;
			if(paramsLength != 4){
				throw new IllegalArgumentException("Invalid number of arguments for "
						+ "student's record was provided.");
			}
			
			try{
				int grade = Integer.parseInt(parameters[3].trim());
				studentRecord = new StudentRecord(parameters[0].trim(), parameters[1].trim(), 
						parameters[2].trim(), grade);
				studentRecordList.add(studentRecord);
				index.put(parameters[0], studentRecord);
			} catch(Exception e){
				System.err.println(e.getMessage());
				throw new IllegalArgumentException("Invalid arguments in input data were provided.");
			}
		}
		
	}
	
	/**
	 * Method returns {@link StudentRecord} instance from given jmbag.
	 * @param jmbag given jmbag
	 * @return {@link StudentRecord} instance
	 */
	public StudentRecord forJMBAG(String jmbag){
		return index.get(jmbag);
	}
	
	/**
	 * Method loops through all student's records in internal list and returns 
	 * {@link StudentRecord} instances that satisfy given query.
	 * @param filter given query
	 * @return list of student's records that satisfy the query
	 */
	public List<StudentRecord> filter(IFilter filter){
		
		List<StudentRecord> returnList = new ArrayList<StudentRecord>();
		boolean filterResponse;
		for(StudentRecord record: studentRecordList){
			filterResponse = filter.accepts(record);
			if(filterResponse == true){
				returnList.add(record);
			}
		}
		return returnList;
	}
}
