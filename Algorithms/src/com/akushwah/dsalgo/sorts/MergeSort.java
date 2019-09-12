package com.akushwah.dsalgo.sorts;

public class MergeSort {
    private static void merge(int arr[], int start, int mid, int end) {
        if (arr[mid - 1] <= arr[mid]) {
            return;
        }
        int[] temp = new int[end - start];
        int tempIndex = 0;
        int i = start;
        int j = mid;
        while (i < mid && j < end) {
            temp[tempIndex++] = (arr[i] >= arr[j]) ? arr[i++] : arr[j++];
        }
        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempIndex);

    }

    private static void mergeDesc(int arr[], int start, int mid, int end) {
        if (arr[mid - 1] >= arr[mid]) {
            return;
        }
        int[] temp = new int[end - start];
        int tempIndex = 0;
        int i = start;
        int j = mid;
        while (i < mid && j < end) {
            temp[tempIndex++] = (arr[i] >= arr[j]) ? arr[i++] : arr[j++];
        }
        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempIndex);

    }

    public static void main(String[] args) {
        int arr[] = new int[7];
        arr[0] = 20;
        arr[1] = 35;
        arr[2] = -15;
        arr[3] = 7;
        arr[4] = 55;
        arr[5] = 1;
        arr[6] = -22;
        mergeSort(arr, 0, 7);
        System.out.println("*******");
        Utils.printArray(arr);
    }

    public static void mergeSort(int arr[], int start, int end) {
        System.out.println("start="+start+" end="+end);
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
//        merge(arr, start, mid, end);
        mergeDesc(arr,start, mid, end);
        Utils.printArray(arr);
    }

}
