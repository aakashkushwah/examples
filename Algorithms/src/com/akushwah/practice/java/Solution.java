package com.akushwah.practice.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}
class Add{
    public int add(int n, int... n1){
        System.out.print(n);
        for (int i = 0; i < n1.length; i++) {
            n+=n1[i];
            System.out.print("+"+n1[i]);

        }

        System.out.println("="+n);
        return n;
    }
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd(){
        return a -> a%2!=0;
    }

    public static PerformOperation isPrime(){
        return a -> {
            for (int i = 2; i < a; i++) {
                if(a%i == 0){
                    return false;
                }
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome(){
        return a -> new StringBuffer(String.valueOf(a)).reverse().toString().equals(String.valueOf(a));
    }
}
public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }

    public static String findDay(int month, int day, int year) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = day+"-"+month+"-"+year;
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateformat  = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
//        System.out.println(simpleDateformat.format(date));
        return simpleDateformat.format(date).toUpperCase();
    }

    private static boolean isProbablePrime(String n){
        if(n.equals("1")){
            return false;
        }
        int last = Integer.parseInt(n.charAt(n.length()-1)+"");
        if(last%2 == 0 || last ==5){
            return false;
        }
        char[] nc =n.toCharArray();

        long sum = 0;
        for (int i = 0; i <nc.length ; i++) {
            sum+=nc[i]-'0';
        }
        if(sum %3 ==0){
            return false;
        }

        BigInteger bn = new BigInteger(n);

        return bn.isProbablePrime(0);
    }
    public static void mainA(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numInput = Integer.parseInt(br.readLine());
        int[] ar = new int[numInput];
        String firstInput[] = br.readLine().split("\\s+");

        for (int j = 0; j < numInput; j++) {
            int arrItem = Integer.parseInt(firstInput[j]);
            ar[j] = arrItem;
        }


        System.out.println(subArray(ar));

        br.close();
    }

    static boolean isAnagram(String a, String b) {
        if(a.length()!=b.length()){
            return false;
        }
        char[] ac = a.toLowerCase().toCharArray();
        char[] bc = b.toLowerCase().toCharArray();

        sort(ac);
        sort(bc);


        return String.valueOf(ac).equals(String.valueOf(bc));
    }

    static void sort(char[] ar){
        countSort(ar, 'a', 'z');
    }

    public static void countSort(char arr[], int min, int max){
        int[] carr = new int[max-min + 1];
        for (int i = 0; i <arr.length ; i++) {
            carr[arr[i]-min]++;
        }
        int j=0;
        for (int i = min; i <=max ; i++) {
            while(carr[i-min]>0){
                arr[j++] = (char)i;
                carr[i-min]--;
            }
        }
    }



    private static int subArray(int[] arr) {
        int n = arr.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int sum=0;
                for(int k=i;k<=j;k++)
                {
                    sum=sum+arr[k];
                }
                if(sum<0)
                {
                    //System.out.println("["+i+":"+j+"]");
                    ans=ans+1;

                }
            }
        }
        return ans;
    }
}
