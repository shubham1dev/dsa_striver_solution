package striver.day4array;

import util.CommonUtil;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    static int maxLen(int arr[], int n)
    {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int ans = 0;
        map.put(0,-1);
        for(int i=0;i<n;i++) {

            prefix+=arr[i];
            if(map.containsKey(prefix)){
                ans = Math.max(i-map.get(prefix), ans);

            }
            else {
                map.put(prefix, i);
            }

        }
        return ans;
    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        int ans = maxLen(arr, arr.length);
        System.out.println(ans);

    }



}
