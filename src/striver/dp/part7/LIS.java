package striver.dp.part7;

import java.util.Arrays;

public class LIS {

    public static int solve(int i, int pi, int []arr, int n, int[][]mem) {

        if(i>=n)
            return 0;
        else if(mem[i][pi]!=-1)
            return mem[i][pi];
        else {

            if(pi==n) {
                mem[i][pi] =  Math.max(solve(i+1, pi, arr, n,mem), 1+solve(i+1, i, arr, n,mem));
            }
            else{

                if(arr[i]>arr[pi]){
                    mem[i][pi] =  Math.max(solve(i+1, pi, arr,n,mem), 1+solve(i+1, i, arr,n,mem));
                }
                else {
                    mem[i][pi] = solve(i+1, pi, arr, n,mem);
                }

            }
            return mem[i][pi];

        }

    }

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n = arr.length;
        int [][]mem = new int[n][n+1];
        for(int i=0;i<n;i++)
            Arrays.fill(mem[i],-1);
        return solve(0, n, arr,n, mem);
    }
}
