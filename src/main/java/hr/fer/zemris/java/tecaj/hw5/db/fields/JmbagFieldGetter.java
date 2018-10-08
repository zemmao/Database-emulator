package hr.fer.zemris.java.tecaj.hw5.db.fields;

import hr.fer.zemris.java.tecaj.hw5.db.StudentRecord;

/**
 * Class is responsible for obtaining jmbag value from {@link StudentRecord}.
 * @author Zemunik
 * @version 1.0
 */
public class JmbagFieldGetter implements IFieldValueGetter{

	@Override
	public String get(StudentRecord record) {
		return record.getJmbag();
	}

}
