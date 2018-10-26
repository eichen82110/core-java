package org.hooah.algorithms;

public class Palindrome {//<< :Left shift of the bits
	
	public static void main(String[] args) {
		assert isPalindrome("madam");
		assert isPalindrome("kayak");
		assert !isPalindrome("peter");
		assert !isPalindrome("ab");
		
		
		assert isPermutationOfPalindrome("tact coa");
		assert isPermutationOfPalindrome("daamm");
		assert isPermutationOfPalindrome("yaakk");
		
		assert isPermutationOfPalindrome("peter cee");
	}
	
	private static boolean isPermutationOfPalindrome(String str) {
		char[] a = str.toCharArray();
		boolean oneUnique = a.length % 2 != 0;
		for(int i = 0, j = 1; j < a.length - 1; j += 2, i += 2) {
			char ai = a[i];
			while(ai != a[j]) {
				if(j++ >= a.length - 1) {
					if(!oneUnique) {
						return false;
					}
					oneUnique = false;
					break;
				}
			}
		}
		return true;
	}
	
	private static boolean isPalindrome(String str) {
		char[] a = str.toCharArray();
		for(int left = 0, right = a.length - 1; left < right; right--, left++) {
			if(a[left] != a[right]) {
				return false;
			}
		}
		return true;
	}
	
}