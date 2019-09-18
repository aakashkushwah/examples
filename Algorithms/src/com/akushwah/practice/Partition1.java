package com.akushwah.practice;

public class Partition1 {
    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 2};
        int sum = getSum(arr);
        if (sum % 2 == 0) {
            System.out.println(sumOfSubSet(arr, 4, sum / 2));
        } else {
            System.out.println("Not Possible");
        }
    }

    private static int findMin(int[] arr, int n, int sum){
        if(n == 0){
            return 0;
        }

        return min(findMin(arr,n-1, sum), findMin(arr,n-1,sum- arr[n-1]));
    }

    private static int min(int a, int b){
        return a>b?b:a;
    }

    private static int getSum(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }

    private static boolean sumOfSubSet(int[] arr, int n, int halfSum) {
        if (halfSum == 0) {
            return true;
        }
        if (n == 0 && halfSum != 0) {
            return false;
        }
        if (arr[n - 1] > halfSum) {
            return sumOfSubSet(arr, n - 1, halfSum);
        }

        return sumOfSubSet(arr, n - 1, halfSum) || sumOfSubSet(arr, n - 1, halfSum - arr[n - 1]);
    }
}
