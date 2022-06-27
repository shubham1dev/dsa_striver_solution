package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ReverseTheArray {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        IntStream.range(0,n).forEach(i -> arr[i] = sc.nextInt());
        IntStream.range(0,n).forEach(val ->System.out.print(arr[val]+" "));
        System.out.println();
        int i = 0,j=n-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        IntStream.range(0,n).forEach(val ->System.out.print(arr[val]+" "));

    }

}
