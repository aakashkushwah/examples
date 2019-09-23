package com.akushwah.practice.java;

import java.util.Scanner;

public class StdinStdOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 1; j <= n; j++) {
                long s = a + b*(powSum(j));
                System.out.print(s+" ");
            }
            System.out.println();
        }
        in.close();

    }

    private static long powSum(int n){
        long sum = 1;
        for (int i = 1; i < n; i++) {
            long pow2 = 1;
            for (int j = 0; j < i; j++) {
                pow2*=2;
            }
            sum+=pow2;
        }
        return sum;
    }
}
