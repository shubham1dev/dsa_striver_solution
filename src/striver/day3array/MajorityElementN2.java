package striver.day3array;

import util.CommonUtil;

public class MajorityElementN2 {

    public static int majorityElement(int[] nums) {

        int cm = -1;
        int mc = 0;
        for(int i: nums){

            if(cm==-1){
                cm = i;
                mc = 1;
            }
            else if(i==cm){
                mc++;
            }

            else{
                mc--;
            }

            if(mc==0){
                cm = i;
                mc = 1;
            }

        }

        mc = 0;
        for(int i:nums){
            if(i==cm)
                mc++;
        }

        if(mc>(nums.length)/2)
            return cm;
        else
            return -1;

    }

    public static void main(String []args){
        int []arr = CommonUtil.getArrayInput();
        int i = majorityElement(arr);
        System.out.println(i);
    }

}
