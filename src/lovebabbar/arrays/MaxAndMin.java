package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxAndMin {

    public static void main(String[] args){

        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(val -> arr[val]=sc.nextInt());
        int minval = arr[0];
        int maxval = arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]<maxval){
                if(arr[i]<minval)
                    minval=arr[i];
            }
            else{
                maxval = arr[i];
            }
        }
        System.out.println("maxvalue => "+maxval+" minvalue =>"+minval);

    }

}
