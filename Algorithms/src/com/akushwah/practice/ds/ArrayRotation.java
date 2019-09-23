package com.akushwah.practice.ds;

import java.util.Scanner;

public class ArrayRotation {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();
        rotate(a,d,n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }

    private static void rotate(int[] ar, int d, int n){
        for (int i = 0; i <d ; i++) {
            int f = ar[0];
            System.arraycopy(ar, 1, ar,0, n-1);
            ar[n-1]=f;
        }
    }
}
