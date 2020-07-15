package com.wbl;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is taking person as generic type to insert into list.
 */
public class ListExamples {
	public List<Person> addPerson(final Person[] person) {
		List<Person> madMen = new ArrayList<>();
		for (Person people : person) {
			madMen.add(people);
		}
		return madMen;
	}
}
