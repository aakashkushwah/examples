package com.akushwah.practice.algo;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ElectronicShop {

    private static int getMoneySpent(int[] keyBoards, int ks, int ke, int[] drives, int ds, int de, int b, int res){
        if(ke-ks ==0 || ds-de == 0){
            return -1;
        }

        int kc = keyBoards[ke-1];
        int dc = drives[de-1];
        if((kc+dc)<=b){
//            int firstC = getMoneySpent(keyBoards,0,ke,drives,0, de-1,b, res);
//            int secondC = getMoneySpent(keyBoards,0,ke-1,drives,0, de,b, res);
            res = Math.max(getMoneySpent(keyBoards,0,ke,drives,0, de-1,b, res), getMoneySpent(keyBoards,0,ke-1,drives,0, de,b, res));
        }
        return res;
    }

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
//        /*
//         * Write your code here.
//         */
//        return getMoneySpent(keyboards,0,keyboards.length,drives,0,drives.length,b, -1);
        int res = -1;
        int kc = keyboards.length;
        int dc = drives.length;
        for (int i = 0; i < kc ; i++) {
            int ki = keyboards[i];
            if(ki >=b){
                continue;
            }
            for (int j = 0; j <dc ; j++) {
                int dj = drives[j];
                if(dj >= b){
                    continue;
                }
                int c = ki + drives[j];
                if(c <= b){
                    res = Math.max(res, c);
                    if(res == b){
                        return res;
                    }
                }
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
