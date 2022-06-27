package striver.dp.part6;

import java.util.ArrayList;

public class StockBS1 {

    public static int maximumProfit(ArrayList<Integer> prices){

        int []amin = new int[prices.size()];
        int []amax = new int[prices.size()];

        int mv = Integer.MAX_VALUE;
        for(int i=0;i<prices.size();i++) {

            mv = Math.min(mv, prices.get(i));
            amin[i] = mv;

        }

        mv = Integer.MIN_VALUE;
        for(int i=0;i<prices.size();i++) {

            mv = Math.max(mv, prices.get(prices.size()-i-1));
            amax[prices.size()-i-1] = mv;

        }

        int ans = 0;
        for(int i=1;i<prices.size();i++){

            ans = Math.max(ans, amax[i]-amin[i-1]);

        }

        return ans;

    }

    public static void main(String []args) {


    }



}
