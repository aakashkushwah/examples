package com.akushwah.practice.java;


import java.util.*;

// Write your Checker class here

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {

        int res =  Integer.valueOf(o2.score).compareTo(Integer.valueOf(o1.score));
        if(res == 0){
            res = o1.name.compareTo(o2.name);
        }
        return res;
    }
}

public class ComparatorProblem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}