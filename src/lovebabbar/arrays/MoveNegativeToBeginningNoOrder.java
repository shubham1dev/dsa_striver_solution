package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MoveNegativeToBeginningNoOrder {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(i-> arr[i]=sc.nextInt());
        int cs = -1;
        for(int i=0;i<n;i++){

            if(arr[i]<0){
                cs++;
                int temp = arr[cs];
                arr[cs] = arr[i];
                arr[i] = temp;
            }

        };

        for (int i:arr
             ) {
            System.out.print(i+" ");
        }

    }

}
