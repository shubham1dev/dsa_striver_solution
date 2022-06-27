package striver.day25dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class LongestCommonSequence {

    public int solve(String s1, String s2, int i, int j, int n, int m, int[][] mem){

        if(i==n || j==m){
            return 0;
        }
        else {

            if(mem[i][j]==-1){

                if(s1.charAt(i)==s2.charAt(j)){
                    mem[i][j] = 1+solve(s1, s2,i+1,j+1,n, m, mem);
                }
                else {
                    mem[i][j] = Math.max(solve(s1, s2,i+1, j, n,m,mem),solve(s1,s2,i, j+1, n, m,mem));
                }
            }
            return mem[i][j];

        }

    }

    public int longestCommonSubsequence(String text1, String text2) {

        int [][]mem = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++)
            Arrays.fill(mem[i],-1);
        return solve(text1, text2, 0,0, text1.length(), text2.length(),mem);

    }


    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int ans = new LongestCommonSequence().longestCommonSubsequence(s1,s2);
        System.out.println(ans);
    }

}
