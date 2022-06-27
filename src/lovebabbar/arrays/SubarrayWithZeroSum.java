package lovebabbar.arrays;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class SubarrayWithZeroSum {


    public static void optimal(int []arr, int n){

        boolean fp = false;
        Set<Integer> val = new HashSet<>();
        int prefix = 0;
        val.add(prefix);
        for(int i=0;i<n;i++){
            prefix = prefix+arr[i];
            if(val.contains(prefix)){
                fp = true;
                break;
            }
            else
                val.add(prefix);

        }


        if(fp){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

    public static void bruteforce(int[]arr, int n){

        boolean fp = false;
        for(int i=0;i<n;i++){
            int tot = 0;
            for(int j=i;j<n;j++){

                tot+=arr[j];
                if(tot==0){
                    fp=true;
                    break;
                }

            }
        }

        if(fp){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        IntStream.range(0,n).forEach(x->arr[x]=sc.nextInt());
        //bruteforce(arr, n);
        optimal(arr, n);

    }

}
