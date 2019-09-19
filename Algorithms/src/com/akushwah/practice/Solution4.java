package com.akushwah.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution4 {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int l = arr.length;
        int[] result = new int[3];
        Arrays.stream(arr).forEach(x -> {
            if(x>0){
                result[0]++;
            }else if(x<0){
                result[1]++;
            }else{
                result[2]++;
            }
        });
        System.out.printf("%.6f", Double.valueOf(result[0])/l);
        System.out.println();
        System.out.printf("%.6f", Double.valueOf(result[1])/l);
        System.out.println();
        System.out.printf("%.6f", Double.valueOf(result[2])/l);
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

        plusMinus(arr);

        scanner.close();
    }
}

