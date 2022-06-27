package striver.dp.part7;

import java.util.Arrays;

public class LSC {

    public static boolean check(String s1, String s2, int n, int m) {

        boolean match = true;
        int i = 0,j=0;
        while(i<n && j<m) {
            if(s1.charAt(i)!=s2.charAt(j)){
                if(match) {
                    j++;
                    match = false;
                    continue;
                }
                else
                    return false;
            }
            i++;
            j++;
        }

        return true;


    }

    public static int solve(int  i, int j, int n, String []arr, int [][]mem) {

        if(i==n)
            return 0;
        else if(mem[i][j]!=-1)
            return mem[i][j];
        else {

            if(j==n) {

                mem[i][j] = Math.max(solve(i+1,j, n, arr, mem),1+solve(i+1, i, n, arr, mem));

            }
            else if(arr[i].length()==(arr[j].length()+1)){
                boolean isValid = check(arr[j], arr[i], arr[j].length(), arr[i].length());
                if(isValid) {
                    mem[i][j] = Math.max(solve(i+1, j, n, arr, mem), 1+solve(i+1, i, n, arr,mem));
                }
                else {
                    mem[i][j] =  solve(i+1,j,n,arr,mem);
                }
            }
            else {
                mem[i][j] = solve(i+1,j, n, arr, mem);
            }

            return mem[i][j];

        }

    }

    public static int longestStrChain(int n, String[] arr) {
        // Write your code here.
        int [][]mem = new int[n][n+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(mem[i],-1);
        }
        return solve(0,n,n,arr, mem);
    }



}
