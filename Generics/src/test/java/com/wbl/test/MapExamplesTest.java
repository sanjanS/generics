package com.wbl.test;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wbl.MapExamples;
import com.wbl.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

/**
	 * This test class is used to
	 * test functions of MapExamples class.
	 */
	public class MapExamplesTest {

	    private static MapExamples mapExamples;

	    private static final Person DON_DRAPER  = new Person("Don Draper", 89);
	    private static final Person PEGGY_OLSON = new Person("Peggy Olson", 65);
	    private static final Person BERT_COOPER = new Person("Bert Cooper", 100);

	    @BeforeTest
	    public void init() {
	        mapExamples = new MapExamples();
	    }

	    @Test
	    public void addPerson() {
	        Person[] people = {DON_DRAPER, PEGGY_OLSON, BERT_COOPER};
	        Map<String, Person> stringPersonMap = mapExamples.addPersonAskeyValue(people);
	        assertThat(stringPersonMap).
	                containsOnly(entry(DON_DRAPER.getName(), DON_DRAPER),
	                        entry(PEGGY_OLSON.getName(), PEGGY_OLSON), entry(BERT_COOPER.getName(), BERT_COOPER));
	    }

	    @Test
	    public void testPersonByName() {
	        Person[] people = {DON_DRAPER, PEGGY_OLSON, BERT_COOPER};
	        Map<String, Person> stringPersonMap = mapExamples.addPersonAskeyValue(people);
	        assertThat(stringPersonMap.get(DON_DRAPER.getName())).isEqualTo(DON_DRAPER);
	    }

	    @Test
	    public void testListOfNames() {
	        Person[] people = {DON_DRAPER, PEGGY_OLSON, BERT_COOPER};
	        Map<String, Person> stringPersonMap = mapExamples.addPersonAskeyValue(people);
	        assertThat(stringPersonMap.keySet()).
	                containsExactlyInAnyOrder(DON_DRAPER.getName(), PEGGY_OLSON.getName(), BERT_COOPER.getName());
	    }

	    @Test
	    public void testListOfValues() {
	        Person[] people = {DON_DRAPER, PEGGY_OLSON, BERT_COOPER};
	        Map<String, Person> stringPersonMap = mapExamples.addPersonAskeyValue(people);
	        assertThat(stringPersonMap.values()).containsExactlyInAnyOrder(DON_DRAPER, PEGGY_OLSON, BERT_COOPER);
	    }

}
