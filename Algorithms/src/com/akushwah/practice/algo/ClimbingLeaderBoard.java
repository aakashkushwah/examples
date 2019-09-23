package com.akushwah.practice.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ClimbingLeaderBoard {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        int l = scores.length;
        int rank[] = new int[l];

        rank[0] = 1;
        for (int i = 1; i < l; i++) {
            if (scores[i] == scores[i - 1]) {
                rank[i] = rank[i - 1];
            } else if (scores[i] < scores[i - 1]) {
                rank[i] = rank[i - 1] + 1;
            }
        }

        int lastRankVisited = l - 1;
        boolean topRank = false;
        int prevScore = -1;
        int aliceRank = rank[rank.length-1] + 1;
        int z = 0;
        for (int aliceScores = 0; aliceScores < alice.length; aliceScores++) {
            int levelScore = alice[aliceScores];

            //We iterate 1 past the front of the array incase we are greater than the best score
            for(int i = lastRankVisited; i >= -1; i--)
            {
                if(i < 0 || scores[i] > levelScore)
                {
//                    System.out.println(aliceRank);
                    res[z++] = aliceRank;
                    break;
                }
                else if(scores[i] < levelScore)
                {
                    if(scores[i] != prevScore)//We have went up a ranking
                    {
                        aliceRank--;
                    }
                    lastRankVisited--;
                }
                else//scores[i] == alice[level]
                {
                    lastRankVisited--;
                    aliceRank = rank[i];
                }
                prevScore = scores[i];
            }
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
