package striver.day3array;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePath {

    public int solve(int i, int j, int m, int n, int[][] mem){

        if(i==m-1 && j==n-1){
            return 1;
        }
        else if(i==m || j==n){
            return 0;
        }
        else {

            if(mem[i][j]==-1){

                mem[i][j] = solve(i+1,j,m,n,mem)+solve(i,j+1, m, n, mem);

            }
            return mem[i][j];

        }

    }

    public int uniquePaths(int m, int n) {

        int [][] mem = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(mem[i],-1);
        }
        return solve(0,0,m,n,mem);

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int m =  sc.nextInt();
        int n = sc.nextInt();
        int ans = new UniquePath().uniquePaths(m,n);
        System.out.println(ans);

    }



}
