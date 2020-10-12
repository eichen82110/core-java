package org.hooah.problems.nearestneighbor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NearestNeighbor {
	
	private static final List<Person> PEOPLE = generatePeople(new ArrayList<>());

	
	private static List<Person> generatePeople(final List<Person> arr){
		final String[] names = {"a","b","c","d","e","f","g","h","i","j"};
		for(int i = 0; i < names.length; i++) {
			arr.add(new Person(names[i].toUpperCase(), i));
		}
		Collections.sort(arr);
		return arr;
	}
	
	public List<Person> getPeople() {
		return PEOPLE;
	}
	
}
