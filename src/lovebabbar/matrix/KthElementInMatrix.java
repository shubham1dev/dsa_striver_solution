package lovebabbar.matrix;

import util.CommonUtil;

import java.util.Scanner;

public class KthElementInMatrix {

    public static void main(String []args){

        int [][]mat = CommonUtil.getMatrixInput();
        int n = mat.length;
        int m = mat[0].length;
        int k = new Scanner(System.in).nextInt();
        int []ans = new int[n*m];
        int p = 0;
        int i = 1;
        boolean addFirst = true;
        for(int j=1;j<=m;j++){


            i = 1;
            if(addFirst){
                ans[p] = mat[0][j-1];
                p++;
                addFirst = false;
            }
            if(j==m){
                while(i<n){
                    ans[p]=mat[i][m-1];
                    p++;
                    i++;
                }
                break;
            }
            while(i<n && mat[i][j-1]<=mat[0][j]){
                ans[p] = mat[i][j-1];
                p++;
                i++;
            }
            if(i==n){
                addFirst = true;
            }
            else{
                ans[p]=mat[0][j];
                p++;
                while(i<n){
                    ans[p] = mat[i][j-1];
                    p++;
                    i++;
                }
            }

        }


        for(i=0;i<(n*m);i++){
            System.out.print(ans[i]+ "  ");
        }


    }


}
