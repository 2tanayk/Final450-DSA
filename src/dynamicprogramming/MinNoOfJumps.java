package dynamicprogramming;

import java.util.*;

public class MinNoOfJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        int n = arr.length;

        // int ans=solve(arr,0);

        // return ans==Integer.MAX_VALUE?-1:ans;

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }

                if (arr[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }

    // private static int solve(int[] arr, int i){
    //     int n=arr.length;
    //     if(i >= n-1){
    //         return 0;
    //     }

    //     if(arr[i]==0){
    //         return Integer.MAX_VALUE;
    //     }

    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }


    //     int min=Integer.MAX_VALUE;

    //     for(int k=1;k<=arr[i];k++){
    //         int jumps=solve(arr,i+k);

    //         if(jumps==Integer.MAX_VALUE){
    //             continue;
    //         }

    //         min=Math.min(min,1+jumps);
    //     }

    //     return dp[i]=min;
    // }
}
