package com.company.test2.recursion;

public class MainRecur {
    public static int iterativeFact(int n){
        if(n == 0)
            return 1;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *=i;
        }
        return res;
    }

    public static int recursiveFact(int n){
        if(n == 0)
            return 1;
        return n*recursiveFact(n-1);
    }

    public static void main(String[] args) {
        System.out.println(recursiveFact(12));
        System.out.println(iterativeFact(10));
    }
}
