package com.akushwah.practice;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution18 {
    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int count =0;
        int[] sa = s.stream().mapToInt(x->x).toArray();
        int l = sa.length;
        for (int i = 0; i <= sa.length-m; i++) {
            if(sa[i] <=d){
                int arrSum = arraySum(sa, i,i+m);
                if(arrSum == d){
                    count++;
                }
            }
        }
        return count;
    }

    static int arraySum(int[] ar, int i, int j){
        int res = 0;
        for (int k = i; k < j; k++) {
            res+=ar[k];
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
