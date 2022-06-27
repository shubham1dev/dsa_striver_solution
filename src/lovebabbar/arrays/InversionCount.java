package lovebabbar.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InversionCount {

    public static void bruteForce(int[] arr, int n){

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int merge(int arr[], int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;
        int []arr1 = new int[n1];
        int []arr2 = new int[n2];

        for(int i=l;i<=m;i++){
            arr1[i-l]=arr[i];
        }
        for(int i=m+1;i<=r;i++){
            arr2[i-m-1]=arr[i];
        }

        int i = 0;
        int j = 0;
        int k = l;
        int count = 0;
        while(i<n1 && j<n2){
            if(arr1[i]==arr2[j]){
                arr[k]=arr1[i];
                i++;
                k++;
                arr[k] = arr2[j];
                j++;
                k++;
            }
            else if(arr1[i]>arr2[j]){
                arr[k] = arr2[j];
                k++;
                j++;
                count+=(n1-i);
            }
            else{
                arr[k] = arr1[i];
                k++;
                i++;
            }
        }

        while(i<n1){
            arr[k]=arr1[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=arr2[j];
            j++;
            k++;
        }

        return count;



    }

    public static int mergeSort(int arr[],int l, int r){
        if(l<r){
            int m = (l+r)/2;
            int a=mergeSort(arr, l, m);
            int b=mergeSort(arr, m+1, r);
            return a+b+merge(arr, l, m, r);
        }
        return 0;
    }

    public static void optimal(int []arr, int n){

        int ans = mergeSort(arr, 0, n-1);
        System.out.println(ans);
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x-> arr[x]=sc.nextInt());
//        bruteForce(arr, n);

        optimal(arr, n);
    }

}
