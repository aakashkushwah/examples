package com.akushwah.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution13 {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int k, int[] arr) {
        for (int n = 2; n <=k ; n++) {
            int last = arr[n - 1];
            int i;
            int j=0;
            for (i = n - 2; i >= 0 && arr[i] > last; i--) {
                arr[i + 1] = arr[i];
//                printArr(arr, n);
                j++;
            }

            arr[n-j-1] = last;
            printArr(arr, k);
            if(n!=k)
            System.out.println();
        }
    }

    static void printArr(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}

