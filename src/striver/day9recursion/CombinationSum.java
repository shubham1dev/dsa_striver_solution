package striver.day9recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CombinationSum {

    public void solve(int []arr,int i, int n, int t, int cs, List<List<Integer>> ans, List<Integer> cc) {

        if(t==cs) {
            ans.add(new ArrayList<>(cc));
            return;
        }
        else if(cs > t || i==n){
            return;
        }
        else {

            cc.add(arr[i]);
            solve(arr, i, n, t, cs+arr[i], ans, cc);
            cc.remove(cc.size()-1);
            solve(arr, i+1,n, t, cs, ans, cc);

        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates,0, candidates.length, target, 0,ans, new ArrayList<>());
        return ans;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int []arr = new int[n];
            IntStream.range(0,n).forEach(i-> arr[i] = sc.nextInt());
            int T = sc.nextInt();
            List<List<Integer>> ans = new CombinationSum().combinationSum(arr, T);
            System.out.println(ans.toString());
        }

    }

}
