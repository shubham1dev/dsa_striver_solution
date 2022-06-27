package striver.dp.part6;

import java.util.Arrays;

public class StockBS5 {

    public static int solve(int []prices, int i, int n, int buy, int[][]mem) {

        if(i>=n)
            return 0;
        else if(mem[buy][i]!=-1)
            return mem[buy][i];
        else {

            if(buy==1) {
                mem[buy][i] = Math.max(solve(prices, i+1, n, buy, mem), -prices[i]+solve(prices, i+1, n, 0, mem));
            }
            else {
                mem[buy][i] = Math.max(solve(prices,i+1, n, buy,mem), prices[i]+solve(prices, i+2, n, 1, mem));
            }
            return mem[buy][i];

        }

    }

    public static int stockProfit(int[] prices) {
        int [][]mem = new int[2][prices.length];
        for(int i=0;i<2;i++){
            Arrays.fill(mem[i],-1);
        }
        return solve(prices, 0, prices.length, 1, mem);
    }

    public static void main(String []args) {



    }

}
