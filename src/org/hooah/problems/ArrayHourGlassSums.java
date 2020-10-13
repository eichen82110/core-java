package org.hooah.problems;

import java.util.Scanner;

/**
 * Given a  6x6 2D Array, :
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * An hourglass in A  is a subset of values with indices falling in this pattern in arr's graphical representation:
 *
 * a b c
 *   d
 * e f g
 * There are 16 hourglasses in arr.
 * An hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in ,
 * then print the maximum hourglass sum. The array will always be 6x6.
 *
 * Example
 *
 *
 * -9 -9 -9  1 1 1
 *  0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 *  0  0  8  6 6 0
 *  0  0  0 -2 0 0
 *  0  0  1  2 4 0
 * The 16 hourglass sums are:
 *
 * -63, -34, -9, 12,
 * -10,   0, 28, 23,
 * -27, -11, -2, 10,
 *   9,  17, 25, 18
 * The highest hourglass sum is 28 from the hourglass beginning at row 1, column 2:
 *
 * 0 4 3
 *   1
 * 8 6 6
 *
 * Function Description
 *
 * Complete the function hourglassSum in the editor below.
 *
 * hourglassSum has the following parameter(s):
 *
 * int arr[6][6]: an array of integers
 * Returns
 *
 * int: the maximum hourglass sum
 */
public class ArrayHourGlassSums {
	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		// we could set this to 3 given the problems constraints, but this allows changes
		int maxX = 3; // + (arr[0].length % 3)
		int maxY = 3; // + (arr.length % 3)
		int total = -64;  // has to be -64, but
		
		// begin at y == 0
		for(int y = 0; y <= maxY; y++) {
			for(int x = 0; x <= maxX; x++) {
				// sum the top of hourglass
				int sum = arr[y][x] + arr[y][x + 1] + arr[y][x + 2];
				
				// get the middle of hourglass
				sum += arr[y + 1][x + 1];
				
				// sum the bottom of hourglass
				sum += arr[y + 2][x] + arr[y + 2][x + 1] + arr[y + 2][x + 2];
				
				// don't store result to keep space complexity down
				if(total < sum){
					total = sum;
				}
			}
		}
		
		return total;
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//1 1 1 0 0 0
		//0 1 0 0 0 0
		//1 1 1 0 0 0
		//0 0 2 4 4 0
		//0 0 0 2 0 0
		//0 0 1 2 4 0
		
		//out=19
		int[][] arr = new int[6][6];
		
		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		
		int result = hourglassSum(arr);
		
		System.out.println(result);
		scanner.close();
	}
}
