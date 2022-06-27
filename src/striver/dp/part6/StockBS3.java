package striver.dp.part6;

import java.util.ArrayList;
import java.util.Arrays;

public class StockBS3 {

    public static int solve(int n, int i, int k, int buy, ArrayList<Integer> price, int[][][] mem) {

        if(i==n || k==0)
            return 0;
        else if(mem[buy][k][i]!=-1){
            return mem[buy][k][i];
        }
        else {

            if(buy==1) {
               mem[buy][k][i] =  Math.max(solve(n, i+1, k, buy, price,mem), -price.get(i)+solve(n, i+1, k, 0, price,mem));
            }
            else
                mem[buy][k][i] = Math.max(solve(n, i+1, k, buy, price,mem), price.get(i)+solve(n, i+1, k-1, 1, price,mem));
            return mem[buy][k][i];
        }

    }

    public static int maxProfit(ArrayList<Integer> prices, int n) {

        int [][][]mem = new int[2][3][n];
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                Arrays.fill(mem[i][j],-1);
            }
        }
        return solve(n, 0, 2, 1, prices,mem);

    }

}
