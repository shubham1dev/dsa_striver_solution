package lovebabbar.arrays;


import java.util.Scanner;
import java.util.stream.IntStream;

public class FindDuplicate {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr =  new int[n];
        IntStream.range(0,n).forEach(i-> arr[i]=sc.nextInt());

        int i =0 ;
        while(true){
            if(arr[i] != (i+1)){
                if(arr[arr[i]-1]==arr[i]){
                    System.out.println(arr[i]);
                    break;
                }
                else{
                   int temp = arr[i];
                   arr[i] = arr[arr[i]-1];
                   arr[temp-1]=temp;
                }
            }
            else{
                i++;
            }

        }

    }

}
