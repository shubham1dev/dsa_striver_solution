package striver.dp.part3;

public class TraingularPath {

    public static int solve(int i, int j, int n, int[][] traingle, int[][]mem) {

        if(i==n-1 && j<=i){
            return traingle[i][j];
        }
        else if(i>=n || j>i)
            return Integer.MAX_VALUE;
        else {

            if(mem[i][j]==-1){
                int val = Math.min(solve(i+1,j,n,traingle, mem), solve(i+1, j+1,n, traingle, mem));
                if(val==Integer.MAX_VALUE)
                    mem[i][j] = val;
                else
                    mem[i][j] = traingle[i][j]+val;
            }
            return mem[i][j];
        }

    }

    public static int minimumPathSum(int[][] triangle, int n) {

        int [][] mem = new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                mem[i][j]=-1;
        }
        return solve(0,0,n, triangle,mem);

    }

    public static void main(String []args) {



    }

}
