package striver.dp.part5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestCommonSubsequence {

    public static String solve(String a, String b, int i, int j, int n, int m, String [][]mem,int [][]memi) {

        if(i==n){
            return b.substring(j);
        }
        else if(j==m) {
            return a.substring(i);
        }
        else if(memi[i][j]!=-1){
            return mem[i][j];
        }
        else {

            if(a.charAt(i)==b.charAt(j)){
                mem[i][j]= a.charAt(i)+solve(a,b,i+1, j+1, n,m,mem,memi);
                memi[i][j]=1;
            }
            else {
                String s1 = a.charAt(i)+solve(a,b,i+1, j, n, m,mem,memi);
                String s2 = b.charAt(j)+solve(a,b,i,j+1, n, m,mem,memi);
                if(s1.length()<s2.length())
                    mem[i][j]= s1;
                else
                    mem[i][j]= s2;
                    memi[i][j]=-1;
            }
            return mem[i][j];


        }

    }

    public static String shortestSupersequence(String a, String b) {
        String [][] mem = new String[a.length()][b.length()];
        int [][] memi = new int[a.length()][b.length()];
        for(int i=0;i<a.length();i++){
            Arrays.fill(mem[i],"#");
            Arrays.fill(memi[i],-1);
        }
        return solve(a,b,0,0, a.length(), b.length(),mem,memi);
    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(shortestSupersequence(s1,s2));
        }

    }

}
