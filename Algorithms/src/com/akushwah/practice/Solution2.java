package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//Calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.
public class Solution2 {
    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] arr) {
        long total = 0;
        for(int arr_i=0; arr_i < arr.length; arr_i++){
            total += arr[arr_i];
        }
        return total;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }

        long result = aVeryBigSum(ar);
        System.out.println(result);
    }
}
