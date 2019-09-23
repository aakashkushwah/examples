package com.akushwah.practice.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class MagicSquare {
    static int[][] copy(int[][] s){
        int ws[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(s[i],0, ws[i],0,3);
        }
        return ws;
    }
     static int formingMagicSquare(int[][] s) {
         int[][][] possiblePermutations = {
                 {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1

                 {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2

                 {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3

                 {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4

                 {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5

                 {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6

                 {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7

                 {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
         };

         int minCost = Integer.MAX_VALUE;
         for (int permutation = 0; permutation < 8; permutation++)
         {
             int permutationCost = 0;
             for (int i = 0; i < 3; i++)
             {
                 for (int j = 0; j < 3; j++)
                     permutationCost += Math.abs(s[i][j] - possiblePermutations[permutation][i][j]);
             }
             minCost = Math.min(minCost, permutationCost);
         }

        return minCost;
    }





    static int[] getMagicMs(int [][] s){
        int ms[] = new int[8];
        ms[0]= s[0][0]+s[0][1]+s[0][2];
        ms[1] = s[1][0]+s[1][1]+s[1][2];
        ms[2] = s[2][0]+s[2][1]+s[2][2];

        ms[3]= s[0][0]+s[1][0]+s[2][0];
        ms[4] = s[0][1]+s[1][1]+s[2][1];
        ms[5] = s[0][2]+s[1][2]+s[2][2];

        ms[6]= s[0][0]+s[1][1]+s[2][2];
        ms[7] = s[0][2]+s[1][1]+s[2][0];
        return ms;
    }

    static boolean isMagicSquare(int [][] s){
       int ms[] = getMagicMs(s);

        boolean notAMagicSq = true;
        int init = ms[0];
        for (int i = 1; i < 7; i++) {
            if(init != ms[i]){
                notAMagicSq = false;
            }
        }

        return notAMagicSq;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
