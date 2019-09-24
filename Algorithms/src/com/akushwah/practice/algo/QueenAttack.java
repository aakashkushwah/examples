package com.akushwah.practice.algo;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class ChessPosPair {
    int r;
    int c;

    ChessPosPair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public int getR() {
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPosPair that = (ChessPosPair) o;
        return r == that.r &&
                c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}

public class QueenAttack {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        HashSet<ChessPosPair> obsPairs = new HashSet<>();
        for (int i = 0; i < k; i++) {
            obsPairs.add(new ChessPosPair(obstacles[i][0], obstacles[i][1]));
        }

        int res = 0;
        HashSet<ChessPosPair> apsPairs = new HashSet<>();

        for (int j = 0; j <= 7; j++) {
            int r = r_q;
            int c = c_q;
            while (ifInside(r, c, n)) {
                switch (j) {
                    case 0:
                        r = r + 1;
                        break;
                    case 1:
                        r = r + 1;
                        c = c + 1;
                        break;
                    case 2:
                        c = c + 1;
                        break;
                    case 3:
                        r = r - 1;
                        c = c + 1;
                        break;
                    case 4:
                        r = r - 1;
                        break;
                    case 5:
                        r = r - 1;
                        c = c - 1;
                        break;
                    case 6:
                        c = c - 1;
                        break;
                    case 7:
                        r = r + 1;
                        c = c - 1;
                        break;
                }
                if (ifInside(r, c, n)) {
                    ChessPosPair pair = new ChessPosPair(r, c);
                    if (!obsPairs.contains(pair)) {
                        apsPairs.add(pair);
                        res++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        return res;
    }

    static boolean ifInside(int r, int c, int n) {
        if (r >= 1 && r <= n && c >= 1 && c <= n) {
            return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

