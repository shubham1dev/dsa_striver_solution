package striver.day2array;

import util.CommonUtil;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {


        int slow = nums[0];
        int fast = nums[0];

        do{

            slow = nums[slow];
            fast = nums[nums[fast]];

        }while(slow!=fast);

        slow = nums[0];
        while(slow!=fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }

    public static void main(String []args) {

        int[]arr = CommonUtil.getArrayInput();
        int ans = new FindDuplicateNumber().findDuplicate(arr);
        System.out.println(ans);

    }

}
