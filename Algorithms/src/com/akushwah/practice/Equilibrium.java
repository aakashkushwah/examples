package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Equilibrium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numInput = Integer.parseInt(br.readLine());
        while (numInput != 0) {
            String firstInput[] = br.readLine().split("\\s+");
            int numItems = Integer.parseInt(firstInput[0]);

            int[] inputArray = new int[numItems];
            String[] array = br.readLine().split("\\s+");

            for (int i = 0; i < numItems; i++) {
                inputArray[i] = Integer.parseInt(array[i]);
            }

            run(inputArray);
            numInput--;
        }
    }

    private static void run(int[] arr){
        if(arr.length == 1){
            System.out.println("1");
            return;
        }

        if(arr.length == 2){
            System.out.println("-1");
            return;
        }

        int len = arr.length;
        int sum = getSum(arr);
        int j = 0;
        int leftSum = 0;
        while(j<len-1){
            sum = sum - arr[j];
            if(leftSum == sum){
                System.out.println(j+1);
                return;
            }
            leftSum+=arr[j];
            j++;
        }

        System.out.println("-1");
    }

    private static int getSum(int[] arr){
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
