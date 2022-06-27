package codeforces.CR784;

import java.util.Scanner;
import java.util.stream.IntStream;

public class C {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int []arr = new int[n];
            IntStream.range(0,n).forEach(i->arr[i]=sc.nextInt());

            boolean fp1= false;

            int even = 0;
            int odd = 0;
            for(int i=0;i<n;i+=2){

                if(arr[i]%2==0){
                    even++;
                }
                else {
                    odd++;
                }

            }

            if((even==0 && odd!=0) || (odd==0 && even!=0)){
                fp1 = true;
            }
            boolean fp2 = false;
            even = 0;
            odd = 0;
            for(int i=1;i<n;i+=2){
                if(arr[i]%2!=0){
                    even++;
                }
                else{
                    odd++;
                }
            }


            if((even==0 && odd!=0) || (odd==0 && even!=0)){
                fp2 = true;
            }


            if(fp1 && fp2) {

                System.out.println("YES");

            }
            else {
                System.out.println("NO");
            }


        }

    }

}
