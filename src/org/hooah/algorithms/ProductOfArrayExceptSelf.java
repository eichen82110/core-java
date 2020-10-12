package org.hooah.algorithms;

import java.util.Arrays;

//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Example:
//
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
public class ProductOfArrayExceptSelf {
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4};
		System.out.println("OUTPUT:"+ Arrays.toString(productExceptSelf(nums)));
		
	}
	
	private static int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		int pNums = 1;
		for(int num:nums){
			pNums = pNums*num;
		}
		for(int i=0;i< nums.length;i++){
			output[i] = pNums/nums[i];
		}
		return output;
	}
	
}
