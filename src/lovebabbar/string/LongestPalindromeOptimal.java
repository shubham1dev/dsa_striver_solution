package lovebabbar.string;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LongestPalindromeOptimal {
    static boolean checkPalindrome(String str, int i, int j){
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else{

                return false;
            }
        }
        return true;
    }

    static String longestPalin(String S, int i, int j, int[][] checked){
        // code here
        return null;
    }

    public static void optimal(String str, int i,int j,int[][] checked){
        System.out.println(longestPalin(str, i,  j-1, checked));
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int [][]checked = new int[str.length()][str.length()];
        IntStream.range(0,str.length()).forEach(x-> Arrays.fill(checked[x], -1));
        optimal(str,0, str.length(), checked);

    }

}
