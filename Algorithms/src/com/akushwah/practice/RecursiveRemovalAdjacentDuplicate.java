package com.akushwah.practice;

import java.util.Scanner;
import java.util.Stack;

public class RecursiveRemovalAdjacentDuplicate {
    public static void main(String[] args) {
//        String in = "aaaaaaaaaaaaa";
//        Scanner sc=new Scanner(System.in);
//        int T=sc.nextInt();
//        for (int i=0;i<T;i++){
//            String in = sc.next();
//            System.out.println(recurSol(in));
//        }
//        System.out.println(iterativeSol(in));
//        System.out.println(recurSol(in));
//        in = "geeksforgeekss";
//        System.out.println(recurSol(in));
        String in = "mississipie";
        System.out.println(recurSol(in));
    }

    private static String recurSol(String in) {
        return removeDup(in, 0, false);
    }

    private static String removeDup(String in, int index, boolean cflag) {
        if (index <= in.length() - 2) {
            char[] inChar = in.toCharArray();
            int jumpLength = 1;
            while ((index + jumpLength) <= (inChar.length - 1) && inChar[index] == inChar[index + jumpLength]) {
                jumpLength++;
            }
            if (jumpLength > 1) {
                int len = inChar.length;
                char[] newArr = new char[len - (jumpLength)];
                System.arraycopy(inChar, index + (jumpLength), inChar, index, len - index - (jumpLength));
                System.arraycopy(inChar, 0, newArr, 0, len - (jumpLength));
                inChar = newArr;
                in = String.valueOf(inChar);
                cflag = true;
            }
            index++;
            return removeDup(in, index, cflag);
        } else{
            if(cflag){
                return removeDup(in, 0, false);
            }
        }
        return in;
    }

    private static String iterativeSol(String in) {
        char[] inChar = in.toCharArray();
        int len = inChar.length;
        int startPos = 0;
        while (startPos <= len - 2) {
            if (inChar[startPos] == inChar[startPos + 1]) {
                char[] newArr = new char[len - 2];
                System.arraycopy(inChar, startPos + 2, inChar, startPos, len - startPos - 2);
                System.arraycopy(inChar, 0, newArr, 0, len - 2);
                inChar = newArr;
                len = inChar.length;
            } else {
                startPos++;
            }
        }
        return String.valueOf(inChar);
    }

    static String fn(String str) {
        if (str.equals(""))
            return "";

        int i, j, k;
        int n = str.length();

        Stack<Character> s = new Stack<>();
        boolean flag = false;

        for (i = 0; i < n; i++)
            s.push(str.charAt(i));
        str = "";
        char c = s.peek();
        flag = false;
        s.pop();
        int key = 0; //to check if we need to check the answer again
        while (!s.isEmpty()) {
            //cout<<st.top()<<" ";
            if (s.peek() == c) {
                flag = true;
                key = 1;
            } else if (s.peek() != c) {
                if (flag == false)
                    str += c;
                c = s.peek();
                flag = false;
            }
            s.pop();
        }
        if (flag == false)
            str += c;
        StringBuilder ss = new StringBuilder(str);
        ss = ss.reverse();
        str = ss.toString();

        if (key == 1)
            str = fn(str);
        return str;
    }
}
