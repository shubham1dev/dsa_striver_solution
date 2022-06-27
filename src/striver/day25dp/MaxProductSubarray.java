package striver.day25dp;

import util.CommonUtil;

public class MaxProductSubarray {

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        int n = arr.length;
        int ans = 0;
        int cr = 1;
        for(int i=0;i<n;i++){

            if(arr[i]==0){
                cr=1;
                continue;
            }

            cr*=arr[i];
            ans = Math.max(ans, cr);
        }

        System.out.println(ans);

    }

}
