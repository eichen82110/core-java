package org.hooah.problems;

import java.util.HashSet;
import java.util.Set;

//Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
public class LongestSubstringAtMost2Chars {
	
	public int longestSubstring(String s){
		if(s==null){
			return 0;
		}
		Set<Character> set = new HashSet<>();
		char[] arr = s.toCharArray();
		int ans=0;
		int count;
		int distinctCount;
		for(int i=0;i<s.length();i++) {
			count=0;
			distinctCount=0;
			for(int j=i;j<s.length();j++) {
				if(set.contains(arr[j])) {
					set.add(arr[j]);
				}else if(distinctCount==2){
					set.clear();
					break;
				}else{
					distinctCount++;
					set.add(arr[j]);
				}
				count++;
			}
			if(count > ans) {
				ans = count;
			}
		}
		
		return ans;
	}
	public static void main(String[] args){
		LongestSubstringAtMost2Chars lswrc = new LongestSubstringAtMost2Chars();
		
		System.out.println(lswrc.longestSubstring("eceba"));
		System.out.println(lswrc.longestSubstring("ccaabbb"));
		
	}
	
}
