package striver.dp.part4;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {

    public static boolean solve(int []arr, int i, int ct, int n, int t, ArrayList<Integer> cr , ArrayList<ArrayList<Integer>> set) {

        if(i==n) {
            if(ct==t) {
                set.add(new ArrayList<>(cr));
            }
            return true;
        }
        else if(ct==t) {
            set.add(new ArrayList<>(cr));
            return true;
        }
        else if(ct>t)
            return false;

        else {
            cr.add(i);
            if(solve(arr, i+1, ct+arr[i], n, t, cr, set))
                return true;
            cr.remove(cr.size()-1);
            solve(arr,i+1, ct, n, t, cr, set);
        }
        return false;

    }

    public static boolean canPartition(int[] arr, int n) {

        int ans = IntStream.of(arr).sum();
        if(ans%2!=0)
            return false;

        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        solve(arr, 0, 0, n, ans/2, new ArrayList<>(), set);
        if(set.size()>=2)
            return true;
        else
            return false;
    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        boolean ans = canPartition(arr, arr.length);

    }

}
