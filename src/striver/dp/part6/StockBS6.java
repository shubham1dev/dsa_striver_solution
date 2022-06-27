package striver.dp.part6;

import java.util.Arrays;

public class StockBS6 {


    public static int solve(int n, int i, int f, int buy, int[]prices, int[][]mem) {

        if(i>=n)
            return 0;
        else if(mem[buy][i]!=-1)
            return mem[buy][i];
        else {

            if(buy==1)
                mem[buy][i] = Math.max(solve(n, i+1, f, buy, prices, mem),-prices[i]-f+solve(n, i+1, f, 0, prices,mem));
            else
                mem[buy][i] = Math.max(solve(n, i+1, f,  buy, prices, mem), prices[i]+solve(n, i+1, f, 1, prices, mem));
            return mem[buy][i];

        }

    }

    public static int maximumProfit(int n, int fee, int[] prices) {
        int [][]mem = new int[2][prices.length];
        for(int i=0;i<2;i++){
            Arrays.fill(mem[i],-1);
        }
        return solve(n, 0, fee, 1, prices, mem);
    }


}
