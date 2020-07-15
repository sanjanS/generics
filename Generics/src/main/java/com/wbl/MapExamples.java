package com.wbl;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used String and Person as generic type to insert into map.
 */
public class MapExamples {

	public Map<String, Person> addPersonAskeyValue(final Person[] people) {
		Map<String, Person> personMap = new HashMap<>();
		for (Person person : people) {
			personMap.put(person.getName(), person);
		}
		return personMap;
	}

}
