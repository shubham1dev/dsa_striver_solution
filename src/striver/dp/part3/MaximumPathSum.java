package striver.dp.part3;

public class MaximumPathSum {

    public static int solve(int[][] mat, int i, int j, int n, int m, int[][]mem) {

        if(i==n-1 && j<m && j>=0){
            return mat[i][j];
        }
        else if(i>=n || j>=m || j<0)
            return Integer.MIN_VALUE;
        else {

            if(mem[i][j]==-1){

                int val = Integer.MIN_VALUE;
                int a = solve(mat,i+1,j, n, m, mem);
                int b = solve(mat, i+1, j+1,n,m,mem);
                int c = solve(mat, i+1, j-1,n,m,mem);

                if(a==b && b==c && b==Integer.MIN_VALUE)
                    mem[i][j] = Integer.MIN_VALUE;
                else{
                    val = Math.max(val,a);
                    val = Math.max(val,b);
                    val = Math.max(val,c);
                    mem[i][j] = mat[i][j]+val;
                }
            }
            return mem[i][j];

        }

    }

    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][]mem = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                mem[i][j]=-1;
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            ans = Math.max(ans, solve(matrix, 0,i, n,m, mem));
        }
        return ans;
    }

    public static void main(String []args) {


    }

}
