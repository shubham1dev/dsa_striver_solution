package striver.day9recursion;

import java.util.*;
import java.util.stream.IntStream;

public class Subset2 {

    public void solve(int []nums, int i, int n, List<List<Integer>> ans, List<Integer> cs){

        if(i==n){
            ans.add(cs);
        }
        else {

            solve(nums, i+1, n, ans, cs);
            List<Integer> temp = new ArrayList<>(cs);
            temp.add(nums[i]);
            solve(nums, i+1, n, ans,temp);

        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,0, nums.length, ans, new ArrayList<>());
        Set<List<Integer>> temp = new HashSet<>(ans);

        return new ArrayList<>(temp);
    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int []arr = new int[n];
            IntStream.range(0,n).forEach(i-> arr[i]= sc.nextInt());
            List<List<Integer>> ans = new Subset2().subsetsWithDup(arr);
            System.out.println(ans.toString());
        }

    }

}
