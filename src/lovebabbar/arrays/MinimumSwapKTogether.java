package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimumSwapKTogether {

    public static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x -> arr[x]=sc.nextInt());
        int k = sc.nextInt();
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)
                count++;
        }
        int ans = 0;
        int res = 0;
        for(int i=0;i<count;i++){
            if(arr[i]>k)
                ans++;
        }
        res = ans;

        for(int i=count;i<n;i++){
            if(arr[i]>k){
                ans++;
            }
            if(arr[i-count]>k){
                ans--;
            }

            res = Math.min(ans, res);
        }

        System.out.println(res);


    }

}
