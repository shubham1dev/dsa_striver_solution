package striver.day9recursion;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SubsetSum {

    public void solve(ArrayList<Integer>arr, int ce, int ts, int n, ArrayList<Integer> ans){

        if(ce==n){
            ans.add(ts);
        }
        else {
            solve(arr, ce+1, ts, n, ans);
            solve(arr, ce+1, ts+arr.get(ce),n, ans);
        }

    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){

        ArrayList<Integer> ans = new ArrayList<>();
        solve(arr, 0, 0, N, ans);
        return ans;


    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            IntStream.range(0,n).forEach(i-> arr.add(sc.nextInt()));
            ArrayList<Integer> ans = new SubsetSum().subsetSums(arr,n);
            System.out.println(ans.toString());
        }

    }

}
