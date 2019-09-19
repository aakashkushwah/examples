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

public class Solution1 {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int result[] = new int[2];
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)>b.get(i)){
                result[0]++;
            }else if(a.get(i)<b.get(i)){
                result[1]++;
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

//        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "));
//                        + "\n";
//        );
        result.stream().forEach(System.out::println);
        bufferedReader.close();
//        bufferedWriter.close();
    }
}

