package com.akushwah.practice;

import java.util.Scanner;

public class StringGFGRotation2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int sol[] = new int[T];
        for (int i=0;i<T;i++){
            String in1 = sc.next();
            String in2 = sc.next();
            sol[i] = getOutput(in1,in2);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(sol[i]);
        }

//        System.out.println(getOutput("amazon", "azonam"));
    }

    private static int getOutput(String in1, String in2){
        String rot = rotateByN(in2,2,true);
        if(rot.equals(in1)){
            return 1;
        }else{
            rot = rotateByN(in2,2,false);
            if(rot.equals(in1)){
                return 1;
            }
        }
        return 0;
    }

    private static String rotateByN(String in, int n, boolean rightRotate) {
        char[] arr = in.toCharArray();
        if (n > arr.length) {
            n = n % arr.length;
        }
        if (rightRotate) {
            char temp[] = new char[n];
            System.arraycopy(arr, 0, temp, 0, n);
            System.arraycopy(arr, n, arr, 0, arr.length - n);
            System.arraycopy(temp, 0, arr, arr.length - n, n);
        } else {
            char temp[] = new char[n];
            System.arraycopy(arr, arr.length - n, temp, 0, n);
            System.arraycopy(arr, 0, arr, n, arr.length - n);
            System.arraycopy(temp, 0, arr, 0, n);
        }
        return String.valueOf(arr);
    }
}
