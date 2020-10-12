package org.hooah.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Input: list of people with birth/death years
//Output: year with highest population
public class HighestPopulation {
	
	public static void main(String[] args) {
		final Person[] people = {
				new Person(2000,2010),
				new Person(1975,2005),
				new Person(1975,2003),
				new Person(1803,1809),
				new Person(1750,1869),
				new Person(1840,1935),
				new Person(1803,1921),
				new Person(1894,1921)
		};
		
		//Sorted By Death Years
		//1809
		//1869
		//1921
		//1921
		//1935
		//2003
		//2005
		//2010
		
		//Sorted By Birth Years
		//1750:
		//1803:2
		//1803:3
		//1840:3
		//1894: 5 - deaths before 1894
		//1975:4-3=1
		//1975:2-0=2
		//2000:3-0=3
		
		System.out.println("Max pop year:"+getHighestPopulationYear(people));
		
		//	assert isAnagram("star", "rats");
	//	assert !isAnagram("art", "stars");
	}
	
	private static int getHighestPopulationYear(Person[] people){
	sortByBirth(people);
		Arrays.stream(people).forEach(person -> System.out.println(person.birthYear));
		
		int currPop;
		int maxPop=0;
		int rtnYear=people[0].birthYear;
		int currBirthYear;
		final Map<Integer, Integer> populationsByYear= new HashMap<>();
		for(int i = 0,j = i; i < people.length-1;i++, j=i-1) {
			currPop=i+1;
			
			currBirthYear = people[i].birthYear;
			//1894...pop=currPop-(deaths before currBirthYear)
			while(j>0){
				if(people[j].deathYear < currBirthYear){
					currPop--;
				}
				j--;
			}
			if(currPop>maxPop){
				maxPop=currPop;
				rtnYear=currBirthYear;
			}
		 populationsByYear.put(currBirthYear, currPop);
		}
		System.out.println("populationsByYear:"+populationsByYear);
		
		return rtnYear;
	}
	
	private static void sortByBirth(Person[] people){
		for(int i = 0, j = i; i < people.length - 1; j = ++i) {
			Person ai = people[i + 1];
			while(ai.birthYear < people[j].birthYear) {
				people[j + 1] = people[j];
				if(j-- == 0) {
					break;
				}
			}
			people[j + 1] = ai;
		}
	}
	
	private static void sortByDeath(Person[] people){
		for(int i = 0, j = i; i < people.length - 1; j = ++i) {
			Person ai = people[i + 1];
			while(ai.deathYear < people[j].deathYear) {
				people[j + 1] = people[j];
				if(j-- == 0) {
					break;
				}
			}
			people[j + 1] = ai;
		}
	}
	
	static final class Person{
		
		final int birthYear;
		final int deathYear;
		
		Person(int birthYear, int deathYear){
			this.birthYear = birthYear;
			this.deathYear = deathYear;
		}
		
	}
	
}