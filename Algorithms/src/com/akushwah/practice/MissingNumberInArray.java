package com.akushwah.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumberInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numInput = Integer.parseInt(br.readLine());
        int sol[] = new int[numInput];
        int j = 0;
        while (numInput != 0) {

            int numItems = Integer.parseInt(br.readLine());

            int[] inputArray = new int[numItems-1];
            String[] array = br.readLine().split("\\s+");

            for (int i = 0; i < numItems-1; i++) {
                inputArray[i] = Integer.parseInt(array[i]);
            }

            sol[j++] = run(inputArray);
            numInput--;
        }
        for (int i = 0; i < j; i++) {
            System.out.println(sol[i]);
        }

    }

    private static int run(int[] arr) {
        int N = arr.length + 1;
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += arr[i];
        }
        int intendedSum = (N * (N + 1)) / 2;
        return (intendedSum - sum);
    }
}
