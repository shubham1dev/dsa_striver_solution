package striver.day2array;

import util.CommonUtil;

public class MergeArrayNoSpace {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        boolean s1 = false;
        boolean s2 = false;

        int gap = (m+n)/2;
        while(gap!=0){

            int p = 0;
            int q = gap;

            while(true){

                if(q>=m){
                    q-=m;
                    s2 = true;
                }
                if(p>=m){
                    p-=m;
                    s1 = true;
                }

                int a,b;
                if(s1){
                    a = nums2[p];
                }
                else{
                    a = nums1[p];
                }

                if(s2){
                    b = nums2[q];
                }
                else {
                    b = nums1[q];
                }

                if(a>b){
                    if(s1){

                        int temp = nums2[p];
                        nums2[p] = nums2[q];
                        nums2[q] = temp;

                    }
                    else{

                        if(s2){
                            int temp = nums1[p];
                            nums1[p] = nums2[q];
                            nums2[q] = temp;

                        }
                        else{
                            int temp = nums1[p];
                            nums1[p] = nums1[q];
                            nums1[q] = temp;

                        }

                    }

                }

                p++;
                q++;
                if(s2){
                    if(q>=n){
                        gap --;
                        s1 = false;
                        s2 = false;
                        break;
                    }
                }

            }

        }

    }

    public static void main(String []args){

        int []arr1 = CommonUtil.getArrayInput();
        int []arr2 = CommonUtil.getArrayInput();
        merge(arr1,arr1.length, arr2, arr2.length);

        CommonUtil.printArray(arr1, arr1.length);
        CommonUtil.printArray(arr2, arr2.length);

    }

}
