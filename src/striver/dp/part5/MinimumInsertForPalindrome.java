package striver.dp.part5;

import java.util.Arrays;

public class MinimumInsertForPalindrome {

    public static int solve(String str, int i, int j,int [][]mem) {

        if(i>=j)
            return 0;
        else if(mem[i][j]!=-1)
            return mem[i][j];

        else {

            if(str.charAt(i)==str.charAt(j))
                mem[i][j] =  solve(str, i+1, j-1,mem);
            else {

                mem[i][j] =  1+Math.min(solve(str, i+1, j,mem), solve(str,i,j-1,mem));

            }

            return mem[i][j];

        }


    }

    public static int minInsertion(String str) {
        // Write your code here.
        int [][]mem = new int[str.length()][str.length()];
        for(int i=0;i<str.length();i++)
            Arrays.fill(mem[i], -1);
        return solve(str,0, str.length()-1,mem);
    }

}
