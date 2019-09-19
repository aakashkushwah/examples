package com.akushwah.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution8 {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int l = s.length();
        char amPM = s.charAt(l-2);
        boolean add12 = false;
        if(amPM == 'P' || amPM == 'p'){
            add12 = true;
        }
        String result = null;
        StringBuffer sb = new StringBuffer(s);
        int hour = Integer.valueOf(sb.substring(0,2));
        if(add12){
            sb.replace(0,2, hour == 12 ? "12": String.valueOf(hour+12));
        } else{
            if(hour == 12){
                sb.replace(0,2, "00");
            }
        }


        return sb.substring(0,l-2);

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
