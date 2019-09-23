package com.akushwah.practice.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaEndOfFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i=0;
        List<String> list = new ArrayList<>();
        String s = "";
        while(scan.hasNext() && !s.contains("EOF")){
            s = scan.nextLine();
            list.add(s);
        }
        for (String s1:
             list) {
            System.out.println(++i+" "+s1);
        }
    }
}
