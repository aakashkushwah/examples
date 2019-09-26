package com.akushwah.practice.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
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

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int l = w.length();
        String[] strs = new String[w.length()];
        for (int i = 0; i < l; i++) {
            strs[i] = w.charAt(i)+"";
        }

        Arrays.sort(strs, Collections.reverseOrder());
        StringBuffer maxString = new StringBuffer();
        for (int i = 0; i < l; i++) {
            maxString.append(strs[i]);
        }
        StringBuffer s = new StringBuffer(w);
        if(s.toString().equals(maxString)){
            return "no answer";
        }
        boolean found = false;
        int i = l-1;
        int j = 0;
        while(!found && i>0 && s.toString().compareTo(maxString.toString()) <0){
            char qi = s.charAt(i);
            for (j = i-1; j >=0 ; j--) {
                char qj = s.charAt(j);
                if(qi > qj){
                    s.setCharAt(i, qj);
                    s.setCharAt(j, qi);
                    found = true;
                    break;
                }
            }
            i--;
        }
        String res = sort(s.toString(), j+1, s.length(), false);

        return found?res:"no answer";

    }

    static String sort(String w, int s, int e, boolean isReverse){
        String[] strs = new String[e-s];
        int j = 0;
        for (int i = s; i < e; i++) {
            strs[j++] = w.charAt(i)+"";
        }


        if(isReverse){
            Arrays.sort(strs, Collections.reverseOrder());
        }else{
            Arrays.sort(strs);
        }
        StringBuffer sb = new StringBuffer(w);
        j=0;
        for (int i = s; i <e ; i++) {
            sb.setCharAt(i, strs[j++].toCharArray()[0]);
        }
        return sb.toString();
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

    private static String biggerisbetter(String word){
        if(word.length()==1) {return "no answer";}


        int maxLexoC1 = 0; //The max lexocographical according to condition 1
        int maxLexoC2 = 0; //The max lexocographical according to condition 2



        //Find the largest index char that is weakly increasing such as g in hefg
        for(int j = 1; j < word.length(); j++)
        {
            boolean condition1 = word.charAt(j) > word.charAt(j-1);

            if(condition1)
            {
                maxLexoC1 = (j > maxLexoC1) ? j : maxLexoC1;
            }
        }

        //if our only increasing is at point 0 then we are in the last permuation of our string
        if(maxLexoC1==0) {return "no answer";}

        //maxLexoC2
        //Determine the right most char greater than the pivot in index and in lexo
        for(int j = maxLexoC1; j < word.length(); j++)
        {
            boolean condition2 = word.charAt(j) > word.charAt(maxLexoC1-1);

            if(condition2)
            {
                maxLexoC2 = j;
            }
        }

        StringBuilder wordSB = new StringBuilder(word);

        //Swap the pivot with maxLexoC2
        char tmp = wordSB.charAt(maxLexoC1-1);
        wordSB.setCharAt(maxLexoC1-1, wordSB.charAt(maxLexoC2));
        wordSB.setCharAt(maxLexoC2, tmp);


        //Reverse starting at the element to the right of the pivot
        int left = maxLexoC1;
        int right = wordSB.length()-1;
        while(left < right)
        {
            //swap left with right
            tmp = wordSB.charAt(left);
            wordSB.setCharAt(left, wordSB.charAt(right));
            wordSB.setCharAt(right, tmp);
            left++;
            right--;
        }


//        System.out.println(wordSB);
        return wordSB.toString();
    }

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        for (int i = p; i <=q ; i++) {
            if(isKN(i)){
                System.out.print(i+" ");
            }
        }
    }

    static boolean isKN(int a){
//        if(a>77777 ){
//            System.out.println("Hi");
//        }
        BigInteger ab = new BigInteger(String.valueOf(a));
        BigInteger sq = ab.multiply(ab);
        int d = String.valueOf(sq.toString()).length();
        if(d>1){
            BigInteger a1 = new BigInteger(String.valueOf(sq).substring(0,d/2));
            BigInteger a2 = new BigInteger(String.valueOf(sq).substring(d/2));
            if(a1.add(a2).longValue() == ab.longValue()){
                return true;
            }
        }else{
            if( a == 1){
                return true;
            }
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println(encryption("haveaniceday"));
//        System.out.println(biggerIsGreater("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw"));
//        System.out.println(biggerIsGreater("zyyxwwtrrnmlggfeb"));
//        kaprekarNumbers(1,99999);
//        System.out.println(isKN(77778 ));
//        int arr[] =  {1, 2, 4, 5, 7, 8, 10};
//        System.out.println(beautifulTriplets(3,arr));
//        int ar[] = {7,1,3,4,1,7};
//        System.out.println(minimumDistances(ar));
//
//        // Create a Scanner object to read input from stdin.
//        Scanner scan = new Scanner(System.in);
//
//        // Read a full line of input from stdin and save it to our variable, inputString.
//        String inputString = scan.nextLine();
//
//        // Close the scanner object, because we've finished reading
//        // all of the input from stdin needed for this challenge.
//        scan.close();
//
//        // Print a string literal saying "Hello, World." to stdout.
//        System.out.println("Hello, World.");
//        System.out.println(inputString);

        // TODO: Write a line of code here that prints the contents of inputString to stdout.
        System.out.println(howManyGames(100,19,1,180));
    }

    static String timeInWords(int h, int m) {
//        String[] hour =
//        if(m == 0){
//            return
//        }
        return null;
    }

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int res = 0;
        int cost = p;
        if(p > s){
            return 0;
        }
        if(p == s){
            return 1;
        }
        while(cost>=m && s>0 && !(s<m) && s>=cost){
            if(s>=m){
                s = s-cost;
                res++;

                if(cost == m)
                    cost = cost-m;
                else
                    cost = cost-d;
            }
            if(cost <=m){
                cost = m;
            }
        }
        return res;
    }

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int l = arr.length;
        int count = 0;
        for (int i = 0; i < l; i++) {
            int ei = arr[i];
            for (int j = i+1; j < l; j++) {
                int ej = arr[j];
                int diffij = Math.abs(ej-ei);
                if(diffij == d){
                    for (int k = j+1; k < l; k++) {
                        int ek = arr[k];
                        int diffjk = Math.abs(ek-ej);
                        if(diffjk == d){
                            count++;
                        }
                    }
                }
            }
        }
        return count;

    }

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int l = a.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <l ; i++) {
            List<Integer> val = map.get(a[i]);
            if(val == null){
                val = new ArrayList<>();
            }
            val.add(i);
            map.put(a[i], val);
        }
        int min  = Integer.MAX_VALUE;
        for (List<Integer> value:
             map.values()) {
            int c = value.size();
            if(c>1){
                for (int i = 0; i < c-1 ; i++) {
                    min = Math.min(min, value.get(i+1)- value.get(i));
                }
            }
        }
        if(min == Integer.MAX_VALUE) min = -1;
        return min;


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
