package lovebabbar.matrix;

import util.CommonUtil;

public class RotateMatrixBy90 {

    public static void reverse(int [][]mat, int i, int j){
        int p = 0;
        while(p<j){
            int temp = mat[i][p];
            mat[i][p] = mat[i][j];
            mat[i][j] = temp;
            p++;
            j--;
        }
    }

    public static void main(String []args){

        int [][]mat = CommonUtil.getMatrixInput();
        int n = mat.length;
        int m = mat.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }
        }

        for(int i=0;i<n;i++){

            reverse(mat, i, m-1);

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                System.out.print(mat[i][j]+" ");

            }
            System.out.println();
        }


    }

}
