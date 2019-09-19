package com.akushwah.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Solution6 {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long totalSum = Arrays.stream(arr).mapToLong(x -> Long.valueOf(x)).sum();
        long minSum = totalSum;
        long maxSum = 0;
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            minSum = Math.min(minSum, totalSum-arr[i]);
            maxSum = Math.max(maxSum, totalSum-arr[i]);
        }
        System.out.print(minSum+" "+maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
