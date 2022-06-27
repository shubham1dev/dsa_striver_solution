package lovebabbar.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RecursivePrintSentenceFromWords {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [][]words = new String[n][];

        IntStream.range(0,n).forEach(i-> {
            int m = sc.nextInt();
            words[i] = new String[m];
            sc.nextLine();
            IntStream.range(0,m).forEach(j-> words[i][j] = sc.next());
        });


        List<String> ans = new ArrayList<>();
        solve(words, n, 0, ans, "");
        System.out.println(ans);

    }

    private static void solve(String[][] words, int n,  int i, List<String> ans, String s) {

        if(i==n){
            ans.add(s);
        }
        else{
            for(int j=0;j<words[i].length;j++){
                solve(words, n, i+1, ans, s+words[i][j]+" ");
            }
        }

    }

}
