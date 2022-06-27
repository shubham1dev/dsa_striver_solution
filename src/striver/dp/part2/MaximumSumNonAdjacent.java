package striver.dp.part2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumSumNonAdjacent {

    public static int solve(ArrayList<Integer> arr, int i, int n,int []mem) {

        if(i>=n)
            return 0;
        else {
            if(mem[i]==-1)
            mem[i] =  Math.max(arr.get(i)+solve(arr, i+2, n,mem), solve(arr, i+1,n,mem));
            return mem[i];
        }

    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int []mem = new int[nums.size()];
        for(int i=0;i<nums.size();i++)
            mem[i] = -1;
        return solve(nums, 0, nums.size(),mem);
    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        IntStream.range(0,n).forEach(i-> arr.add(sc.nextInt()));
        int ans = maximumNonAdjacentSum(arr);
        System.out.println(ans);

    }

}
