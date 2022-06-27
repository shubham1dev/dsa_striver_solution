package striver.day1array;

import util.CommonUtil;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){

            if(nums[i]>(nums[i]+sum)){
                sum = nums[i];

            }
            else{
                sum = sum+nums[i];
            }
            ans = Math.max(ans, sum);

        }

        return ans;


    }

    public static void main(String []args){

        int []arr = CommonUtil.getArrayInput();
        int ans = new MaximumSubarray().maxSubArray(arr);
        System.out.println(ans);
    }

}
