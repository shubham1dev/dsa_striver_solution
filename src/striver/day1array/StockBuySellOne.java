package striver.day1array;

import util.CommonUtil;

public class StockBuySellOne {

    public int maxProfit(int[] prices) {

        if(prices.length<=1)
            return 0;

        int n = prices.length;
        int maxProfit = 0;
        int maxv = prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxv = Math.max(maxv, prices[i+1]);
            maxProfit = Math.max(maxProfit, maxv-prices[i]);
        }
        return maxProfit;

    }

    public static void main(String[] args){
        int []arr = CommonUtil.getArrayInput();
        System.out.println(new StockBuySellOne().maxProfit(arr));

    }

}
