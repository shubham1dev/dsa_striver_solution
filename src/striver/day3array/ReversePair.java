package striver.day3array;

import util.CommonUtil;

public class ReversePair {

    public int merge(int []arr, int l, int m, int r) {

        int []tmerge = new int[r-l+1];
        int i=l;
        int j=m+1;
        int k=0;
        while(i<=m && j<=r) {

            if(arr[i]<arr[j]) {
                tmerge[k] = arr[i];
                i++;
            } else {
                tmerge[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=m) {

                tmerge[k] = arr[i];
                i++;
                k++;
        }
        while(j<=r) {

                tmerge[k] = arr[j];
                j++;
                k++;
        }

        i = l;
        j = m+1;
        int inversions=0;
        while(i<=m && j<=r) {

            long a = arr[i];
            long b = arr[j];

            if(a> (2*b)) {
                inversions+=(m-i+1);
                j++;
            }
            else {
                i++;
            }

        }

        k = l;
        while(k<=r) {

            arr[k] = tmerge[k-l];
            k++;
        }

        return inversions;

    }

    public int mergeSort(int []arr, int l, int r) {

        if(l<r){

            int m = l+((r-l)/2);
            int p = mergeSort(arr,l, m);
            int q = mergeSort(arr, m+1, r);
            return p+q+merge(arr, l, m, r);

        }
        return 0;
    }

    public int bruteforce(int []nums) {

        int ans = 0;
        for(int i=0;i<nums.length;i++) {

            for(int j=i+1;j<nums.length;j++){

                if(nums[i]>(2*nums[j])){
                    ans ++;
                }

            }

        }

        return ans;

    }

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length-1);

    }

    public static void main(String []args)   {

        int []arr = CommonUtil.getArrayInput();
        int ans = new ReversePair().reversePairs(arr);
        System.out.println(ans);

    }

}
