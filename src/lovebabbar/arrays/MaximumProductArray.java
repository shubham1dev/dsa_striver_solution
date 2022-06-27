package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumProductArray {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x-> arr[x]=sc.nextInt());
        

    }

}
