package com.akushwah.practice.algo;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        char[] cs = s.toCharArray();
        int valC = 0;
        int mouC = 0;
        int depth = 0;
        for (int i = 0; i < n; i++) {
            int curDepth = depth;
            if(cs[i] == 'D'){
                depth -= 1;
            }else if(cs[i] == 'U'){
                depth +=1;
            }
            if(curDepth == 0 && depth<0){
                valC++;
            }else if(curDepth ==0 && depth>0){
                mouC++;
            }
        }
        return valC;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
