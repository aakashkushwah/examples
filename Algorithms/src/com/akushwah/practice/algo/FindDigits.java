package com.akushwah.practice.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FindDigits {
    // Complete the findDigits function below.
    static int findDigits(int n) {
        String ns = String.valueOf(n);
        char[] cs = ns.toCharArray();
        int l = cs.length;
        int[] digits = new int[l];
        int res = 0;
        for (int i = 0; i < l; i++) {
            int d = Integer.parseInt(cs[i]+"");
            if(d!=0 && n%d == 0){
                res++;
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
