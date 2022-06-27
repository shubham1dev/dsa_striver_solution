package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class KthSmallest {

    public static int partition(int []arr, int pivot, int l, int r){

        while(l<r){
            while(arr[l]<arr[pivot] && l<=r){
                l++;
            }
            while(arr[r]>arr[pivot] && r>=l){
                r--;
            }

            if(l<r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            else{
                return r;
            }
        }
        return r;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];

        IntStream.range(0,n).forEach(i-> arr[i]= sc.nextInt());

        int k = sc.nextInt();
        int l = 0,m=n-1;

        int pivot =-1;
        int output = -1;
        do{
            pivot = (l+m)/2;
            output = partition(arr,pivot, l, m);
            if(output>k){
                m =output;
            }
            else
                l = output;
        }
        while(output!=k);

        System.out.println(arr[output]);

    }

}
