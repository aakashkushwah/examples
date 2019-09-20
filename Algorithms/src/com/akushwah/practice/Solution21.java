package com.akushwah.practice;

import java.io.*;

public class Solution21 {
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        if(year == 1918){
            return "26.09.1918";
        }
        return year <= 1917 ? julian(year) : gregorian(year);
    }

    private static String julian(int year) {
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            isLeapYear = true;
        }
        return isLeapYear ? "12.09." + year : "13.09." + year;
    }

    private static String gregorian(int year) {
        boolean isLeapYear = false;
        if (year % 4 == 0 && year % 100 != 0) {
            isLeapYear = true;
        } else if (year % 400 == 0) {
            isLeapYear = true;
        }
        return isLeapYear ? "12.09." + year : "13.09." + year;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
