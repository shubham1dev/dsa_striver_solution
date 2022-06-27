package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ThreeWayPartitioning {

    public static void swap(int []arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []array = new int[n];
        IntStream.range(0,n).forEach(x -> array[x]=sc.nextInt());
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i=-1;
        int j=n;
        int p = 0;
        while(p<j){
            if(array[p]>b){
                j--;
                swap(array, p, j);
            }
            else if(array[p]<a){
                i++;
                swap(array, p, i);
                p++;
            }
            else{
                p++;
            }
        }
        IntStream.range(0,n).forEach(x-> System.out.print(array[x]+" "));


    }

}
