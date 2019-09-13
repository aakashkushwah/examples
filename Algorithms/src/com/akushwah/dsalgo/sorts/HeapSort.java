package com.akushwah.dsalgo.sorts;

import com.akushwah.dsalgo.heap.Heap;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {80, 75, 60, 68, 55, 40, 52, 67};
        Heap heap = new Heap(10);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        heap.printHeap();
        heap.sort();
        heap.printHeap();
    }
}
