package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CyclicRotate {

    public static void rotate(int arr[], int l, int r){

        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(i->arr[i]= sc.nextInt());
        int k = sc.nextInt();
        k = k%n;

        rotate(arr, 0, n-1);
        rotate(arr, 0, k-1);
        rotate(arr, k, n-1);
        System.out.println("Array Rotated by "+k+" => ");
        IntStream.range(0,n).forEach(i->System.out.print(arr[i]+" "));
    }

}
