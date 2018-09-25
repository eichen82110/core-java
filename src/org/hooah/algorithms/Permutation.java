package org.hooah.algorithms;

/**
 * Given List "arrayA" containing integers and an Integer "sumOfTwoInt"
 *
 * Write a method to find two integers from "arrayA" that will equal "sumOfTwoInt" when multiplied together
 *  *Use provided main method to test your method.
 */
public class Permutation {
	
	public static void main(String[] args) {
		System.out.println(isPermutation("cbaef", "bacef"));
		System.out.println(isPermutation("abaef", "bacef"));
		System.out.println(isPermutation("baCef", "bacef"));
		System.out.println(isPermutation("bacef", "cbaef"));
		
		assert isPermutation("cbaef", "bacef");
		assert !isPermutation("abaef", "bacef");
		assert !isPermutation("baCef", "bacef");
		assert isPermutation("bacef", "cbaef");
		
	}
	
	
	private static boolean isPermutation(String a, String b) {
		if(a==null||b==null||a.length()!=b.length()){
			return false;
		}
		char[] arrA = a.toCharArray();
		char[] arrB = b.toCharArray();
		QuickSort.sort(arrA);
		QuickSort.sort(arrB);
		for(int i=0;i<arrA.length-1;i++) {
			if(arrA[i]!=arrB[i]){
				return false;
			}
		}
		return true;
	}
}
