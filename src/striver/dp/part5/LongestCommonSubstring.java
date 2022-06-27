package striver.dp.part5;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static int solve(String s1, String s2, int i, int j, int n, int m, int[][]mem) {

        if(i==n || j==m)
            return 0;
        else if(mem[i][j]!=-1)
            return mem[i][j];
        else {

            int count = 0;
            if(s1.charAt(i)==s2.charAt(j)){
                int p = i;
                int q = j;
                while(p<n && q<m){
                    if(s1.charAt(p)==s2.charAt(q))
                        count++;
                    else
                        break;
                    p++;
                    q++;
                }

            }

            int val1 = solve(s1, s2, i+1, j, n, m,mem);
            int val2 = solve(s1, s2, i, j+1, n, m,mem);

            int ans = 0;
            ans = Math.max(val1,val2);
            ans = Math.max(ans, count);
            mem[i][j]= ans;
            return mem[i][j];
        }

    }

    public static int lcs(String str1, String str2) {

        int [][]mem = new int[str1.length()][str2.length()];
        for(int i=0;i<str1.length();i++){
            Arrays.fill(mem[i], -1);
        }
        return solve(str1,str2, 0,0, str1.length(), str2.length(),mem);

    }


}
