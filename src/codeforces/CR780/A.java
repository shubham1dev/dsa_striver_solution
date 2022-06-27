package codeforces.CR780;

import java.util.Scanner;

public class A {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){

            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a==0){
                if(b==0){
                    System.out.println(0);
                }
                else
                System.out.println(1);
            }
            else {
                int rem = a%2;
                int ones = (int) Math.floor((double)a/2.0d);
                int ans = (b*2) + (ones*2) + rem;
                System.out.println(ans+1);
            }

        }

    }

}
