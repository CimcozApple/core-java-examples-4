package com.java.arrays.subarray;

// sub array with smallest sum : comment1
public class SubArrayWithMaxSum {
    // kadane's algorithm
    // https://javaconceptoftheday.com/contiguous-subarray-with-maximum-sum-in-java/
    public static void main(String[] args) {
        // works for both mix array and +ve array, fails for -ve array
        int arr[] = {4, 2, 3, 1};//{2, -3, 7, -4, 2, 5, -8, -9, 7, -6, -1};

        int maxSum = arr[0];
        int start = 0;
        int end = 0;
        int currentSum = arr[0];
        int currentStart = 0;
        for (int i = 1; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (currentSum < 0) { // comment 1. make it >
                currentSum = 0;
                currentStart = i + 1;
            } else if (currentSum > maxSum) { // comment 1 : make it <
                maxSum = currentSum;
                start = currentStart;
                end = i;
            }
        }
        System.out.println("sum: " + maxSum);
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " \t");
        }
        System.out.println("\n");

        // alternate approach below
        currentSum = arr[0];
        maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            currentSum = Math.max(currentSum, arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println("sum=" + maxSum);
    }
}
