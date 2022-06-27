package lovebabbar.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimumNumberOfJumps {

    public static int minJumps(int []arr, int n, int i, int[] mem){

        if(i>n){
            return -1;
        }

        else if(i==n){
            return 0;
        }

        else {

            if(mem[i]!=-2){
                return mem[i];
            }

            if(arr[i]==0){
                return -1;
            }

            int minVal=Integer.MAX_VALUE;
            for(int j=1;j<=arr[i];j++){
                int val = minJumps(arr, n, i+j, mem);
                if(val!=-1){
                    minVal = Math.min(minVal, val);
                }
            }

            if(minVal==Integer.MAX_VALUE) {
                mem[i] = -1;
                return mem[i];
            }

            mem[i] =  1+minVal;
            return mem[i];
        }

    }

    public static void main(String []args) {

        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        IntStream.range(0,n).forEach(i->arr[i]= sc.nextInt());
        int []mem = new int[n];
        Arrays.fill(mem, -2);
        int ans = minJumps(arr, n-1, 0, mem);
        System.out.println(ans);

    }

}
