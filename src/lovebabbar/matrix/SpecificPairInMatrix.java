package lovebabbar.matrix;

import util.CommonUtil;

public class SpecificPairInMatrix {

    public static void main(String[] args){
        int [][]mat = CommonUtil.getMatrixInput();
        int n = mat.length;
        int m = mat[0].length;

        int [][]maxv = new int[n][m];
        int [][]minv = new int[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            int ma = mat[i][m-1];
            maxv[i][m-1] =  ma;
            for(int j=m-2;j>=0;j--){
                ma = Math.max(ma, mat[i][j]);
                maxv[i][j] = ma;
            }
        }

        for(int i=0;i<m;i++){
            int ma = maxv[n-1][i];
            for(int j=n-2;j>=0;j--){
                ma = Math.max(ma, maxv[j][i]);
                maxv[j][i]=ma;
            }
        }

        for(int i=0;i<n;i++){
            int ma = maxv[i][m-1];
            maxv[i][m-1] =  ma;
            for(int j=m-2;j>=0;j--){
                ma = Math.max(ma, maxv[i][j]);
                maxv[i][j] = ma;
            }
        }


        for(int i=0;i<(n-1);i++){
            for(int j=0;j<(m-1);j++){
                int val = maxv[i+1][j+1]-mat[i][j];
                ans = Math.max(ans, val);
            }
        }

        System.out.println(ans);


    }

}
