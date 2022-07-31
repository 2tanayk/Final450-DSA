package dynamicprogramming;

import java.util.*;

public class AssemblyLineScheduling {
    // static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] t = new int[2][n];
        int[][] s = new int[2][n];

        for (int i = 0; i < n; i++) {
            t[0][i] = sc.nextInt();
            t[1][i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            s[0][i] = sc.nextInt();
            s[1][i] = sc.nextInt();
        }

        int[] entry = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < 2; i++) {
            entry[i] = sc.nextInt();
            exit[i] = sc.nextInt();
        }

        System.out.println(carAssembly(n, t, s, entry, exit));
    }

    private static int carAssembly(int n, int[][] t, int[][] s, int[] entry, int[] exit) {
        // dp=new int[2][n];

        // Arrays.fill(dp[0],-1);
        // Arrays.fill(dp[1],-1);

        //  int min=Integer.MAX_VALUE;

        // for(int i=0;i<2;i++){
        //     min=Math.min(min, entry[i] + minTime(s,i,0,t,exit));
        // }

        t[0][0] += entry[0];
        t[1][0] += entry[1];


        t[0][n - 1] += exit[0];
        t[1][n - 1] += exit[1];

        for (int j = n - 2; j >= 0; j--) {
            t[0][j] += Math.min(t[0][j + 1], s[0][j + 1] + t[1][j + 1]);
            t[1][j] += Math.min(t[1][j + 1], s[1][j + 1] + t[0][j + 1]);
        }

        return Math.min(t[0][0], t[1][0]);
    }

    // private static int minTime(int[][] s, int i, int j, int[][] t, int[] exit){
    //     int n=s[0].length;

    //     if(j==n-1){
    //         return t[i][j] + exit[i];
    //     }

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     int min=Integer.MAX_VALUE;

    //     min=Math.min(min,minTime(s,i,j+1,t,exit));

    //     if(i==0){
    //         min=Math.min(min,s[i][j+1] + minTime(s,i+1,j+1,t,exit));
    //     }else{
    //         min=Math.min(min,s[i][j+1] + minTime(s,i-1,j+1,t,exit));
    //     }

    //     dp[i][j]=t[i][j]+min;

    //     return dp[i][j];
    // }
}
