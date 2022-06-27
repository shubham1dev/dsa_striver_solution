package striver.dp.part5;

import java.util.Arrays;

public class EditDistance {

    public static int solve(String s1, String s2, int i, int j, int n, int m,int [][]mem) {

        if(i==n) {
            if(j<m)
                return m-j;
            return 0;
        }
        else if(j==m) {
            return n - i;
        }
        else if(mem[i][j]!=-1) {
            return mem[i][j];
        }
        else {

            if(s1.charAt(i)==s2.charAt(j)){
                mem[i][j]= solve(s1,s2,i+1,j+1,n,m,mem);
                return mem[i][j];
            }
            else {

                int val1 = solve(s1, s2, i+1,j+1,n, m,mem);
                int val2 = solve(s1, s2,i+1, j,n, m,mem);
                int val3 = solve(s1,s2, i,j+1,n,m,mem);
                int ans = Math.min(val1, val2);
                ans = Math.min(ans,val3);
                mem[i][j] =  ans+1;
                return mem[i][j];
            }

        }

    }

    public static int editDistance(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        if(n>m){
            int [][]mem = new int[n][m];
            for(int i=0;i<n;i++)
                Arrays.fill(mem[i],-1);
            return solve(str1,str2, 0,0,n,m,mem);
        }
        else {
            int [][]mem = new int[m][n];
            for(int i=0;i<m;i++)
                Arrays.fill(mem[i],-1);
            return solve(str2, str1, 0, 0, m, n,mem);
        }
    }

    public static void main(String []args) {



    }

}
