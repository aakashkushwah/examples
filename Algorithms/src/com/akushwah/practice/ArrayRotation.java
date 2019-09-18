package com.akushwah.practice;

import com.akushwah.dsalgo.sorts.Utils;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6, 7, 8};
        Utils.printArray(arr);
        rotateByN(arr, 3, true);
        Utils.printArray(arr);
        System.out.println("************");
        rotateByN(arr, 3, false);
        Utils.printArray(arr);

        int halfLength = arr.length / 2;
        int[] leftArr = new int[halfLength];
        int[] rightArr = new int[halfLength];

        System.arraycopy(arr,0,leftArr,0,halfLength);
        int rightArrPos = (arr.length%2==0)? (halfLength):(halfLength+1);
        System.arraycopy(arr, rightArrPos, rightArr, 0, halfLength);

        Arrays.stream(leftArr).forEach(System.out::print);
        System.out.println();
        Arrays.stream(rightArr).forEach(System.out::print);
        System.out.println();

        System.out.println("Left Array Sum: "+ findArraySum(leftArr));
        System.out.println("Right Array Sum: "+ findArraySum(rightArr));

        System.out.println(findGCD(35, 56));

    }

    public static int findArraySum(int arr[]){
        int result =  0;
        for (int i = 0; i < arr.length; i++) {
            result+=arr[i];
        }
        return result;
    }


    public static void rotateByN(int arr[], int n, boolean rightRotate) {
        if (n > arr.length) {
            n = n % arr.length;
        }
        if (rightRotate) {
            int temp[] = new int[n];
            System.arraycopy(arr, 0, temp, 0, n);
            System.arraycopy(arr, n, arr, 0, arr.length - n);
            System.arraycopy(temp, 0, arr, arr.length - n, n);
        } else {
            int temp[] = new int[n];
            System.arraycopy(arr, arr.length - n, temp, 0, n);
            System.arraycopy(arr, 0, arr, n, arr.length - n);
            System.arraycopy(temp, 0, arr, 0, n);
        }
    }

    public static int findGCD(int m, int n){
        if(m == 0){
            return n;
        }
        return findGCD(n%m, m);
    }


}
