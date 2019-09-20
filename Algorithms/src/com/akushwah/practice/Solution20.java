package com.akushwah.practice;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution20 {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 1;
        Set<Integer> res = new HashSet<>();
        res.add(arr.get(0));
        for (int x :
                arr) {
            Integer val = map.get(x);
            if (val == null) {
                val = 0;
            }
            val++;
            int localMax = Math.max(maxCount, val);
            if (localMax > maxCount) {
                res.clear();
                res.add(x);
                maxCount = localMax;
            } else if(maxCount == val){
                res.add(x);
            }
            map.put(x, val);
        }

        return res.stream().sorted().findFirst().get();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
