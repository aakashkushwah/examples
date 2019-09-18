package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortArray012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numInput = Integer.parseInt(br.readLine());
        while (numInput != 0) {
            String firstInput[] = br.readLine().split("\\s+");
            int numItems = Integer.parseInt(firstInput[0]);

            int[] inputArray = new int[numItems];
            String[] array = br.readLine().split("\\s+");

            for (int i = 0; i < numItems; i++) {
                inputArray[i] = Integer.parseInt(array[i]);
            }

            run(inputArray);
            numInput--;
        }
    }

    private static void run(int[] arr){
        int countArr[] = new int[3];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        int j=0;
        int k = 0;
        while(j<arr.length){
            for (int i = 0; i < countArr[k]; i++) {
                arr[j++] = k;
            }
            k++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
