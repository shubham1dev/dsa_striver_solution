package striver.day1array;

import util.CommonUtil;

public class Sort012 {

    public void sortColors(int[] nums) {

        int n = nums.length;
        int z = -1;
        int t = n;
        int i = 0;
        while(i<t){

            if(nums[i]==0){
                z++;
                int temp = nums[z];
                nums[z] = 0;
                nums[i] = temp;
                i++;
            }
            else if(nums[i]==2){
                t--;
                int temp = nums[t];
                nums[t] = 2;
                nums[i] = temp;
            }
            else{
                i++;
            }

        }
        return;

    }

    public static void main(String []args){

        int[] arr = CommonUtil.getArrayInput();
        new Sort012().sortColors(arr);
        CommonUtil.printArray(arr, arr.length);
    }
}
