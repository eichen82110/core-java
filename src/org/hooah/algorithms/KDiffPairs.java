package org.hooah.algorithms;

/**
 K Difference
 Given N integers, count the number of pairs of integers whose difference is K
 
 Example:
 
 Input: arr[] = {1, 5, 3, 4, 2}, k = 3
 Output: 2
 There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2}
 
 Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
 Output: 5
 There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8},
 {8, 12}, {12, 16} and {16, 20}
 */
public class KDiffPairs {
	
	
	public static void main(String[] args) {
		int[] a = {8, 12, 16, 4, 0, 20};
		System.out.println(pairsOfDiffK(a,4));
		int[] b = {1, 5, 3, 4, 2};
		System.out.println(pairsOfDiffK(b,3));
	}
	
	private static int pairsOfDiffK(int[] a, final int k) {
	
		int count=0;
		for(int i = 0,j=1; i < a.length-1; j=++i+1) {
			int ai=a[i];
			while(j<=a.length-1){
				int aj=a[j];
				if(ai-aj==k||aj-ai==k){
					count++;
					System.out.println("PAIR:"+ai+","+a[j]);
				}
				j++;
			}
		}
		return count;
	}
}
