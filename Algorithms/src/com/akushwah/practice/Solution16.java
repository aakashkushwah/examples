package com.akushwah.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result16 {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    private static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    private static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }

    private static int arrayLCM(int[] ar){
        if(ar.length == 1){
            return ar[0];
        }
        int il = lcm(ar[0], ar[1]);
        for (int i = 2; i < ar.length; i++) {
            il = lcm(il,ar[i]);
        }
        return il;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int al = a.get(a.size() - 1);
        int bf = b.get(0);
        if ((bf - al) % al != 0) return 0;
        int enSize = (bf - al) / al;
        int[] en = new int[enSize+1];
        int count = 0;
        for (int i = 0; i <= enSize; i++) {
            en[i] = al * (i + 1);
        }

        int lcm = arrayLCM(a.stream().mapToInt(x->x).toArray());
        for (int j = 0; j <= enSize; j++) {
            if(en[j] >=lcm){
                int i = 0;
                for (i = 0; i < b.size(); i++) {
                    if (b.get(i) % en[j] != 0) break;
                }
                if (i == b.size()) {
                    count++;
                }
            }
        }
        return count;
    }

}

public class Solution16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result16.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

