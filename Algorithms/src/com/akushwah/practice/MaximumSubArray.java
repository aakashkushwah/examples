package com.akushwah.practice;

import com.akushwah.dsalgo.sorts.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubArray {
    public static void main(String[] args) throws IOException {
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numInput = Integer.parseInt(br.readLine());
//        int sol[] = new int[numInput];
//        int j=0;
//        while (numInput != 0) {
//
//            int numItems = Integer.parseInt(br.readLine());
//
//            int[] inputArray = new int[numItems];
//            String[] array = br.readLine().split("\\s+");
//
//            for (int i = 0; i < numItems; i++) {
//                inputArray[i] = Integer.parseInt(array[i]);
//            }
////            int memory[] = new int[inputArray.length];
////            for (int i = 0; i < memory.length; i++) {
////                memory[i] = Integer.MIN_VALUE;
////            }
//
//            sol[j++]=run(inputArray);
//            numInput--;
//        }
//        for (int i = 0; i < j; i++) {
//            System.out.println(sol[i]);
//        }
        int arr[] = {-2, 5, -1};
        System.out.println(run(arr));
    }

    private static int run(int[] arr) {
        int globalMax = arr[0];
        int n = arr.length;
        int localMax = arr[0];
        for (int i = 1; i < n; i++) {
            if (localMax + arr[i] > arr[i]) {
                localMax = localMax + arr[i];
            } else{
                localMax = arr[i];
            }
            if (globalMax < localMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }
}

