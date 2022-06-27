package util;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CommonUtil {

    public static int[] getArrayInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        IntStream.range(0,n).forEach(x->arr[x] = sc.nextInt());
        return arr;
    }

    public static int[][] getMatrixInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]arr = new int[n][m];
        IntStream.range(0,n).forEach(i->{
            IntStream.range(0,m).forEach(j-> arr[i][j] = sc.nextInt());
        });

        return arr;

    }

    public static void printArray(int []arr, int n){
        IntStream.range(0,n).forEach(x-> System.out.print(arr[x]+" "));
        System.out.println();
    }

}
