package com.algo.dailyproblems;

import java.util.Arrays;

/*
 * 
This problem was recently asked by Google.
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Solution : Complexity nLog(n)

 */

public class Problem1 {
	public static void main(String[] args) {
		//int[] arr = {10, 15, 3, 7};
		int[] arr = {10, 15, 3, 7,22,23,24,25,26,27,28,29};
		int k = 25;
		//int k = 22;
		
		System.out.println("result 10 : "+new Problem1().process(arr, 10));
		
		System.out.println("result 18 : "+new Problem1().process(arr, 18));
		System.out.println("result 32 : "+new Problem1().process(arr, 32));
		System.out.println("result 31 : "+new Problem1().process(arr, 31));
		System.out.println("result 100 : "+new Problem1().process(arr, 100));
		System.out.println("result 57 : "+new Problem1().process(arr, 57));
		System.out.println("result 42 : "+new Problem1().process(arr, 42));
		System.out.println("result 69 : "+new Problem1().process(arr, 69));
		System.out.println("result 4 : "+new Problem1().process(arr, 4));
		
		
		
	}
	
	
	public boolean process(int[] arr,int k) {
		//O(nlog(n))
		//sort
		Arrays.sort(arr); //nlog(n)
		if(arr[0] + arr[arr.length -1] == k)
			return true;
		
		if(arr[arr.length - 2] + arr[arr.length -1] < k)
			return false;
		
		int maxIndex = binarySearch(arr, 0, arr.length -1, k);
		int i = 0;
		//n
		while(i != maxIndex) {
			if(arr[i] + arr[maxIndex] == k)
				return true;
			else if( arr[i] + arr[maxIndex] > k) {
				maxIndex--;
			}else {
				i++;
			}
		}
		
		
		//nlog(n) + n ~= nlog(n)
		
		return false;
	}
	
	
	public  int binarySearch(int arr[], int l, int r, int k) {
	   if((r - l) <= 1) {
    	   return r;
       }else {
    	   if( arr[r] + arr[0] < k) {
        	   if(((r+ (r*2))/2) >= arr.length -1)
        		   return r;
        	   else
        		   return binarySearch(arr,r,(r+ (r*2))/2,k);
           }
    	   else {
    		   return binarySearch(arr,l,(l+r)/2,k);
    	   }
       }
	}
	
}
