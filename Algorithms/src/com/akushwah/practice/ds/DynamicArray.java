package com.akushwah.practice.ds;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        ArrayList<Integer> s[] = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            s[i] = new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int lastAnser = 0;
        for (List<Integer> list:
             queries) {
            int seq = xor(list.get(1), lastAnser) % n;

            if(list.get(0) == 1){
                s[seq].add(list.get(2));
            }else if(list.get(0) == 2){
                List<Integer> sl = s[seq];
                int size = sl.size();
                int y = list.get(2);
                lastAnser = sl.get(y%size);
                res.add(lastAnser);
            }

        }
        return res;

    }

    private static int query1(int[] arr, int N, int lastAnswer){
        int seq = xor(arr[1], lastAnswer) %N;
        return arr[2]+arr[seq];
    }

    private static int query2(int[] arr, int N, int lastAnswer){
        int seq = xor(arr[1], lastAnswer) %N;
        return arr[2]+arr[seq];
    }

    public static int xor(int a, int b){
        return a ^ b;
    }

}
