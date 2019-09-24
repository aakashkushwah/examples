package com.akushwah.practice.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class AppendAndDelete {
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        String result = "ERROR";

        //if s == t then we just run an equation to determine if it can be done
        if (s.equals(t)) {
            result = (k >= s.length() * 2 || k % 2 == 0) ? "Yes" : "No";
        } else//count how many characters they share, starting from the front of the string
        {
            int matchingCharacters = 0;

            for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
                //ado
                //adolol
                if (s.charAt(i) != t.charAt(i)) {
                    break;
                }
                matchingCharacters++;
            }

            int nonMatchingCharactersInS = s.length() - matchingCharacters;
            int nonMatchingCharactersInT = t.length() - matchingCharacters;

            //I reassign here to make the conditions more readable down below
            int nmcS = nonMatchingCharactersInS;
            int nmcT = nonMatchingCharactersInT;

            //use the number of non matching characters in an equation to determine if it can be done

            //Naming the conditions to increase readability
            boolean conditionA = nmcS + nmcT == k;
            boolean conditionB = (nmcS + nmcT < k && (nmcS + nmcT - k) % 2 == 0);
            boolean conditionC = s.length() + t.length() <= k;

            result = (conditionA || conditionB || conditionC) ? "Yes" : "No";

        }

//        System.out.println(result);
        return result;
    }

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int hackosFine = 0;
        if (y1 < y2) {
            hackosFine = 10000;
        } else if (y1 == y2) {
            if (m1 < m2) {
                hackosFine = (m2 - m1) * 500;
            } else if (m2 == m1) {
                if (d2 < d1) {
                    hackosFine = (d1 - d2) * 15;
                }
            }
        }
        return hackosFine;
    }

    {
    }

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int l = arr.length;
        while (true) {
            int smallest = Integer.MAX_VALUE;
            for (int i = 0; i < l; i++) {
                if (arr[i] > 0) {
                    smallest = Math.min(smallest, arr[i]);
                }
            }
            if (smallest == Integer.MAX_VALUE) {
                break;
            }
            int j = 0;
            for (int i = 0; i < l; i++) {
                if (arr[i] > 0) {
                    arr[i] -= smallest;
                    j++;
                }
            }
            list.add(j);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long res = 0;
        if (!s.contains("a")) {
            return res;
        } else {
            long sl = s.length();
            int aCount = 0;
            for (int i = 0; i < sl; i++) {
                aCount += (s.charAt(i) == 'a') ? 1 : 0;
            }

            res += (n / sl) * aCount;
            long remaining = n % sl;
            for (int i = 0; i < remaining; i++) {
                res += (s.charAt(i) == 'a') ? 1 : 0;
            }

        }
        return res;
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;

        int i = 0;
        while (i < c.length - 3) {
            i += (c[i + 2] == 0) ? 2 : 1;
            jumps++;
        }

        jumps++;
        return jumps;
    }

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            Integer val = map.get(arr[i]);
            if (val == null) {
                val = 0;
            }
            map.put(arr[i], ++val);
            max = Math.max(max, val);
        }
        return arr.length - max;
    }


    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int resA = 0;
        int resO = 0;
        for (int i = 0; i < apples.length; i++) {
            int ap = apples[i];
            if (ap > 0) {
                int aop = a + ap;
                if (aop >= s && aop <= t) {
                    resA++;
                }
            }
        }

        for (int i = 0; i < oranges.length; i++) {
            int op = oranges[i];
            if (op < 0) {
                int aop = b - Math.abs(op);
                if (aop >= s && aop <= t) {
                    resO++;
                }
            }
        }
        System.out.println(resA);
        System.out.println(resO);

    }


    // Complete the squares function below.
    static int squares(int a, int b) {
        int res = 0;
        int l = (int) Math.sqrt(a);
        int u = (int) Math.sqrt(b);
        if (a == l * l) {
            res++;
        }
        res += u - l;
        return res;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String s = scanner.nextLine();
//
//        String t = scanner.nextLine();
//
//        int k = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        String result = appendAndDelete(s, t, k);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();

        int arr[] = {5, 4, 4, 2, 2, 8};
        int res[] = cutTheSticks(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    // Complete the queensAttack function below.

}

