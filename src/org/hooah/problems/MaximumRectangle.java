package org.hooah.problems;

import java.util.Arrays;

//Given a rows x cols binary matrix filled with 0's and 1's,
//find the largest rectangle containing only 1's and return its area.
public class MaximumRectangle {
	
	//Given row matrix[i], we keep track of the h, l, and r of each point in the row by defining three arrays - height, left, and right.
	//
	//height[j] will correspond to the height of matrix[i][j], and so on and so forth with the other arrays.
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];
		
		Arrays.fill(right, n);
		
		int maxarea = 0;
		for(int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;
			// update height
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == '1') height[j]++;
				else height[j] = 0;
			}
			for(int j=0; j<n; j++) {
				if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
				else {left[j]=0; cur_left=j+1;}
			}
			for(int j = n - 1; j >= 0; j--) {
				if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
				else {right[j] = n; cur_right = j;}
			}
			for(int j = 0; j < n; j++) {
				maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
			}
		}
		return maxarea;
	}
}
