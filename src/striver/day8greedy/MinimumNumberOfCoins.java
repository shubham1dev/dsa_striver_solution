package striver.day8greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfCoins {

    public static int solve(int []coins, int n, int i, int ts, int v, int[]dp){

        if(ts==v){
            return 0;
        }
        else if(ts>v){
            return Integer.MAX_VALUE;
        }
        else {

            if(dp[ts]==-1) {
                int ans = Integer.MAX_VALUE;
                for (int j = i; j < n; j++) {
                    ans = Math.min(ans, solve(coins, n, j, ts + coins[j], v, dp));
                }
                if (ans == Integer.MAX_VALUE)
                    dp[ts]=Integer.MAX_VALUE;
                else
                    dp[ts]=  ans + 1;
            }
            return dp[ts];
        }

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int []coins = new int[n];
            for(int i=0;i<n;i++)
                coins[i] = sc.nextInt();

            int V = sc.nextInt();

            int []dp = new int[V+1];
            Arrays.fill(dp,-1);
            int ans = solve(coins, coins.length,0,0,V, dp);
            System.out.println(ans);

        }

    }


}
