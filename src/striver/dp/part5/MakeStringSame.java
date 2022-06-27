package striver.dp.part5;

import java.util.Arrays;

public class MakeStringSame {

    public static int solve(String str, String ptr, int i, int j, int n, int m, int[][]mem) {

        if(j>=m){
            return n-i;
        }
        else if(i==n){
            return m-j;
        }
        else if(mem[i][j]!=-1)
            return mem[i][j];

        else {

            if(str.charAt(i)==ptr.charAt(j)){
                mem[i][j] = solve(str, ptr, i+1, j+1, n, m,mem);
            }
            else {

                mem[i][j]= 1+Math.min(solve(str, ptr, i+1,j, n, m,mem), solve(str, ptr, i, j+1, n, m,mem));

            }
            return mem[i][j];

        }

    }

    public static int canYouMake(String str, String ptr) {

        int [][]mem = new int[str.length()][ptr.length()];
        for(int i=0;i<str.length();i++){
            Arrays.fill(mem[i],-1);
        }
        return solve(str, ptr, 0,0, str.length(),ptr.length(),mem);

    }



}
