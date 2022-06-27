package striver.day11binarysearch;

import java.util.Scanner;

public class NthRoot {

    public static double findNthRootOfM(int n, long m) {

        double l = 1;
        double r = m;
        double mid = m;
        while(l<r){
            mid = l + ((r-l)/2);
            double fac = 1;
            for(int i=0;i<n;i++){
                fac = fac*mid;
            }
            if(fac==(double)m){
                return mid;
            }
            else if(fac>m){
                r=mid;
            }
            else{
                l = mid;
            }
        }

        return mid;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m  = sc.nextLong();
        double root = findNthRootOfM(n, m);
        System.out.println(root);

    }

}
