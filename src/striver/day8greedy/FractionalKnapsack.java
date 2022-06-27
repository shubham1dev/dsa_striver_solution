package striver.day8greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    static double fractionalKnapsack(int W, Item arr[], int n)
    {
        Arrays.sort(arr, (a,b)-> {
            double f1 = (double)a.value/(double) a.weight;
            double f2 = (double)b.value/(double) b.weight;

            if(f2>f1){
                return 1;
            }
            else {
                return -1;
            }
        });

        double ans = 0d;
        for(Item i: arr){

            if(i.weight<=W){
                W-=i.weight;
                ans+=i.value;
            }
            else {
                double t = ((double) W/(double) i.weight)*i.value;
                ans+=t;
                break;
            }

        }

        return ans;


    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            Item []arr = new Item[n];
            for(int i=0;i<n;i++){

                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[i] = new Item(a,b);

            }
            int W = sc.nextInt();

            double ans = fractionalKnapsack(W, arr, n);
            System.out.println(ans);
        }



    }
}
