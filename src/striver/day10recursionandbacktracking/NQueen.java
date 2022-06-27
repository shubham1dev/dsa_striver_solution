package striver.day10recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen {

    public void solve(int [][]board, int n, int i, List<List<String>> ans){

        if(i==n) {
            List<String> combination = new ArrayList<>();
            for(int p=0;p<n;p++){
                    String cr = "";
                for(int q=0;q<n;q++){

                    if(board[p][q]==1){
                        cr+="Q";
                    }
                    else
                        cr+=".";

                }
                combination.add(cr);
            }
            ans.add(combination);
            return;
        }

        else {

            for(int j=0;j<n;j++){

                if(board[i][j]==0){

                    boolean fp = false;

                    for(int k=0;k<=i;k++){
                        if(board[k][j]!=0){
                            fp = true;
                            break;
                        }

                    }

                    if(fp)
                        continue;

                    int p = i;
                    int q = j;

                    while(p>=0 && q>=0){
                        if(board[p][q]!=0){
                            fp = true;
                            break;
                        }
                        p--;
                        q--;
                    }

                    if(fp)
                        continue;


                    p = i;
                    q = j;

                    while(p>=0 && q<n){
                        if(board[p][q]!=0){
                            fp = true;
                            break;
                        }
                        p--;
                        q++;
                    }

                    if(fp)
                        continue;

                    board[i][j] = 1;
                    solve(board, n ,i+1, ans);
                    board[i][j] = 0;

                }

            }


        }


    }

    public List<List<String>> solveNQueens(int n) {

        int [][]board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        solve(board, n, 0, ans);
        return ans;

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> ans = new NQueen().solveNQueens(n);
        System.out.println(ans.toString());
    }

}
