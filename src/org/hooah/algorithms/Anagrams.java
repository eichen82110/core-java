package org.hooah.algorithms;

import java.util.ArrayList;
import java.util.List;

//given a dictionary library and a word
public class Anagrams {
	
	private static final String[] DICTIONARY = {"pos","top","post","stop","pots","tops","spot"};
	public static List<String> findAnagrams(final String origWord){
		final List<String> anagrams = new ArrayList<>();
		final String origSorted = String.valueOf(QuickSort.sort(origWord.toCharArray()));
		for(final String str : DICTIONARY) {
			if(origSorted.equalsIgnoreCase(String.valueOf(QuickSort.sort(str.toCharArray())))){
				anagrams.add(str);
			}
		}
		return anagrams;
	}
}
