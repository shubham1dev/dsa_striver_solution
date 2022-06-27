package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MoveNegativeToBeginningOrder {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(i-> arr[i]=sc.nextInt());



        for (int i:arr
             ) {
            System.out.print(i+" ");
        }

    }

}
