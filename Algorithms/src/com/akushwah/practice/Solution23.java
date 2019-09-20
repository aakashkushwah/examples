package com.akushwah.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution23 {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int count[] = new int[n];
        for (int i = 0; i <n ; i++) {
            count[ar[i]%n]++;
        }

        int pairCount = 0;
        for (int i = 0; i <n ; i++) {
            pairCount += count[i]/2;
        }

        return pairCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 25;
        if(n%2!=0){
            System.out.println("Weird");
        }else if(n>=2 && n<=5){
            System.out.println("Nnot Weird");
        } else if(n>=6 && n<=20){
            System.out.println("Weird");
        } else if(n>20){
            System.out.println("Not Weird");
        }
    }
    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
