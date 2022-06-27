package striver.dp.part2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static int solve(int i, int k, int n, int []arr, int[]mem) {

        if(i==n-1){
            return 0;
        }
        else {

            if(mem[i]==-1){
                int val = Integer.MAX_VALUE;
                for(int j=0;j<k && (j+i+1)<n;j++){

                    val = Math.min(val, Math.abs(arr[i]-arr[j+i+1])+solve(j+i+1, k, n, arr, mem));

                }
                mem[i] = val;
            }

            return mem[i];

        }

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(i-> arr[i]=sc.nextInt());
        int []mem = new int[n];
        Arrays.fill(mem,-1);
        int ans = solve(0, k, n,arr,mem);
        System.out.println(ans);
    }

}
