package striver.day1array;

import util.CommonUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SetMatrixZero {

    public static void main(String[] args){

        int[][]matrix = CommonUtil.getMatrixInput();
        int n = matrix.length;
        int m = matrix[0].length;

        //brute force
//
//        Set<Integer> rows = new HashSet<>();
//        Set<Integer> cols = new HashSet<>();
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//
//                if(matrix[i][j]==0){
//                    rows.add(i);
//                    cols.add(j);
//                }
//
//            }
//        }
//
//        rows.forEach(row -> {
//            Arrays.fill(matrix[row],0);
//        });
//
//        cols.forEach(col -> {
//            IntStream.range(0,n).forEach(i->{
//                matrix[i][col]=0;
//            });
//        });

        //optimal

        boolean row=false,col=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;

                    if(i==0)
                        row = true;
                    if(j==0)
                        col = true;

                }
            }
        }

        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }

        for(int j=1;j<m;j++){
            if(matrix[0][j]==0){
                for(int r = 0;r<n;r++){
                    matrix[r][j]=0;
                }
            }
        }

        if(row){
            for(int i=0;i<m;i++){
                matrix[0][i]=0;
            }
        }
        if(col){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }

}
