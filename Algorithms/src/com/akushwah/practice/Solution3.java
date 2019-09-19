package com.akushwah.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int ml = arr.size();
        int[][] matrix = new int[ml][ml];
        int rowC = 0;
        for (List<Integer> rowList:
             arr) {
            matrix[rowC++] = rowList.stream().mapToInt(i->i).toArray();
        }
        int leftS = 0;
        int rightS = 0;
        for (int i = 0; i < ml; i++) {
            for (int j = 0; j < ml ; j++) {
                if(i==j){
                    leftS+=matrix[i][j];
                    int rightDRowIndex = Math.abs(ml-i-1);
                    rightS+=matrix[rightDRowIndex][j];
                }
            }
        }
        return Math.abs(leftS-rightS);
    }

}

//Given a square matrix, calculate the absolute difference between the sums of its diagonals.
public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = null;
        final String fileName = System.getenv("OUTPUT_PATH");
        if (fileName != null) {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        } else {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
