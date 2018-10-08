package hr.fer.zemris.java.tecaj.hw5.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * Class reads data from the file and creates {@link StudentDatabase} instance from it. Program
 * reads database queries from standard input giving appropriate output to user. Program 
 * ends when users enters: "close". 
 * @author Zemunik
 * @version 1.0
 */
public class StudentDB {

	/**
	 * Method that runs on program start.
	 * @param args command-line arguments
	 * @throws IOException if invalid input is provided
	 */
	public static void main(String[] args) throws IOException {
		
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("./database.txt"),
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("File does not exist.");
			System.exit(-1);
		}
		
		StudentDatabase studentDatabase = null;
		try{
			studentDatabase = new StudentDatabase(lines);
		} catch (IllegalArgumentException e){
			System.err.println(e.getMessage());
			System.err.println("Invalid input data file.");
			System.exit(-1);
		}
		
		/*Read queries from standard input*/
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String inputQuery ="";
       String queryString = "";
       Output output = new Output();
       QueryPreparation queryPreparation = new QueryPreparation();
       
       while(inputQuery != null){
    	   	System.out.print("Enter query: ");
	   	    inputQuery = reader.readLine();
	   	    if(inputQuery.toLowerCase().equals("close")){
	   	    	System.exit(0);
	   	    }
	   	    QueryFilter queryFilter = null;
	   	    try{
	   	    	queryString = queryPreparation.prepareQuery(inputQuery);
	   	    	queryFilter = new QueryFilter(queryString);
	   	    } catch(IllegalArgumentException e){
	   	    	System.out.println("Invalid query string was provided.");
	   	    	continue;
	   	    }
	   	    
	   	    /*Check if query was placed like: query jmbag = "...." and ...*/
	   	    Optional<String> jmbag = queryFilter.getJMBAG();
	   	    if(jmbag.isPresent()){
	   	    	StudentRecord studentRecord = studentDatabase.forJMBAG(jmbag.get());
	   	    	if(studentRecord == null){
	   	    		/*Student record with this jmbag does not exist in the table.*/
	   	    		output.printZeroRecordsSelected();
	   	    		continue;
	   	    	}
	   	    	if(queryFilter.accepts(studentRecord) == true){
	   	    		/*Other expressions in query have been satisfied.*/
	   	    		output.printStudentRecord(studentRecord);
	   	    	} else{
	   	    		/*Other expressions in query have not been satisfied.*/
	   	    		output.printZeroRecordsSelected();
	   	    	}

	   	    } else{
	   	     List<StudentRecord> filterList = studentDatabase.filter(queryFilter);
	   	     output.printListStudentRecords(filterList);
	   	    }
       }

	}
	
}
