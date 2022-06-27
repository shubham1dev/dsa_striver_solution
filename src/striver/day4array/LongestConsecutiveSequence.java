package striver.day4array;

import util.CommonUtil;

import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> myset = new HashSet<>();
        for(int i: nums){
            myset.add(i);
        }

        int count = 0;
        int ans = 0;
        for(int i:nums) {

            if(!myset.contains(i-1)){
                int y=i;
                count = 0;
                while(myset.contains(y)){
                    count++;
                    y++;
                }
                ans = Math.max(ans, count);
            }

        }
        return ans;

    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        int ans = new LongestConsecutiveSequence().longestConsecutive(arr);
        System.out.println(ans);

    }

}
