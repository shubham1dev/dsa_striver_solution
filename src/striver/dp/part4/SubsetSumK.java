package striver.dp.part4;

import java.util.Arrays;
import java.util.HashSet;

public class SubsetSumK {

    public static boolean solve(int n, int k, int []arr,boolean [][]mem){

        if(k==0)
            return true;
        else if(n==0){
            if(arr[n]==k)
                return true;
            else
                return false;
        }
        else if(k<0)
            return false;

        else if(mem[n][k])
            return true;
        else  {

            mem[n][k] =  solve(n-1, k, arr,mem) || solve(n-1, k-arr[n-1], arr,mem);
            return mem[n][k];
        }

    }

    public static boolean subsetSumToK(int n, int k, int arr[]){

        boolean [][]mem = new boolean[n+1][k+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(mem[i], false);
        return solve(n-1, k, arr,mem);

    }

    public static void main(String []args) {



    }

}
