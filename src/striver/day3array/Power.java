package striver.day3array;

import java.util.Scanner;

public class Power {

    public static double myPow(double x, int n) {

        long m = n;
        m=m<0?m*(-1):m;
        double ans = 1;
        while(m>0){

            if(m%2==0){
                x*=x;
                m/=2;
            }
            else{
                ans*=x;
                m--;
            }
        }

        if(n<0){
            ans = 1d/ans;
        }
        return ans;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        double x =sc.nextDouble();
        int n = sc.nextInt();

        double ans = myPow(x,n);

        System.out.print(ans);


    }

}
