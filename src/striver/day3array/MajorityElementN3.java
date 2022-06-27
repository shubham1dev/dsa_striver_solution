package striver.day3array;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementN3 {

    public static List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int n1 = -1;
        int n2 = -1;
        int c1 = 0;
        int c2 = 0;
        for(int n: nums){

            if(n==n1){
                c1++;
            }
            else if(n==n2)
                c2++;
            else if(c1==0){
                n1 = n;
                c1 = 1;
            }
            else if(c2==0){
                n2 = n;
                c2 = 1;
            }
            else {
                c1--;
                c2--;
            }

        }

        int lim = (int)Math.floor((double)nums.length/3.0d);
        c1 = 0;
        c2 = 0;

        for(int n: nums){
            if(n==n1)
                c1++;
        }
        for(int n: nums){
            if(n==n2)
                c2++;
        }

        if(c1>lim)
            ans.add(n1);
        if(c2>lim)
            ans.add(n2);

        if(ans.isEmpty())
            ans.add(-1);

        return ans;
    }

    public static void main(String []args){

        int []nums = CommonUtil.getArrayInput();
        List<Integer> ans = majorityElement(nums);
        System.out.println(ans);

    }

}
