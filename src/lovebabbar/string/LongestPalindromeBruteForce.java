package lovebabbar.string;

import java.util.Scanner;

public class LongestPalindromeBruteForce {
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

    static String longestPalin(String S){
        // code here

        if(checkPalindrome(S, 0, S.length()-1)){
            return S;
        }
        else{

            String v1 = longestPalin(S.substring(1));
            String v2 = longestPalin(S.substring(0, S.length()-1));

            if(v1.length()>v2.length()){
                return v1;
            }
            else{
                return v2;
            }
        }

    }

    public static void bruteForce(String str){
        System.out.println(longestPalin(str));
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        bruteForce(str);

    }

}
