package striver.dp.part3;

import util.CommonUtil;

public class NinjaTraining {

    public static int solve(int n, int pa, int [][]arr, int[][]mem){

        if(mem[n][pa]!=-1)
            return mem[n][pa];

        if(n==0){
            int val = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=pa)
                val = Math.max(val, arr[n][i]);
            }
            mem[n][pa] = val;
            return mem[n][pa];

        }
        else {

            int val = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=pa)
                    val = Math.max(val, arr[n][i]+solve(n-1, i, arr, mem));
            }
            mem[n][pa] = val;
            return mem[n][pa];
        }
    }

    public static int ninjaTraining(int n, int points[][]) {

        int [][]mem =  new int[n][4];
        for(int i=0;i<n;i++){

            for(int j=0;j<4;j++)
                mem[i][j]=-1;

        }
        return solve(n-1,n, points,mem);

    }

    public static void main(String []args) {

        int [][]points = CommonUtil.getMatrixInput();
        int ans = ninjaTraining(points.length, points);
        System.out.println(ans);
    }

}
