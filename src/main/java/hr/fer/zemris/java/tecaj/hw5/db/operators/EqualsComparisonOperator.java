package hr.fer.zemris.java.tecaj.hw5.db.operators;

/**
 * Class is responsible for implementing equal to comparison operator.
 * @author Zemunik
 * @version 1.0
 */
public class EqualsComparisonOperator implements IComparisonOperator{

	@Override
	public boolean satisfied(String value1, String value2) {
		
		if(value2.contains("*")){
			String firstString = value1;
			String secondString = value2;
			return compareTwoStrings(firstString, secondString);
		} else{
			return value1.equals(value2);
		}
			
	}
	
	/**
	 * Method compares if two string have same prefixes/suffixes.
	 * @param firstString first string in comparison
	 * @param secondString second string in comparison
	 * @return true if string are the same, false otherwise
	 */
	private boolean compareTwoStrings(String firstString, String secondString){
		
		String[] secondStringParts = secondString.split("[*]");
		if(secondStringParts.length == 0){
			/*Symbol * is the only symbol in secondString*/
			return true;
		} else if(secondStringParts.length == 1){
			/*Symbol * is at the end of secondString*/
			if(firstString.startsWith(secondStringParts[0])){
				return true;
			} else{
				return false;
			}
		} else if(secondStringParts[0].isEmpty()){
			/*Symbol * is at the beginning of secondString*/
			if(firstString.endsWith(secondStringParts[1])){
				return true;
			} else{
				return false;
			}
		} else{
			/*Symbol * is in the middle of secondString*/
			if(firstString.startsWith(secondStringParts[0])){
				int prefixLength = secondStringParts[0].length();
				/*Cut the prefix of firstString*/
				firstString = firstString.substring(prefixLength);
				
				if(firstString.endsWith(secondStringParts[1])){
					return true;
				} else{
					return false;
				}
			} else{
				return false;
			}
		}
		
	}

}
