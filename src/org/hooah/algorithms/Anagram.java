package org.hooah.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Input: list of words
//Output: Words grouped together as anagrams
public class Anagram {
	
	public static void main(String[] args) {
		final String[] words = {"CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
				"PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
				"SUED", "LEAN", "SCAR", "DESIGN"};
		final String[] words1 = {"star","rats","car","arc","arts","stars"};//given
		final String[] words2 = {"star","rats","car","tars", "arc","arts","stars"};//given
		final String[] words3 = {"star","rats","car","tars", "arc","checker","stars","recheck"};//given
		System.out.println("Grouped Anagrams:"+groupAnagrams(words));
		System.out.println("Grouped Anagrams:"+groupAnagrams(words1));
		System.out.println("Grouped Anagrams:"+groupAnagrams(words2));
		System.out.println("Grouped Anagrams:"+groupAnagrams(words3));
		
		//	assert isAnagram("star", "rats");
	//	assert !isAnagram("art", "stars");
	}
	
	private static List<List<String>> groupAnagrams(final String[] words){
		
		final List<String> list = Arrays.stream(words)//create a list of words sorted like so:  [arst, arst, acr, acr, arst, arsst]
				.map(s ->  Stream.of(s.split(""))
						.sorted()
						.collect(Collectors.joining()))
				.collect(Collectors.toList());
//		System.out.println("SORTED:"+list);
		
		
		final Map<String, List<Integer>> map = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
			map.putIfAbsent(list.get(i), new ArrayList<>());//create new key if doesnt exist
			map.get(list.get(i)).add(i);//get list and add current index
		}
		
		final List<List<String>> rtnList = new ArrayList<>();
		for(List<Integer> indexes : map.values()) {
			final List<String> anagrams = new ArrayList<>();
			for(int i : indexes) {
				anagrams.add(words[i]);
			}
			rtnList.add(anagrams);
		}
		return rtnList;
	}
	
	
	
}