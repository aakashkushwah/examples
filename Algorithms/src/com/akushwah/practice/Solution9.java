package com.akushwah.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution9 {

    static long getCount(String s) {
        int count = 0;
        int N = s.length();
        char[] chars = s.toCharArray();
        List<String> subs = new ArrayList<>();
        for (int i = 2; i < N; i++) {
            for (int j = 0; N - j >= i; j++) {
                char[] subChars = new char[i];
                System.arraycopy(chars, j, subChars, 0, i);
                subs.add(String.valueOf(subChars));
            }
        }
        for (String str :
                subs) {
            count += getPalindromicBorderCount(str);
        }
        count+=getPalindromicBorderCount(s);
        return count;
    }

    /*
     * Complete the palindromicBorder function below.
     */
    static int palindromicBorder(String s) {

        /*
         * Write your code here.
         */
        long count = getCount(s);
        Long result = count % (long) (Math.pow(10, 9) + 7);
        return result.intValue();
    }

    private static boolean isPalindrome(String s){
        return new StringBuffer(s).reverse().toString().equals(s);
    }

    private static int getPalindromicBorderCount(String s) {
        int count = 0;
        int l = s.length();
        if (l == 2) {
            return s.charAt(0) == s.charAt(1) ? 1 :0;
        }
        StringBuffer sb = new StringBuffer(s);

        for(int i=1;i<=l-1;i++){
            String left = sb.substring(0,i);
            if(isPalindrome(left)){
                String right = sb.substring(l-i,l);
                if(left.equals(right)){
                    count++;
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = palindromicBorder(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
