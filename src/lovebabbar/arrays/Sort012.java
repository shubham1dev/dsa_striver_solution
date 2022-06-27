package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Sort012 {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(i->arr[i]=sc.nextInt());

        int i = -1;
        int j = n;


        int p = 0;
        while(p<j){

            if(arr[p]==0){

                i++;
                arr[p] = arr[i];
                arr[i] = 0;

            }
            else if(arr[p]==2){
                j--;
                arr[p] = arr[j];
                arr[j] = 2;
                p++;
            }

            else {
                p++;
            }

        }

        IntStream.range(0,n).forEach(v -> System.out.print(arr[v]+" "));
    }

}
