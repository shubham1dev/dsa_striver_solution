package striver.day25dp;

import util.CommonUtil;

import java.util.Arrays;

public class LongestIncreasingSubsequence {



    public static int solve(int []nums, int i, int pv, int n, int mem[][]){

        if(i==n)
            return 0;
        else {

            if(pv==-1){
               if(mem[i][n]==-1)
               mem[i][n] =  Math.max(1+solve(nums, i+1, i, n, mem), solve(nums, i+1, pv, n, mem));
               return mem[i][n];
            }
            else{

               if(mem[i][pv]==-1){
                   if(nums[i]>nums[pv]){

                       mem[i][pv] =  Math.max(1+solve(nums, i+1, i ,n, mem), solve(nums, i+1, pv, n, mem));

                   }
                   else {

                       mem[i][pv] =  solve(nums, i+1, pv, n, mem);

                   }
               }

                return mem[i][pv];
            }

        }

    }
    public int lengthOfLIS(int[] nums) {

        int [][]mem = new int[nums.length+1][nums.length+1];
        for(int i=0;i<=nums.length;i++){
            Arrays.fill(mem[i], -1);
        }
        return solve(nums, 0, -1, nums.length, mem);

    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        int ans = new LongestIncreasingSubsequence().lengthOfLIS(arr);
        System.out.println(ans);

    }


}
