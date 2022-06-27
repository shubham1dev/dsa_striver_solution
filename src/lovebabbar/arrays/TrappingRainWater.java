package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TrappingRainWater {

    public static void optimal(int[] arr, int n){

        int []ml = new int[n];
        int []mr = new int[n];

        int maxl = arr[0];
        for(int i=0;i<n;i++){
            maxl = Math.max(maxl,arr[i]);
            ml[i]=maxl;
        }

        int maxr = arr[n-1];
        for(int i=n-1;i>=0;i--){
            maxr = Math.max(maxr,arr[i]);
            mr[i]=maxr;
        }

        int ans = 0;
        for(int i=0;i<n;i++){

            ans+=Math.min(ml[i],mr[i])-arr[i];

        }

        System.out.println(ans);


    }

    public static void brute(int[]arr, int n){

        int ans = 0;
        for(int i=0;i<n;i++){

            int maxvr = arr[i];
            for(int j=i;j<n;j++){
                maxvr = Math.max(maxvr, arr[j]);
            }
            int maxvl = arr[i];
            for(int j=i;j>=0;j--){
                maxvl = Math.max(maxvl, arr[j]);
            }

            ans+=Math.min(maxvl, maxvr)-arr[i];

        }
        System.out.println(ans);
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x->arr[x]=sc.nextInt());
        brute(arr, n);
        optimal(arr, n);

    }

}
