package com.akushwah.practice;

import java.util.Scanner;

public class Solution5 {
    // Complete the staircase function below.
    static void staircase(int n) {
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n-i-1 ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <=i; j++) {
                System.out.print("#");
            }
            if(i!=n-1){
                System.out.println();
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
