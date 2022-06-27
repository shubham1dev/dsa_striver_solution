package striver.dp.part5;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int solve(String s, String t, int n, int m, int i, int j, int [][]mem){

        if(i==n || j==m){
            return 0;
        }

        if(mem[i][j]!=-1)
            return mem[i][j];

        else {

            if(s.charAt(i)==t.charAt(j)){
                mem[i][j]= 1+solve(s, t, n, m, i+1, j+1,mem);
            }
            else {

                mem[i][j]= Math.max(solve(s, t, n, m, i+1, j,mem), solve(s,t,n,m, i,j+1,mem));

            }
            return mem[i][j];

        }

    }

    public static int lcs(String s, String t) {

        int [][]mem = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
            Arrays.fill(mem[i],-1);
        return solve(s,t, s.length(), t.length(), 0,0, mem);
    }

    public static void main(String []args) {



    }

}
