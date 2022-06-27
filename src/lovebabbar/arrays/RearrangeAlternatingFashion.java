package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RearrangeAlternatingFashion {

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i]+arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i]-arr[j];
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x->arr[x]=sc.nextInt());
        int pi =0;
        int i = 0;

        IntStream.range(0,n).forEach(x-> System.out.print(arr[x]+" "));

    }

}
