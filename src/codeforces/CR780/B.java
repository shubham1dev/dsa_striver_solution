package codeforces.CR780;

import java.util.Scanner;
import java.util.stream.IntStream;

public class B {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int []arr = new int[n];
            IntStream.range(0,n).forEach(i-> arr[i]=sc.nextInt());
            if(n==1){
                if(arr[0]>1){
                    System.out.println("NO");
                }
                else {
                    System.out.println("YES");
                }
            }
            else {

                int m1=0, m2=0;
                for(int i: arr){

                    if(i>=m1){
                        m2 =m1;
                        m1 = i;
                    }
                    else if(i>=m2){
                        m2 = i;
                    }

                }

                if((m1-m2)<=1){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }

            }

        }

    }

}
