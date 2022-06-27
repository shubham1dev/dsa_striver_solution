package codeforces.CR784;

import java.util.Scanner;

public class G {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char [][]maze = new char[n][m];
            for(int i=0;i<n;i++){
                maze[i] = sc.nextLine().toCharArray();
            }
            for(int j=0;j<m;j++){
                int co = n-1;
                for(int i=n-1;i>=0;i--){

                    if(maze[i][j]=='*'){
                        maze[co][j]='*';
                        if(co!=i)
                        maze[i][j]='.';
                        co--;
                    }
                    else if(maze[i][j]=='o'){
                        co = i-1;
                    }

                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(maze[i][j]);
                }
                System.out.println();
            }

        }

    }

}
