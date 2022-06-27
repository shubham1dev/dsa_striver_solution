package striver.day1array;

import util.CommonUtil;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){

                for(int j=n-1;j>i;j--){
                    if(nums[j]>nums[i]){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }

                int p = i+1;
                int q = n-1;
                while(p<q){
                    int temp = nums[p];
                    nums[p] = nums[q];
                    nums[q] = temp;
                    p++;
                    q--;
                }
                return;

            }
        }

        int p = 0;
        int q = n-1;
        while(p<q){
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            p++;
            q--;
        }

    }

    public static void main(String []args){

        int []arr = CommonUtil.getArrayInput();
        new NextPermutation().nextPermutation(arr);
        CommonUtil.printArray(arr, arr.length);


    }

}
