package org.hooah.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Given List "arrayA" containing integers and an Integer "sumOfTwoInt"
 *
 * Write a method to find two integers from "arrayA" that will equal "sumOfTwoInt" when multiplied together
 *  *Use provided main method to test your method.
 */
public class FindTwoIntegers {
	
	
	public static void main(String[] args) {
		findTwoInts(Arrays.asList(2,3,10,6,5,40,-1,2),20);
		findTwoInts(Arrays.asList(2,4,1,6,5,40,-1),20);
		findTwoInts(Arrays.asList(2,4,1,6,5,40,-1),10);
	}
	
	
	private static void findTwoInts(final List<Integer> list, final int num) {
		int a;
		int b;
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = list.size() - 1; j > 0; j--) {
				
				a = list.get(i);
				b = list.get(j);
				if(a * b == num) {
					System.out.println("twoINTS: " + a + "," + b);
					return;
				}
			}
		}
		System.out.println("No pairs found.");
	}
}
