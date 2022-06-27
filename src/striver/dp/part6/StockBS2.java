package striver.dp.part6;

import java.util.Arrays;

public class StockBS2 {

    public static long solve(int n, int i, long[]values, int buy, long[][] mem) {

        if(i==n)
            return 0;

        if(mem[buy][i]!=-1)
            return mem[buy][i];

        else  {

            if(buy==1) {


                mem[1][i] = Math.max(solve(n, i+1, values, buy,mem), -values[i]+solve(n,i+1, values, 0,mem));
                return mem[1][i];
            }
            else {

                mem[0][i]= Math.max(solve(n,i+1, values, buy, mem), values[i]+solve(n, i+1, values, 1,mem));
                return mem[0][i];
            }

        }


    }

    public static long getMaximumProfit (int n, long[] values) {

        long [][]mem = new long[2][n];
        for(int i=0;i<2;i++) {
            Arrays.fill(mem[i],-1);
        }
        return solve(n,0,values, 1, mem);

    }

    public static void main(String []args) {

    }

}
