package com.akushwah.dsalgo.search;

public class Main {
    public static void main(String[] args) {
        int arr[] = {-23, -15, 1, 7, 35, 55};
        System.out.println(iterativeBinarySearch(arr, 1));
        System.out.println(iterativeBinarySearch(arr, 35));
        System.out.println(iterativeBinarySearch(arr, -15));
        System.out.println(iterativeBinarySearch(arr, 2));

        System.out.println(recursiveBinarySearch(arr, 1));
        System.out.println(recursiveBinarySearch(arr, 35));
        System.out.println(recursiveBinarySearch(arr, -15));
        System.out.println(recursiveBinarySearch(arr, 2));

    }

    public static int recursiveBinarySearch(int[] arr, int value) {
        return recurBinSearch(arr, 0, arr.length, value);
    }

    private static int recurBinSearch(int[] arr, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        System.out.println("Midpoint= " + mid);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return recurBinSearch(arr, start, mid, value);
        } else {
            return recurBinSearch(arr, mid + 1, end, value);
        }
    }

    public static int iterativeBinarySearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            System.out.println("MidPoint= " + mid);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
