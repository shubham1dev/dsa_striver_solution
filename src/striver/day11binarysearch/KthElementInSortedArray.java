package striver.day11binarysearch;

import util.CommonUtil;

import java.util.Scanner;

public class KthElementInSortedArray {

    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        if(m<n){
            return kthElement(arr2,arr1, m, n, k);
        }

        int l = 0;
        int r = n;

        while(l<=r){

            int cut1 = l+(r-l)/2;
            if(cut1>k){
                r = cut1;
                continue;
            }
            int cut2 = k-cut1;
            if(cut2>m){
                l = cut1;
                continue;
            }

            int l1 = cut1==0?Integer.MIN_VALUE:arr1[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE:arr2[cut2-1];
            int r1 = cut1==n?Integer.MAX_VALUE:arr1[cut1];
            int r2 = cut2==m?Integer.MAX_VALUE:arr2[cut2];

            if(l1<=r2 && l2<=r1) {

                return Math.max(l1, l2);

            }

            else if(l1>r2){
                r = cut1-1;
            }
            else {
                l = cut1+1;
            }

        }

        return -1;

    }

    public static void main(String []args) {

        int []arr1 = CommonUtil.getArrayInput();
        int []arr2 = CommonUtil.getArrayInput();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        long ans = new KthElementInSortedArray().kthElement(arr1, arr2, arr1.length,arr2.length, k);
        System.out.println(ans);
    }

}
