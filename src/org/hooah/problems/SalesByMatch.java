package org.hooah.problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * Alex works at a clothing store. There is a large pile of socks that must be paired by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 *
 * For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
 *
 * sockMerchant has the following parameter(s):
 *
 * n: the number of socks in the pile
 * ar: the colors of each sock
 */
public class SalesByMatch {
	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		Set<Integer> colors = new HashSet<>();
		int pairs = 0;
		
		for (int i = 0; i < n; i++) {
			if (!colors.contains(ar[i])) {
				colors.add(ar[i]);
			} else {
				pairs++;
				colors.remove(ar[i]);
			}
		}
		return pairs;
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//9
		//10 20 20 10 10 30 50 10 20
		//output should be 3
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		int[] ar = new int[n];
		
		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}
		
		int result = sockMerchant(n, ar);
		
		System.out.println(result);
		
		scanner.close();
	}
}
