package lovebabbar.arrays;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimizeHeightDifference {

    public static int bruteForceSolution(int []arr, int i, int n, int k, int minv, int maxv){

        if(i==n){
            IntStream.range(0, n).forEach(p -> System.out.print(arr[p]+" "));
            System.out.println();
            return maxv-minv;
        }
        else {

            if(arr[i]<k){
                arr[i]+=k;
                int val =  bruteForceSolution(arr, i+1, n, k, Math.min(minv, arr[i]),Math.max(arr[i], maxv));
                arr[i]-=k;
                return val;
            }
            else{
                arr[i]+=k;
                int val1 = bruteForceSolution(arr, i+1, n, k, Math.min(minv, arr[i]),Math.max(arr[i], maxv));
                arr[i]-=k;
                arr[i]-=k;
                int val2 = bruteForceSolution(arr, i+1, n, k, Math.min(minv, arr[i]),Math.max(arr[i], maxv));
                arr[i]+=k;
                return Math.min(val1,val2);
            }

        }

    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(i->arr[i]= sc.nextInt());

        int k = sc.nextInt();
        System.out.println(bruteForceSolution(arr, 0, n, k,Integer.MAX_VALUE,Integer.MIN_VALUE));

        Arrays.sort(arr);

        int minval = arr[0];
        int maxval = arr[n-1];

        int minmaxdiff = maxval-minval;



        for(int i=0;i<(n-1);i++){

            if(arr[i]<k){
                arr[i]+=k;
            }

            else {
                maxval = Math.max(arr[i]+k, arr[n-1]-k);
                minval = Math.min(arr[i+1]-k, arr[0]+k);
            }

            minmaxdiff = Math.min(minmaxdiff, maxval-minval);
        }

        System.out.println(minmaxdiff);
    }

}
