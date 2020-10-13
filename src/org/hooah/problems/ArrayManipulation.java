package org.hooah.problems;

//Starting with a 1-indexed array of zeros and a list of operations,
// for each operation add a value to each of the array element between two given indices,
// inclusive.
// Once all operations have been performed, return the maximum value in the array.
//int n - the number of elements in the array
//int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
//    a b k
//    1 5 3
//    4 8 7
//    6 9 1

//ex: n=10, queries=[[1,5,3],[4,8,7],[6,9,1]]
//largest value is 10
import java.util.Scanner;

public class ArrayManipulation {
	
	
	public static void main(String[] args) {
		//5 3
		//1 2 100
		//2 5 100
		//3 4 100
		//out=200
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		/* Save interval endpoint's "k" values in array */
		long [] array = new long[N + 1];
		while (M-- > 0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int k = scan.nextInt();
			array[a-1] += k;
			array[b]   -= k;
		}
		scan.close();

		/* Find max value */
		long sum = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			sum += array[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
