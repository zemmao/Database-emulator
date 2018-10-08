package hr.fer.zemris.java.tecaj.hw5.db.fields;

import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;

/**
 * Strategy interface which is responsible for obtaining a requested field value from 
 * {@link StudentRecord}.
 * @author Zemunik
 * @version 1.0
 */
public interface IFieldValueGetter {

	/**
	 * Method returns a requested field value from {@link StudentRecord} instance.
	 * @param record given {@link StudentRecord} instance
	 * @return requested field value
	 */
	public String get(StudentRecord record);
}
