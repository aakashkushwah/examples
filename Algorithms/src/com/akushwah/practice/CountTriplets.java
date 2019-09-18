package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CountTriplets {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numInput = Integer.parseInt(br.readLine());
//        int sol[] = new int[numInput];
//        int j=0;
//        while (numInput != 0) {
//
//            int numItems = Integer.parseInt(br.readLine());
//
//            Integer[] inputArray = new Integer[numItems];
//            String[] array = br.readLine().split("\\s+");
//
//            for (int i = 0; i < numItems; i++) {
//                inputArray[i] = Integer.parseInt(array[i]);
//            }
//
//            sol[j++]=run(inputArray);
//            numInput--;
//        }
//        for (int i = 0; i < j; j++) {
//            System.out.println(sol[i]);
//        }
        Integer in[] = {1, 5, 3, 2};
        System.out.println(run(in));
        Integer in2[] = {3, 2, 7};
        System.out.println(run(in2));

    }

    private static boolean find(Integer[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return true;
            }
        }
        return false;
    }


    private static int run2(Integer[] arr) {
        int sol = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    int sum = arr[i] + arr[j];
                    if (find(arr, sum)) {
                        sol++;
                    }
                }
            }
        }
        return sol / 2;
    }

    private static int run(Integer[] a) {
        Set<Integer> st = new HashSet<Integer>();
        boolean fl = false;
        int count = 0;
        for (int k = 0; k < a.length; k++) {
            st.add(a[k]);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (st.contains(a[i] + a[j])) {
                    count++;
                    fl = true;
                }
            }
        }
        if (!fl)
            return 0;
        else
            return count;
    }


}
