package striver.dp.part2;

import util.CommonUtil;

public class HouseRobber {


    public static long solve(int []arr, int i, int n, long [][]mem, boolean last){

        if(i>=n){
            return 0;
        }
        else {

            if(last){
                if(mem[1][i]==-1){
                    if(i==0)
                        mem[1][i] = Math.max(arr[i]+solve(arr, i+2, n, mem, false), solve(arr, i+1, n, mem, true));
                    else if(i==(n-1)){
                        if(last){
                            mem[1][i] = arr[i];
                        }
                        else {
                            mem[1][i]=0;
                        }
                    }
                    else {
                        mem[1][i] = Math.max(arr[i]+solve(arr, i+2, n, mem, last), solve(arr, i+1, n, mem, last));
                    }
                }
                return mem[1][i];

            }
            else {
                if(mem[0][i]==-1){
                    if(i==0)
                        mem[0][i] = Math.max(arr[i]+solve(arr, i+2, n, mem, false), solve(arr, i+1, n, mem, true));
                    else if(i==(n-1)){
                        if(last){
                            mem[0][i] = arr[i];
                        }
                        else {
                            mem[0][i]=0;
                        }
                    }
                    else {
                        mem[0][i] = Math.max(arr[i]+solve(arr, i+2, n, mem, last), solve(arr, i+1, n, mem, last));
                    }
                }
                return mem[0][i];

            }

        }

    }

    public static long houseRobber(int[] valueInHouse) {
        // Write your code here.
        long[][]mem = new long[2][valueInHouse.length];
        for(int j=0;j<2;j++){
            for(int i=0;i<valueInHouse.length;i++)
                mem[j][i]=-1;
        }
        return solve(valueInHouse, 0, valueInHouse.length, mem, true);
    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        long ans = houseRobber(arr);
        System.out.println(ans);

    }

}
