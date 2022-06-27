package striver.day8greedy;

import util.CommonUtil;

import java.util.*;

public class MinimumPlatform {



    static int findPlatform(int arr[], int dep[], int n)
    {

        int result = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int count = 0;
        while(i<n && j<n){

            if(arr[i]<=dep[j]){
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }
            result = Math.max(result, count);

        }

        return result;

    }


    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        int []dep = CommonUtil.getArrayInput();
        int ans = findPlatform(arr, dep, arr.length);
        System.out.println(ans);
    }

}
