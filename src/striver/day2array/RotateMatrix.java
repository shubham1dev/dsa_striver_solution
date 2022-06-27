package striver.day2array;

import util.CommonUtil;

public class RotateMatrix {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                if(i!=j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for(int i=0;i<n;i++){

            int p=0,q=m-1;
            while(p<q){
                int temp = matrix[i][p];
                matrix[i][p] = matrix[i][q];
                matrix[i][q] = temp;
                p++;
                q--;

            }

        }

    }

    public static void main(String []args){

        int [][]mat = CommonUtil.getMatrixInput();
        new RotateMatrix().rotate(mat);
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }

}
