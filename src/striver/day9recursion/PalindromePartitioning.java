package striver.day9recursion;

import codeforces.CR780.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {

    public boolean checkPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public void solve(String s, int i, int j , List<List<String>> ans, List<String> temp){

        if(i>j){
            ans.add(new ArrayList<>(temp));
        }

        else{
            for(int p=i;p<=j;p++){
                if(checkPalindrome(s, i,p)){
                    temp.add(s.substring(i,p+1));
                    solve(s, p+1, j, ans, temp);
                    temp.remove(temp.size()-1);
                }

            }
        }

    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        solve(s,0, s.length()-1, ans, new ArrayList<String>());
        return ans;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<List<String>> ans = new PalindromePartitioning().partition(str);
        System.out.println(ans.toString());
    }
}
