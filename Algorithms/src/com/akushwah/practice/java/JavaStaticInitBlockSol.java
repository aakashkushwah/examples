package com.akushwah.practice.java;

import java.util.Scanner;

public class JavaStaticInitBlockSol {
    static int B,H;
    static boolean flag;
    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        if(B >0 && H > 0){
            flag = true;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        if(flag){
            int area=B*H;
            System.out.print(area);
        }else{
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }
}
