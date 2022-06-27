package striver.dp.part3;

public class MinimumPathSum {

    public static int solve(int[][] grid, int i, int j, int n, int m, int[][] mem) {

        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        else if(i>=n || j>=m) {
            return Integer.MAX_VALUE;
        }
        else {

            if(mem[i][j]==-1){

                int val = Math.min(solve(grid, i+1, j, n, m, mem),solve(grid, i, j+1, n, m, mem));
                if(val==Integer.MAX_VALUE)
                    mem[i][j] = val;
                else
                    mem[i][j] = grid[i][j]+val;
            }
            return mem[i][j];

        }

    }

    public static int minSumPath(int[][] grid) {

        int [][] mem = new int [grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
                mem[i][j]=-1;
        }
        return solve(grid,0,0,grid.length, grid[0].length, mem);

    }

    public static void main(String []args) {


    }

}
