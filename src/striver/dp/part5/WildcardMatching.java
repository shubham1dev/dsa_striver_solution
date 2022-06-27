package striver.dp.part5;

import java.util.Arrays;

public class WildcardMatching {


    public static boolean solve(String p, String t, int i, int j, int n, int m,int [][]mem) {


        if(j==m) {

            if(i==n)
                return true;
            else {
                   if(p.charAt(i)=='*' || p.charAt(i)=='?') {
                        return solve(p,t,i+1,j,n, m, mem);
                    }
                    else
                        return false;
            }

        }
        else if(i==n)
            return false;
        else if(mem[i][j]!=-1) {
            if(mem[i][j]==1)
                return true;
            else
                return false;
        }


        else {

            if(p.charAt(i)=='*') {
                boolean val = solve(p, t, i+1,j,n,m,mem) || solve(p,t,i+1, j+1, n,m,mem) || solve(p,t,i,j+1, n,m,mem);
                if(val)
                    mem[i][j]=1;
                else
                    mem[i][j]=0;
            }

            else if(p.charAt(i)=='?') {

                boolean val =  solve(p,t,i+1,j, n, m,mem) || solve(p,t,i+1,j+1,n,m,mem);
                if(val)
                    mem[i][j]=1;
                else
                    mem[i][j]=0;

            }

            else if(p.charAt(i)==t.charAt(j)) {
                boolean val =  solve(p, t, i + 1, j + 1, n, m,mem);
                if(val)
                    mem[i][j]=1;
                else
                    mem[i][j]=0;

            }

            else {
                mem[i][j]=0;
            }
            return mem[i][j]==1;
        }


    }

    public static boolean wildcardMatching(String pattern, String text) {
        // Write your code here.
        int [][]mem = new int[pattern.length()][text.length()];
        for(int i=0;i<pattern.length();i++)
            Arrays.fill(mem[i],-1);
        return solve(pattern,text,0,0, pattern.length(), text.length(),mem);
    }

    public static void main(String []args) {


        wildcardMatching("ab*","ab");

    }

}
