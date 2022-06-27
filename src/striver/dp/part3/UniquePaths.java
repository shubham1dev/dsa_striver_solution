package striver.dp.part3;

import java.util.Scanner;

public class UniquePaths {

    public static int solve(int i, int j, int m, int n, int [][]mem){

        if(i==m-1 && j==n-1)
            return 1;
        else if(i>=m || j>=n)
            return 0;
        else {

            if(mem[i][j]==-1)
            mem[i][j] = solve(i+1, j, m, n,mem)+solve(i,j+1, m, n,mem);
            return mem[i][j];
        }

    }

    public static int uniquePaths(int m, int n) {

        int [][] mem = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                mem[i][j]=-1;
        }
        return solve(0, 0, m,n,mem);

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = uniquePaths(m,n);
        System.out.println(ans);

    }

}
