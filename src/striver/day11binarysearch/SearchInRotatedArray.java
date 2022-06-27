package striver.day11binarysearch;

import util.CommonUtil;

import java.util.Scanner;

public class SearchInRotatedArray {

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length-1;
        while(l<=r){

            int mid = l + (r-l)/2;
            if(nums[mid]==target)
                return mid;

            else if(nums[mid]>target){

                if(nums[r]>=nums[mid]){
                    r = mid-1;
                }
                else {

                    if(target<=nums[r]){
                        l = mid+1;
                    }
                    else {
                        r = mid-1;
                    }

                }

            }

            else {


                if(nums[l]<=nums[mid]){
                    l = mid+1;
                }
                else {

                    if(nums[r]>=target) {
                        l = mid+1;
                    }
                    else {
                        r = mid-1;
                    }

                }


            }

        }
        return -1;
    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ans = new SearchInRotatedArray().search(arr,t);
        System.out.println(ans);

    }

}
