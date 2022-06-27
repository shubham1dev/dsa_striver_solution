package striver.day11binarysearch;

import util.CommonUtil;

public class SingleElementInArray {

    public static int singleNonDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length-1;

        while (l<=r) {
            int mid = l+(r-l)/2;

            if(mid==l && mid==r){
                return nums[mid];
            }
            else if(mid==l){
                if(nums[mid]!=nums[mid+1]){
                    return nums[mid];
                }
                else
                l=mid+1;
            }
            else if(mid==r){
                if(nums[mid]!=nums[mid-1]){
                    return nums[mid];
                }
                else {
                    r = mid-1;
                }
            }
            else  {

                if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                    return nums[mid];
                }

                else if(nums[mid]==nums[mid-1]){

                    if((r-mid)%2==0){
                        r = mid-2;
                    }
                    else l = mid+1;

                }
                else {

                    if((mid-l)%2==0){
                        l = mid+2;
                    }
                    else
                        r = mid-1;

                }

            }

        }
        return -1;
    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        int ans = singleNonDuplicate(arr);
        System.out.println(ans);

    }

}
