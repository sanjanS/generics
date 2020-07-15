package com.wbl;

import java.util.Objects;

/**
 * This is a pojo java class which takes name and age as data members in it.
 */
public class Person {

	private transient String name;
	private transient int age;

	public Person() {
		// This constructor is intentionally empty. Nothing special is needed here.
	}

	public Person(String name, int age) {
		Objects.requireNonNull(name);
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Person) {
			Person p1 = (Person) obj;
			return (this.name.equals(p1.name) && this.age == p1.age);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}
