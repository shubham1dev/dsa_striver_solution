package striver.day10recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MColoringProblem {

    public static boolean solve(List<Integer>[] G, int[] color, int i, int m, int n){

        if(i==n){
            return true;
        }
        else {

            for(int j=1;j<=m;j++){
                boolean fp = false;
                color[i]=j;
                for(int k=0;k<G[i].size();k++){

                    if(color[i]==color[G[i].get(k)]) {
                        fp = true;
                        break;
                    }

                }
                if(!fp){
                    boolean res = solve(G,color, i+1, m, n);
                    if(res)
                        return true;

                }

            }
            color[i]=0;
            return false;

        }

    }

    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m)
    {

        int n = G.length;
        for(int j=0;j<n;j++){
            for(int k=0;k<G[j].size();k++){

                int t = G[j].get(k);
                G[t].add(j);

            }
        }
        return solve(G, color, 0, m, n);

    }

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int e = sc.nextInt();

        List<Integer> [] G = new List[n];
        for(int i=0;i<n;i++){
            G[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++){

            int a = sc.nextInt();
            int b = sc.nextInt();

            G[a].add(b);


        }
        boolean res = graphColoring(G,new int[n],0, m);
        System.out.println(res);
    }

}
