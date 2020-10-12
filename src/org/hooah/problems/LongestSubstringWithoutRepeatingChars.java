package org.hooah.problems;

import java.util.HashSet;
import java.util.Set;

//Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubstringWithoutRepeatingChars {
	
	public int longestSubstring(String s){
		if(s==null){
			return 0;
		}
		Set<Character> set = new HashSet<>();
		char[] arr = s.toCharArray();
		int ans=0;
		int count;
		for(int i=0;i<s.length();i++) {
			count=0;
			for(int j=i;j<s.length();j++) {
				if(set.contains(arr[j])) {
					set.clear();
					break;
				}
				set.add(arr[j]);
				count++;
			}
			if(count > ans) {
				ans = count;
			}
		}
		
		return ans;
	}
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingChars lswrc = new LongestSubstringWithoutRepeatingChars();
		
		System.out.println(lswrc.longestSubstring("abcabcbb"));
		System.out.println(lswrc.longestSubstring("bbbbb"));
		System.out.println(lswrc.longestSubstring("pwwkew"));
		System.out.println(lswrc.longestSubstring(""));
		System.out.println(lswrc.longestSubstring(" "));
		System.out.println(lswrc.longestSubstring("au"));
		System.out.println(lswrc.longestSubstring("dvdf"));
		
	}
	
}
