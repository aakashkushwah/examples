package com.akushwah.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Pair19 {
    int a,b;
    Pair19(int a, int b){
        if(a>b){
            this.a =a;
            this.b =b;
        }else{
            this.a =b;
            this.b =a;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair19 pair19 = (Pair19) o;
        return a == pair19.a &&
                b == pair19.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
    boolean isPairDivisible(int k){
        return (a+b)%k == 0;
    }
}
public class Solution19 {

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
//        Set<Pair19> set = new HashSet<>();
        int count =0;
        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                Pair19 pair = new Pair19(ar[i],ar[j]);
                if(isPairDivisible(ar[i], ar[j], k)){
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isPairDivisible(int a, int b, int k){
        return (a+b)%k == 0;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
