package org.hooah.algorithms;

/**
 * Given List "arrayA" containing integers and an Integer "sumOfTwoInt"
 *
 * Write a method to find two integers from "arrayA" that will equal "sumOfTwoInt" when multiplied together
 * *Use provided main method to test your method.
 */
public class QuickSort {
	
	//<< :Left shift of the bits
	private static final int NUM_CHAR_VALUES = 1 << 16;//65536
	String[] strings = {"bdksa", "alvkhd", "asdfavu", "acdsf", "nsdvfj"};
	
	public static void main(String[] args) {
		
		System.out.println('F'+'F');
		System.out.println(f(4));
		System.out.println(isPalindrome("madam"));
		System.out.println(isPalindrome("kayak"));
		System.out.println(isPalindrome("peter"));
		System.out.println(isPalindrome("ab"));
		
		
		System.out.println("TRUE:" + isPermutationOfPalindrome("tact coa"));
		System.out.println("TRUE:" + isPermutationOfPalindrome("daamm"));
		System.out.println("TRUE:" + isPermutationOfPalindrome("yaakk"));
		
		System.out.println("FALSE:" + isPermutationOfPalindrome("peter cee"));
		
		
		char space = ' ';
		//System.out.println(sort("lbjedsfgsgsdbawz".toCharArray()));
		//	System.out.println(sort("abcdefghijklmnop".toCharArray()));
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
	
	
	static int f(int n) {
		System.out.println("n:" + n);
		if(n <= 1) {
			return 1;
		}
		return f(n - 1) + f(n - 1);
	}
	
	/**
	 * O(n log n) sorting
	 */
	static char[] sort(char[] a) {
		if(a.length > 3200) {
			return countingSort(a);
		}
		for(int i = 0, j = i; i < a.length - 1; j = ++i) {
			char ai = a[i + 1];
			while(ai < a[j]) {
				a[j + 1] = a[j];
				if(j-- == 0) {
					break;
				}
			}
			a[j + 1] = ai;
		}
		return a;
	}
	
	private static char[] countingSort(char[] array) {
		int[] count = new int[NUM_CHAR_VALUES];
		
		for(int i = -1; ++i <= array.length - 1; count[array[i]]++) { ; }
		for(int i = NUM_CHAR_VALUES, k = array.length + 1; k > 0; ) {
			while(count[--i] == 0) { ; }
			char value = (char) i;
			int s = count[i];
			
			do {
				array[--k] = value;
			} while(--s > 0);
		}
		return array;
	}
}
