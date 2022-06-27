package striver.day4array;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mymap = new HashMap<>();
        int []ans = new int[2];
        for(int i=0;i<nums.length;i++){

            if(mymap.containsKey(target-nums[i])){
                ans[1] = i;
                ans[0] = mymap.get(target-nums[i]);
                return ans;
            }
            mymap.put(nums[i],i);

        }
        return ans;
    }

    public static void main(String []args) {


        int []arr = CommonUtil.getArrayInput();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int []ans = new TwoSum().twoSum(arr,t);
        System.out.println(ans[0]+" "+ans[1]);

    }

}
