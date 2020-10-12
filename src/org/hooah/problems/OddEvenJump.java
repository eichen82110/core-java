package org.hooah.problems;

import java.util.TreeMap;

/**
 * You are given an integer array A.  From some starting index, you can make a series of jumps.  The (1st, 3rd, 5th, ...) jumps in the series are called odd numbered jumps,
 * and the (2nd, 4th, 6th, ...) jumps in the series are called even numbered jumps.
 *
 * You may from index i jump forward to index j (with i < j) in the following way:
 *
 * During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is the smallest possible value.
 * If there are multiple such indexes j, you can only jump to the smallest such index j.
 * During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is the largest possible value.
 * If there are multiple such indexes j, you can only jump to the smallest such index j.
 * (It may be the case that for some index i, there are no legal jumps.)
 * A starting index is good if, starting from that index, you can reach the end of the array (index A.length - 1) by jumping some number of times (possibly 0 or more than once.)
 *
 * Return the number of good starting indexes.
 */
public class OddEvenJump {
	
	/**
	 *       Algorithm
	 *
	 * We can use a TreeMap, which is an excellent structure for maintaining sorted data. Our map vals will map values v = A[i] to indices i.
	 *
	 * Iterating from i = N-2 to i = 0, we have some value v = A[i] and we want to know what the next largest or next smallest value is.
	 * The TreeMap.lowerKey and TreeMap.higherKey functions do this for us.
	 *
	 * With this in mind, the rest of the solution is straightforward: we use dynamic programming to maintain odd[i] and even[i]:
	 * whether the state of being at index i on an odd or even numbered jump is possible to reach.
	 * @param A
	 * @return
	 */
	public static int oddEvenJumps(int[] A) {
		int N = A.length;
		if (N <= 1){
			return N;
		}
		boolean[] odd = new boolean[N];
		boolean[] even = new boolean[N];
		odd[N-1] = even[N-1] = true;
		
		TreeMap<Integer, Integer> vals = new TreeMap<>();
		vals.put(A[N-1], N-1);
		for (int i = N-2; i >= 0; --i) {
			int v = A[i];
			if (vals.containsKey(v)) {
				odd[i] = even[vals.get(v)];
				even[i] = odd[vals.get(v)];
			} else {
				Integer lower = vals.lowerKey(v);
				Integer higher = vals.higherKey(v);
				
				if (lower != null)
					even[i] = odd[vals.get(lower)];
				if (higher != null) {
					odd[i] = even[vals.get(higher)];
				}
			}
			vals.put(v, i);
		}
		
		int ans = 0;
		for (boolean b: odd){
			if (b) ans++;
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		final int[] arr = {10,13,12,14,15};//should output 2
		System.out.println(oddEvenJumps(arr));
		
		final int[] arr2 = {2,3,1,1,4};//should output 3
		System.out.println(oddEvenJumps(arr2));
	}
	
}
