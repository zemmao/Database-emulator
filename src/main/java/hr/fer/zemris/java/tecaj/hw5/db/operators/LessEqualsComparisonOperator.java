package hr.fer.zemris.java.tecaj.hw5.db.operators;

import java.text.Normalizer;

/**
 * Class is responsible for implementing less than or equal to comparison operator.
 * @author Zemunik
 * @version 1.0
 */
public class LessEqualsComparisonOperator implements IComparisonOperator{

	@Override
	public boolean satisfied(String value1, String value2) {
		int compareNumber = Normalizer.normalize(value1, Normalizer.Form.NFD).
				compareTo(Normalizer.normalize(value2,Normalizer.Form.NFD));
		if(compareNumber <= 0){
			return true;
		} else{
			return false;
		}
	}

}
