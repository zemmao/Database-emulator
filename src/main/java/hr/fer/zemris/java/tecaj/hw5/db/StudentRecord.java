package hr.fer.zemris.java.tecaj.hw5.db;

/**
 * Class is used for saving student's record which is consists of: jmbag, last name, first name 
 * and grade.
 * @author Zemunik
 * @version 1.0
 */
public class StudentRecord {

	/** Student's jmbag*/
	private String jmbag;
	/** Student's last name*/
	private String lastName;
	/** Student's first name*/
	private String firstName;
	/** Student's grade*/
	private int grade;
	
	/**
	 * Constructor that sets class attributes if those are valid.
	 * @param jmbag given jmbag
	 * @param lastName given last name
	 * @param firstName given first name
	 * @param grade given grade
	 */
	public StudentRecord(String jmbag, String lastName, String firstName, int grade){
		if(grade < 1 || grade >5){
			throw new IllegalArgumentException("Grade should be between 1 and 5.");
		}
		checkJmbag(jmbag);
		checkName(lastName);
		checkName(firstName);
		this.jmbag = jmbag;
		this.lastName = lastName;
		this.firstName = firstName;
		this.grade = grade;
	}
	
	/**
	 * Method checks whether jmbag is valid. It should be a number.
	 * @param jmbag given jmbag string
	 */
	private void checkJmbag(String jmbag){
		try{
			Integer.parseInt(jmbag);
		} catch(NumberFormatException e){
			throw new IllegalArgumentException("Jmbag should contain only digits.");
		}
	}
	
	/**
	 * Method checks whether given name is invalid (for example: contains number)
	 * @param receivedName given name
	 */
	private void checkName(String receivedName){
		String name = receivedName;
		char[] nameArray = name.trim().toCharArray();
		if(nameArray.length == 0){
			throw new IllegalArgumentException("Invalid name in data file.");
		}
		
		for(char currentChar: nameArray){
			if(currentChar == '-' || currentChar == ' '){
				continue;
			} else if(Character.isLetter(currentChar)){
				continue;
			} else{
				throw new IllegalArgumentException("Invalid name in data file.");
			}
		}
		if(nameArray[nameArray.length-1] == '-'){
			/*Symbol - is on the last place of name*/
			throw new IllegalArgumentException("Invalid name in data file.");
		}
		
		String[] nameParts = name.split("-");
		for(String part: nameParts){
			if(part.trim().isEmpty()){
				/*Symbol - is on the first place of name or two symobls - appear in a row*/
				throw new IllegalArgumentException("Invalid name in data file.");
			}
		}
	}
	
	/**
	 * Method checks whether two instances of {@link StudentRecord} are same based on hash code.
	 * @return true if two instances are same, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof StudentRecord)){
			return false;
		} else{
			/*Given object is instance of StudentRecord class.*/
			StudentRecord studentRecord = (StudentRecord) obj;
			return this.hashCode() == studentRecord.hashCode();
		}
	}
	
	/**
	 * Method returns hash code of the {@link StudentRecord} instance based on jmbag attribute.
	 * @return hash code of the instance
	 */
	@Override
	public int hashCode() {
		return Integer.parseInt(jmbag);
	}

	/**
	 * Getter for student's jmbag
	 * @return jmbag attribute
	 */
	public String getJmbag() {
		return jmbag;
	}

	/**
	 * Getter for student's last name
	 * @return last name attribute
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter for student's first name
	 * @return first name attribute
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter for student's grade
	 * @return grade attribute
	 */
	public int getGrade() {
		return grade;
	}
}
