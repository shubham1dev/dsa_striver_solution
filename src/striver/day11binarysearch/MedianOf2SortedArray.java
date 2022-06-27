package striver.day11binarysearch;

import util.CommonUtil;

import java.util.Scanner;

public class MedianOf2SortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums2.length<nums1.length)
        return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int r = nums1.length;

        int len = nums1.length+nums2.length;
        int k = len;
        if(len%2==0){

            len = len/2;

        }
        else {
            len = ((len+1)/2);
        }

        while(l<=r) {

            int cut1 = l + (r-l)/2;
            int cut2 = len-cut1;

            int l1 = cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE: nums2[cut2-1];
            int r1 = cut1==nums1.length?Integer.MAX_VALUE:nums1[cut1];
            int r2 = cut2== nums2.length?Integer.MAX_VALUE:nums2[cut2];

            if(l1<=r2) {

                if(l2<=r1){

                        if(k%2==0){
                            double tot = Math.max(l1,l2) + Math.min(r1,r2);
                            return tot/2.0;
                        }
                        else {
                            return Math.max(l1,l2);
                        }

                }
                else {

                    l = cut1+1;

                }

            }

            else {
                r = cut1-1;
            }


        }



        return 0d;
    }

    public static void main(String []args) {

        int []nums1 = CommonUtil.getArrayInput();
        int []nums2 = CommonUtil.getArrayInput();

        double median = new MedianOf2SortedArray().findMedianSortedArrays(nums1,nums2);
        System.out.println(median);


    }




}
