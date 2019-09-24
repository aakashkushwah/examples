package com.akushwah.practice.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class AcmIcpcTeam {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int n = container.length;

        int[] rt = new int[n];
        int[] ct = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rt[i] += container[i][j];
                ct[j] += container[i][j];
            }
        }
        Arrays.sort(rt);
        Arrays.sort(ct);
        String ans = "Possible";
        for (int i = 0; i < n; i++) {
            if (rt[i] != ct[i])
                ans = "Impossible";
        }

        return ans;
    }

    // Complete the encryption function below.
    static String encryption(String s) {

        s = s.replaceAll(" ","");
        StringBuffer sb = new StringBuffer(s);
        int len = sb.length();
        int L = (int)Math.floor(Math.sqrt(len));
        int M = (int)Math.ceil(Math.sqrt(len));
        int p = M;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sb.length();) {
            if(i+M < sb.length()){
                list.add(sb.substring(i, i+M));
            }else{
                list.add(sb.substring(i, len));
            }
            i=i+M;
        }

        StringBuffer[] tps = new StringBuffer[M];
        for (int i = 0; i < M ; i++) {
            StringBuffer tpsi = new StringBuffer();
            for (String str:
                    list) {
                if(i < str.length())
                    tpsi.append(str.charAt(i));
            }
            tps[i] = tpsi;
        }

        StringBuffer ans = new StringBuffer();
        for (StringBuffer str:
             tps) {
            ans.append(str.toString()+" ");
        }
        return ans.toString();
    }

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        long minB = Math.min(bc, wc + z);
        long minW = Math.min(wc, bc + z);
        return b * minB + w * minW;
    }

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int res[] = new int[2];
        int tl = topic.length;

        TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(count1(o1)).compareTo(Integer.valueOf(count1(o2)));
            }
        });
        for (int i = 0; i < tl - 1; i++) {
            String ti = topic[i];
            for (int j = i + 1; j < tl; j++) {
                String tj = topic[j];
                String iorj = orStr(ti, tj);
                Integer val = map.get(iorj);
                if (val == null) {
                    val = 0;
                }
                map.put(iorj, ++val);
            }
        }

        res[0] = count1(map.lastKey());
        res[1] = map.get(map.lastKey());
        return res;
    }

    private static int count1(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    private static String orStr(String a, String b) {
        StringBuffer res = new StringBuffer();
        int l = a.length();
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                res.append('0');
            } else {
                res.append('1');
            }
        }
        return res.toString();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(encryption("haveaniceday"));
    }
    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
