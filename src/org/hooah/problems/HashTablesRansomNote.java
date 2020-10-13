package org.hooah.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.
//
//Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
//
//For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". The magazine has all the right words, but there's a case mismatch. The answer is No.
//
//Function Description
//
//Complete the checkMagazine function in the editor below. It must print Yes if the note can be formed using the magazine, or No.
//
//checkMagazine has the following parameters:
//
//magazine: an array of strings, each a word in the magazine
//note: an array of strings, each a word in the ransom note
public class HashTablesRansomNote {
	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		if(note==null||magazine==null||note.length>magazine.length){
			System.out.println("No");
			return;
		}
		HashMap<String,Integer> hm = new HashMap<>();
		for(String s : magazine) {
			if(hm.containsKey(s)) {
				hm.put(s, hm.get(s) + 1);
			} else {
				hm.put(s, 1);
			}
		}
		
		boolean check=false;
		for(String s : note) {
			if(!hm.containsKey(s)){
				check = true;
			} else {
				if(hm.get(s) > 1){
					hm.put(s, hm.get(s) - 1);
				}
				else {
					hm.remove(s);
				}
			}
		}
		if(!check) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	
	static boolean checkWords(String[] mags, String[] note) {
		
		Arrays.sort(mags);
		Arrays.sort(note);
		
		List<String> magList = new ArrayList<>(Arrays.asList(mags));
		
		for(final String word : note) {
			if (!magList.remove(word)){
				return false;
			}
		}
		return true;
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");
		
		int m = Integer.parseInt(mn[0]);
		
		int n = Integer.parseInt(mn[1]);
		
		String[] magazine = new String[m];
		
		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}
		
		String[] note = new String[n];
		
		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}
		
		checkMagazine(magazine, note);
		
		scanner.close();
	}
	
}
