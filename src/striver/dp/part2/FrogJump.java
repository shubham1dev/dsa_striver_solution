package striver.dp.part2;

import util.CommonUtil;

public class FrogJump {


    public static int solve(int i, int n, int heights[], int[]mem) {

        if(i==n-1)
            return 0;
        else if(i==(n-2)){
            return Math.abs(heights[i+1]-heights[i]);
        }
        else {

            if(mem[i]==-1)
            mem[i] = Math.min(Math.abs(heights[i]-heights[i+1])+solve(i+1, n, heights,mem), Math.abs(heights[i]-heights[i+2])+solve(i+2, n, heights,mem));
            return mem[i];
        }

    }

    public static int frogJump(int n, int heights[]) {

        int []mem = new int[n];
        for(int i=0;i<n;i++)
            mem[i]=-1;
        return solve(0, n, heights,mem);
    }

    public static void main(String []args ) {

        int []arr = CommonUtil.getArrayInput();
        int ans = frogJump(arr.length, arr);
        System.out.println(ans);

    }

}
