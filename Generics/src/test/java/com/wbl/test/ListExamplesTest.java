package com.wbl.test;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wbl.ListExamples;
import com.wbl.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test class is used to test functions of ListExamples class.
 */
public class ListExamplesTest {

	private static ListExamples listExamples;

	private static final Person DON_DRAPER = new Person("Don Draper", 89);
	private static final Person PEGGY_OLSON = new Person("Peggy Olson", 65);

	@BeforeTest
	public void init() {
		listExamples = new ListExamples();
	}

	@Test
	public void testListOfPerson() {
		Person[] people = { DON_DRAPER, PEGGY_OLSON };
		assertThat(listExamples.addPerson(people)).containsExactly(DON_DRAPER, PEGGY_OLSON);
	}

	@Test
	public void queryForSize() {
		Person[] people = { DON_DRAPER, PEGGY_OLSON };
		assertThat(listExamples.addPerson(people).size()).isEqualTo(2);
	}

	@Test
	public void shouldGetOnePerson() {
		Person[] people = { DON_DRAPER, PEGGY_OLSON };
		assertThat(listExamples.addPerson(people).get(0)).isEqualTo(DON_DRAPER);
	}

	@Test
	public void retrivePersonsUsingIterator() {
		Person[] people = { DON_DRAPER, PEGGY_OLSON };
		int readPerson = 0;
		Iterator<Person> personIterator = listExamples.addPerson(people).iterator();
		while (personIterator.hasNext()) {
			final Person person = personIterator.next();
			assertThat(person).isEqualTo(people[readPerson]);
			readPerson++;
		}
	}

	@Test
	public void retrivePersonByIndex() {
		Person[] people = { DON_DRAPER, PEGGY_OLSON };
		List<Person> personList = listExamples.addPerson(people);
		for (int i = 0; i < personList.size(); i++) {
			assertThat(personList.get(i)).isEqualTo(people[i]);
		}
	}

	@Test
	public void retrivePersonUsingForEach() {
		Person[] people = { DON_DRAPER, PEGGY_OLSON };
		int readPerson = 0;
		List<Person> personList = listExamples.addPerson(people);
		for (Person person : personList) {
			assertThat(person).isEqualTo(people[readPerson]);
			readPerson++;
		}
	}
}
