package org.hooah.algorithms;

public class LongestCommonSubstring {
	
	public static String longestCommonSubstring(final String str1, final String str2) {
		String lcs;
		if(str1.length() > str2.length()) {
			lcs = getLcs(str1, str2);
		} else {
			lcs = getLcs(str2, str1);
		}
		return lcs;
	}
	
	private static String getLcs(final String str1, final String str2) {
		final StringBuilder subStr = new StringBuilder();
		char[] arrA = str1.toCharArray();
		char[] arrB = str2.toCharArray();
		int bi = 0;
		int currBi = 0;
		for(int ai = 0; ai < arrA.length && currBi < arrB.length; ai++) {
			while(bi < arrB.length) {
				if(arrA[ai] == arrB[bi++]) {
					currBi = bi;
					subStr.append(arrA[ai]);
					break;
				}
			}
			bi = currBi;
			if(bi == arrB.length) {
				break;
			}
		}
		return subStr.toString();
	}
}
