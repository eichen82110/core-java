package org.hooah.problems;

import java.util.Arrays;

//Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
//
//If possible, output any possible result.  If not possible, return the empty string.
//
//Example 1:
//
//Input: S = "aab"
//Output: "aba"
//Example 2:
//
//Input: S = "aaab"
//Output: ""
public class ReorganizeString {
	
	public String reorganizeString(String S) {
		int N = S.length();
		int[] counts = new int[26];
		for (char c: S.toCharArray()) counts[c-'a'] += 100;
		for (int i = 0; i < 26; ++i) counts[i] += i;
		//Encoded counts[i] = 100*(actual count) + (i)
		Arrays.sort(counts);
		
		char[] ans = new char[N];
		int t = 1;
		for (int code: counts) {
			int ct = code / 100;
			char ch = (char) ('a' + (code % 100));
			if (ct > (N+1) / 2) return "";
			for (int i = 0; i < ct; ++i) {
				if (t >= N) t = 0;
				ans[t] = ch;
				t += 2;
			}
		}
		
		return String.valueOf(ans);
	}
}