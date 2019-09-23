package com.akushwah.practice.algo;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {
    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger res = new BigInteger("1");

        for (int i = 2; i <=n ; i++) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(res.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
