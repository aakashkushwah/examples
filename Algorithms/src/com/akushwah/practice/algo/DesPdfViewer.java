package com.akushwah.practice.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DesPdfViewer {
    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        char[] cs = word.toCharArray();
        int w = cs.length;
        int height = 1;
        for (int i = 0; i < w; i++) {
            int curHeight = h[(cs[i] - 'a')];
            height = Math.max(height, curHeight);
        }
        return height * w;
    }

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int bc = 0;
        for (int l = i; l <= j; l++) {
            String reviStr = new StringBuffer(l + "").reverse().toString();
            int revi = Integer.parseInt(reviStr);
            int diff = Math.abs(l - revi);
            if (diff % k == 0) {
                bc++;
            }
        }
        return bc;
    }

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int cum = 2;
        int shared = 5;
        int liked = 2;
        for (int i = 1; i < n; i++) {
            shared = liked * 3;
            liked = shared / 2;
            cum += liked;
        }
        return cum;
    }

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
//        BigInteger M = new BigInteger(m+"");
//        BigInteger N = new BigInteger(n+"");
//        BigInteger MBYN = M.divide(N);
//        M = M.subtract(MBYN.multiply(N));
//        for (long i = 0; i < M.longValue(); i++) {
//                s++;
//                if (s > n) {
//                    s = s % n;
//                }
//        }
//
//        return (s-1) == 0? n: (s-1);

        s = s-1;
        while(m != 0)
        {
            m--;
            s++;
            if(s > n)
                s = 1;
        }

        return s;

    }

    static int[] permutationEquation(int[] p) {
        int[] res = new int[p.length];
        int[] F = new int[p.length+1];
        Map<Integer, Integer> vmap = new HashMap<>();
        Map<Integer, Integer> kmap = new HashMap<>();
        for (int i = 1; i <= p.length; i++) {
            F[i] = p[i-1];
            vmap.put(p[i-1], i);
            kmap.put(i,p[i-1]);
        }
        for (int i = 1; i <= p.length ; i++) {
            int px =  vmap.get(i);
            res[i-1] = vmap.get(px);
        }


        return res;
    }

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int res[] = new int[queries.length];
        for (int i = 0; i <k ; i++) {
            int temp = a[a.length-1];
            System.arraycopy(a,0,a,1, a.length-1);
            a[0] = temp;
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = a[queries[i]];
        }
        return res;
    }


    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                s++;
                if (s >= k) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = (i % 2 != 0) ? res * 2 : res + 1;
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int[] h = new int[26];
//
//        String[] hItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < 26; i++) {
//            int hItem = Integer.parseInt(hItems[i]);
//            h[i] = hItem;
//        }
//
//        String word = scanner.nextLine();
//
//        int result = designerPdfViewer(h, word);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();

        System.out.println(beautifulDays(13, 45, 3));
        System.out.println(viralAdvertising(3));
        System.out.println(saveThePrisoner(3,7,3));
    }
}
