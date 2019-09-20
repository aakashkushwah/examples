package com.akushwah.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution14 {
    public static boolean solve(String s) {
        boolean hasUnderscore = false;
        boolean allAreHappy = true;
        int cntChar[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') {
                hasUnderscore = true;
            } else {
                cntChar[s.charAt(i)-'A']++;
                if (( i > 0 && s.charAt(i-1) == s.charAt(i)) || (i+1 < s.length() && s.charAt(i+1) == s.charAt(i))) {
                } else {
                    allAreHappy = false;
                }
            }
        }

        if (allAreHappy) {
            return true;
        }

        if (!hasUnderscore) {
            return false;
        }

        for (int i = 0; i < cntChar.length; i++) {
            if (cntChar[i] == 1) {
                return false;
            }
        }

        return true;
    }
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        int min = Math.min('A', '_');
        int max = Math.max('Z', '_');
        char[] chars = b.toCharArray();
        if (!areLadyBugsHappy(chars)) {
            int ep = getEP(chars);
            if(ep!=0){
                countSort(chars, min, max);
            }else{
                return "NO";
            }
            if (!areLadyBugsHappy(chars)) {
                return "NO";
            }else{
                return "YES";
            }
        }
        return "YES";

    }

    private static int getEP(char[] s) {
        int ep = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i]=='_'){
                ep++;
            }
        }
        return ep;
    }

    public static void countSort(char arr[], int min, int max) {
        int[] carr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            carr[arr[i] - min]++;
        }
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (carr[i - min] > 0) {
                arr[j++] = (char) i;
                carr[i - min]--;
            }
        }
    }

    private static String moveAround(String s) {
        return null;
    }

    private static boolean areLadyBugsHappy(char[] c) {
        int l = c.length;
        if(l==1){
            if(c[0]!='_'){
                return false;
            }
            return true;
        }
        if(l == 2){
            if(c[0]!=c[1]){
                return false;
            }
            return true;
        }
        int ep = getEP(c);
        if (ep == l) {
            return true;
        }

        for (int i = 1; i <= l - 2; i++) {
            if (c[i] != c[i - 1] && c[i] != c[i + 1]) {
                return false;
            }
        }
        if(c[0] != '_' && c[0]!=c[1] ){
            return false;
        }
        if(c[l-1] != '_' && c[l-1]!=c[l-2] ){
            return false;
        }
        return true;
    }

    /**
     * 7
     * 1
     * G
     * 2
     * GR
     * 4
     * _GR_
     * 5
     * _R_G_
     * 5
     * R_R_R
     * 8
     * RRGGBBXX
     * 8
     * RRGGBBXY
     * NO
     * NO
     * NO
     * NO
     * YES
     * YES
     * NO
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
