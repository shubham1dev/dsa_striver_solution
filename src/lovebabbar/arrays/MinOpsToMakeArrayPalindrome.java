package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MinOpsToMakeArrayPalindrome {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x->arr[x]= sc.nextInt());

        int i=0;
        int j=n-1;
        int count = 0;
        while(i<j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }
            else{
                if(arr[i]<arr[j]){
                    arr[i+1]+=arr[i];

                    i++;
                }
                else{
                    arr[j-1]+=arr[j];
                    j--;
                }
                count++;
            }
        }

        System.out.println(count);

    }

}
