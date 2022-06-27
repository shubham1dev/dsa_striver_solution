package striver.dp.part2;


import java.util.Scanner;

public class ClimbingStairs {

    public static int factor = 1000000007;

    public static int solve(int n, int i, int []dp){

        if(i>n)
            return 0;
        else if(i==n)
            return 1;
        else {

            if(dp[i]==-1)
            dp[i] = ((solve(n,i+1, dp)%factor)+(solve(n, i+2, dp)%factor))%factor;
            return dp[i];

        }

    }

    public static int countDistinctWayToClimbStair(long nStairs) {
        // Write your code here.
        int []dp = new int[(int)nStairs];
        for(int i=0;i<nStairs;i++){
            dp[i]=-1;
        }
        long ans = solve((int)nStairs, 0, dp);
        return (int)(ans%1000000007);
    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long inp = sc.nextLong();
            int ans = countDistinctWayToClimbStair(inp);
            System.out.println(ans);
        }

    }

}
