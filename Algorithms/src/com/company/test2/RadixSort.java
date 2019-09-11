package com.company.test2;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {4725, 4586, 1330, 8792, 1594, 5729};
        radixSort(arr, 10, 4);
        Utils.printArray(arr);
        Arrays.sort(arr);
        Arrays.parallelSort(arr);

        String str[] = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSortStr(str, 26, 5);
        Utils.printStringArray(str);
    }

    public static void radixSort(int arr[], int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix);
        }
    }

    public static void radixSortStr(String[] arr, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSortStr(arr, i, radix);
        }
    }

    public static int getCharStr(int pos, String value) {
        int result = value.charAt(pos) - 'a';
        return result;
    }

    public static void radixSingleSortStr(String[] arr, int pos, int radix) {
        int numItems = arr.length;
        int[] countArr = new int[radix];
        for (String value : arr) {
            countArr[getCharStr(pos, value)]++;
        }
        //adjust the count array
        for (int i = 1; i < radix; i++) {
            countArr[i] += countArr[i - 1];
        }

        String temp[] = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArr[getCharStr(pos, arr[tempIndex])]] = arr[tempIndex];
        }
        System.arraycopy(temp, 0, arr, 0, numItems);
    }


    public static void radixSingleSort(int arr[], int pos, int radix) {
        int numItems = arr.length;
        int[] countArr = new int[radix];
        for (int value : arr) {
            countArr[getDigit(pos, value, radix)]++;
        }
        //adjust the count array
        for (int i = 1; i < radix; i++) {
            countArr[i] += countArr[i - 1];
        }

        int temp[] = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArr[getDigit(pos, arr[tempIndex], radix)]] = arr[tempIndex];
        }
        System.arraycopy(temp, 0, arr, 0, numItems);
    }

    public static int getDigit(int pos, int value, int radix) {
        return (value / (int) (Math.pow(10, pos))) % radix;
    }
}
