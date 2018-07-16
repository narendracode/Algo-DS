package com.algo.dailyproblems;

/*
	Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
	For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
	Follow-up: what if you can't use division?
 */


public class Problem2 {

	public static void main(String[] args) {
		int[] inputArr = {1, 2, 3, 4, 5};
		int[] output = process(inputArr);
		for (int i : output) {
			System.out.println(i);
		}
	}
	
	public static int[] process(int[] inputArr) {
		int[] output = new int[inputArr.length];
		int total = 1;
		
		for (int i : inputArr) {
			total = total * i;
		}
		
		int index = 0;
		for(int i : inputArr) {
			output[index] = total/i;
			index++;
		}
		
		return output;
	}

}
