package striver.day10recursionandbacktracking;

import java.util.Scanner;

public class SudokuSolver {

    public boolean solve(char[][]board , int[][]rows, int[][]cols, int i, int j){


        if(j==9){
            i++;
            j=0;
        }

        if(i==9){
            return true;
        }

        if(board[i][j]!='.'){
            return solve(board,rows, cols, i,j+1);
        }

        else {

            for(int p=1;p<=9;p++){
                if(rows[i][p]==0 && cols[j][p]==0){
                    board[i][j]=(char)(p+'0');
                    cols[j][p] = 1;
                    rows[i][p] = 1;
                    boolean res = solve(board, rows, cols, i, j+1);
                    if(res)
                        return true;
                    board[i][j] = '.';
                    cols[j][p]=0;
                    rows[i][p] =0;
                }
            }

            return false;

        }


    }

    public void solveSudoku(char[][] board) {

        int [][]rows = new int[10][10];
        int [][]cols = new int[10][10];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.'){
                    int num = Integer.parseInt(String.valueOf(board[i][j]));
                    rows[i][num]=1;
                    cols[j][num]=1;
                }
            }
        }

        boolean res = solve(board, rows, cols, 0, 0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        char [][] board = new char[9][9];
        for(int i=0;i<9;i++){
            String inp = sc.nextLine();
            board[i] = inp.toCharArray();
        }

        new SudokuSolver().solveSudoku(board);


    }

}
