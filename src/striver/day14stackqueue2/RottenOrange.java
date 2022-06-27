package striver.day14stackqueue2;

import util.CommonUtil;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RottenOrange {


    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int orangesRotting(int[][] grid) {

        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j));
                }
            }
        }
        int ans = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-->0){

                Pair p = queue.poll();
                int x = p.x;
                int y = p.y;
                grid[x][y]=-2;

                if(x>0){
                    if(grid[x-1][y]==1){
                        grid[x-1][y]=2;
                        queue.add(new Pair(x-1, y));
                    }
                }
                if(x<(m-1)){
                    if(grid[x+1][y]==1){
                        grid[x+1][y]=2;
                        queue.add(new Pair(x+1, y));
                    }
                }
                if(y>0){
                    if(grid[x][y-1]==1){
                        grid[x][y-1]=2;
                        queue.add(new Pair(x, y-1));
                    }
                }
                if(y<(n-1)){
                    if(grid[x][y+1]==1){
                        grid[x][y+1]=2;
                        queue.add(new Pair(x, y+1));
                    }
                }

            }
            ans++;

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1)
                    return -1;
            }
        }

        return ans-1;

    }

    public static void main(String []args) {


        int[][]grid = CommonUtil.getMatrixInput();
        int ans = new RottenOrange().orangesRotting(grid);
        System.out.println(ans);

    }

}
