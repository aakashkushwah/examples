package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numInput = Integer.parseInt(br.readLine());
        while (numInput != 0) {
            String firstInput[] = br.readLine().split("\\s+");
            int numItems = Integer.parseInt(firstInput[0]);
            int sum = Integer.parseInt(firstInput[1]);

            int[] inputArray = new int[numItems];
            String[] array = br.readLine().split("\\s+");

            for (int i = 0; i < numItems; i++) {
                inputArray[i] = Integer.parseInt(array[i]);
            }

//            run(inputArray, sum);
            myRun(inputArray, sum);
            numInput--;
        }

        int[] inputArray = {1, 2, 4, 5, 6};
        int sum = 8;
        run(inputArray, sum);
        myRun(inputArray, sum);
    }

    private static void myRun(int[] arr, int sum) {
        int arrLen = arr.length;
        int curSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            curSum += arr[i];
            int j = i + 1;
            while (curSum < sum) {
                curSum += arr[j++];
            }
            if (curSum == sum) {
                System.out.println((i + 1) + " " + j);
                return;
            }else{
                curSum = 0;
            }
        }
        System.out.println("-1");
    }

    private static void run(int[] inputArray, int sum) {
        int startPointer = 0;
        int curSum = inputArray[0];

        for (int i = 1; i <= inputArray.length; i++) {
            // System.out.println(String.format("one %d %d %d", i, startPointer, curSum));

            while (curSum > sum && startPointer < i - 1) {
                // System.out.println(String.format("two %d %d %d", i, startPointer, curSum));
                curSum = curSum - inputArray[startPointer];
                startPointer++;
            }

            // System.out.println(String.format("three %d %d %d", i, startPointer, curSum));

            if (curSum == sum) {
                System.out.println(String.format("%d %d", startPointer + 1, i));
                return;
            }


            if (i < inputArray.length) {
                curSum += inputArray[i];
            }
            // System.out.println(String.format("three %d %d %d", i, startPointer, curSum));
            // System.out.println("-------------");

        }
        System.out.println(-1);
    }
}
