package com.company.test2;

public class CountSort {
    public static void main(String[] args) {
        int arr[] = {2,5,9,8,2,8,7,10,3,4};
        countSort(arr,2,10);
        Utils.printArray(arr);
    }

    public static void countSort(int arr[], int min, int max){
        int[] carr = new int[max-min + 1];
        for (int i = 0; i <arr.length ; i++) {
            carr[arr[i]-min]++;
        }
        int j=0;
        for (int i = min; i <=max ; i++) {
            while(carr[i-min]>0){
                arr[j++] = i;
                carr[i-min]--;
            }
        }
    }
}
