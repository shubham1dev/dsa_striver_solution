package lovebabbar.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SmallestSubarrayWithSumGreaterThanX {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x-> arr[x]= sc.nextInt());
        int x = sc.nextInt();
        int ans = Integer.MAX_VALUE;

        int p = 0;
        int tot = 0;
        for(int i=0;i<n;i++){

            tot+=arr[i];

           if(tot>x){
                while(tot>x && p<=i){
                    ans = Math.min(ans, i-p+1);
                    tot-=arr[p];
                    p++;
                }
           }
        }

        System.out.println(ans);


    }

}
