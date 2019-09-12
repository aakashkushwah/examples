package com.akushwah.dsalgo.sorts;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[7];
        arr[0] = 20;
        arr[1] = 35;
        arr[2] = -15;
        arr[3] = 7;
        arr[4] = 55;
        arr[5] = 1;
        arr[6] = -22;
        quickSort(arr,0,7);
        Utils.printArray(arr);
    }

    public static int partition(int arr[], int start, int end){
        Utils.printArray(arr);

        //this is using the first element as the pivot
        int pivot = arr[start];
        System.out.println("start="+start+" end="+end+" pivot="+pivot);
        int i=start;
        int j=end;

        while(i<j){
            //Empty loop body
            while(i<j && arr[--j]>=pivot);
            if(i<j){
                arr[i] = arr[j];
            }
            System.out.println("First "+i+" "+j);
            Utils.printArray(arr);

            //Empty loop body
            while(i<j && arr[++i]<=  pivot);
            if(i<j){
                arr[j] = arr[i];
            }
            System.out.println("Second "+i+" "+j);
            Utils.printArray(arr);
        }
        arr[j] = pivot;
        System.out.println("start="+start+" end="+end+" j="+j+" pivot="+pivot);
        Utils.printArray(arr);
        System.out.println("********");
        return j;
    }

    public static void quickSort(int arr[], int start, int end){
        if(end-start<2){
            return;
        }
        int pivotIndex = partition(arr, start, end);

        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex+1,end);
    }
}
