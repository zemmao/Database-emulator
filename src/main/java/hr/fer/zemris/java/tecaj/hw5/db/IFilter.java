package hr.fer.zemris.java.tecaj.hw5.db;

/**
 * Interface that is used for creating new filter for query string.
 * @author Zemunik
 * @version 1.0
 */
public interface IFilter {

	/**
	 * Method checks whether given student record satisfies input query.
	 * @param record given student record
	 * @return true if given record satisfies query, false otherwise
	 */
	public boolean accepts(StudentRecord record);
}
