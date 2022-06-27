package codeforces.CR784;

import java.util.Scanner;
import java.util.stream.IntStream;

public class F {

    public static void main(String []args) {


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {

            int n = sc.nextInt();
            int[]arr = new int[n];
            IntStream.range(0,n).forEach(i-> arr[i]=sc.nextInt());

            int []prefixl = new int[n];
            for(int i=0;i<n;i++){

                if(i==0){
                    prefixl[i] = arr[i];
                }
                else{
                    prefixl[i] = prefixl[i-1]+arr[i];
                }

            }
            int []prefixr = new int[n];
            for(int i=n-1;i>=0;i--){

                if(i==(n-1)){
                    prefixr[i] = arr[i];
                }
                else{
                    prefixr[i] = prefixr[i+1]+arr[i];
                }

            }
            int i=0;
            int j=n-1;

            int ans = 0;
            while(i<j){

                if(prefixl[i]==prefixr[j]){
                    ans = i+(n-j)+1;
                    i++;
                    j--;
                }
                else if(prefixl[i]>prefixr[j]) {
                    j--;
                }
                else {
                    i++;
                }

            }

            System.out.println(ans);


        }


    }

}
