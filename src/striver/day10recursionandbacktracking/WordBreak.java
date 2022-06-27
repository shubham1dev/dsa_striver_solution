package striver.day10recursionandbacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {


    public static void solve(String s, Set<String> dictionary, List<String> ans, String cs){

        if(s.length()==0){
            ans.add(new String(cs.substring(0, cs.length()-1)));
        }
        else {

            for(int i=1;i<=s.length();i++){

                String word = s.substring(0,i);
                if(dictionary.contains(word)){
                   solve(s.substring(i), dictionary, ans, cs+word+" ");
                }

            }

        }

    }

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {

        ArrayList<String> ans = new ArrayList<>();
        solve(s, new HashSet<>(dictionary), ans, "");
        return ans;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        ArrayList<String> dic = new ArrayList<>();
        while(n-->0){
            dic.add(sc.nextLine());
        }

        ArrayList<String> ans = wordBreak(str, dic);
        System.out.println(ans.toString());
    }

}
