package com.akushwah.dsalgo.sorts;

public class Utils {

    public static void swap(int a[], int i, int j){
        if(i == j)
            return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void printStringArray(String a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
