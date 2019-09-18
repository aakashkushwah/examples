package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumIncreasingSubSeq {
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

    private static void run(int[] arr) {
        int n = arr.length;
        int i, j, max = 0;
        int msis[] = new int[n];

        /* Initialize msis values
           for all indexes */
        for (i = 0; i < n; i++)
            msis[i] = arr[i];

        /* Compute maximum sum values
           in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] &&
                        msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];

        /* Pick maximum of all
           msis values */
        for (i = 0; i < n; i++)
            if (max < msis[i])
                max = msis[i];

        System.out.println(max);
    }

}
