package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortedArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numInput = Integer.parseInt(br.readLine());
        while (numInput != 0) {
            String firstInput[] = br.readLine().split("\\s+");
            int numItemsArr1 = Integer.parseInt(firstInput[0]);
            int numItemsArr2 = Integer.parseInt(firstInput[1]);

            int[] inputArray1 = new int[numItemsArr1];
            String[] array = br.readLine().split("\\s+");

            for (int i = 0; i < numItemsArr1; i++) {
                inputArray1[i] = Integer.parseInt(array[i]);
            }

            int[] inputArray2 = new int[numItemsArr2];
            array = br.readLine().split("\\s+");

            for (int i = 0; i < numItemsArr2; i++) {
                inputArray2[i] = Integer.parseInt(array[i]);
            }

            run(inputArray1, inputArray2);
            numInput--;
        }
    }

    private static void run2(int[] arr1, int[] arr2) {
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        int[] arr = new int[arr1Size + arr2Size];
        int i = 0, j = 0, k = 0;
        while (i < arr.length && j < arr1Size && k < arr2Size) {
            if (arr1[j] <= arr2[k]) {
                arr[i] = arr1[j];
                j++;
            } else {
                arr[i] = arr2[k];
                k++;
            }
            i++;
        }
        while (j < arr1Size) {
            arr[i] = arr1[j];
            i++;
            j++;
        }
        while (k < arr2Size) {
            arr[i] = arr2[k];
            i++;
            k++;
        }
        for (int l = 0; l < arr1Size; l++) {
            System.out.print(arr1[l] + " ");
        }
        for (int l = 0; l < arr2Size; l++) {
            System.out.print(arr2[l] + " ");
        }
        System.out.println();
    }


    private static void run(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int k = 0;
        for (int i = 0; i < len1; i++) {
            int j = 0;
            if (arr1[i] > arr2[j]) {
                while (j < len2 && arr1[i] > arr2[j]) {
                    j++;
                }
                int temp = arr1[i];
                arr1[i] = arr2[k];
                arr2[k] = temp;
                leftRotateNofTotalBy1(arr2, j - 1);
            }
        }

        for (int i = 0; i < len1; i++) {
            System.out.print(arr1[i] + " ");
        }
        for (int i = 0; i < len2; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    public static void leftRotateNofTotalBy1(int arr[], int n) {
        int temp = arr[0];
        System.arraycopy(arr, 1, arr, 0, n);
        arr[n] = temp;
    }


}
