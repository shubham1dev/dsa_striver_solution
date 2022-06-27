package striver.day9recursion;

import java.util.*;
import java.util.stream.IntStream;

public class CombinationSum2 {


    public void solve(int []arr, int t, int i,int cs, List<Integer> ta, Set<List<Integer>> ans) {

        if(cs==t){
            ans.add(ta);
            return;
        }
        else if(cs>t || i==arr.length){
            return;
        }
        else  {

            List<Integer> temp = new ArrayList<>(ta);
            temp.add(arr[i]);
            solve(arr, t, i+1,cs+arr[i], temp, ans);
            solve(arr, t, i+1, cs, ta, ans);

        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<>();
        solve(candidates, target, 0, 0, new ArrayList<>(), ans);
        List<List<Integer>> unique = new ArrayList<>(ans);
        return unique;

    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int []arr = new int[n];
            IntStream.range(0,n).forEach(i-> arr[i] = sc.nextInt());
            int T = sc.nextInt();
            List<List<Integer>> ans = new CombinationSum2().combinationSum2(arr, T);
            System.out.println(ans.toString());

        }


    }

}
