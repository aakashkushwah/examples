package com.akushwah.dsalgo.sorts;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {154, 146, 283, 566, 695, 792, 243};
        bucketSort(arr);
        Utils.printArray(arr);
    }

    public static void bucketSort(int[] arr) {
        List<Integer>[] buckets = new List[100];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            buckets[hash(arr[i])].add(arr[i]);
        }

        for(List bucket: buckets){
            Collections.sort(bucket);
        }

        int j =0;
        for (int i = 0; i < buckets.length ; i++) {
            for(int value: buckets[i]){
                arr[j++] = value;
            }
        }
    }

    private static int hash(int number) {
        return number / (int) 100 ;
    }
}
