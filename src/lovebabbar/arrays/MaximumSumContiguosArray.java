package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumSumContiguosArray {

    public static void main(String [] args) {

        int maxVal = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(i->arr[i]=sc.nextInt());
        int cs = 0;
        for(int i=0;i<n;i++){
            if(arr[i]>(cs+arr[i])){
                cs = arr[i];
            }
            else{
                cs+=arr[i];
            }
            maxVal = Math.max(maxVal, cs);
        }

        System.out.println("Maximum value of contiguous subarray is => "+maxVal);

    }

}
