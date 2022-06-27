package striver.dp.part3;

import java.util.ArrayList;
import java.util.Scanner;

public class UniquePath2 {

    public static int solve(int i, int j, int m, int n, ArrayList<ArrayList<Integer>> mat, int [][]mem){

        if(i==m-1 && j==n-1)
            return 1;
        else if(i>=m || j>=n )
            return 0;
        else if(mat.get(i).get(j)==-1)
            return 0;
        else {

            if(mem[i][j]==-1)
                mem[i][j] = solve(i+1, j, m, n,mat,mem)+solve(i,j+1, m, n,mat,mem);
            return mem[i][j];

        }

    }


    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        int [][] mem = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                mem[i][j]=-1;
        }
        return solve(0, 0,mat.size(), mat.get(0).size(),mat,mem);
    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = mazeObstacles(0,0,new ArrayList<>());
        System.out.println(ans);

    }

}
