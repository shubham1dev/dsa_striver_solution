package striver.day2array;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, Comparator.comparingDouble(o-> o[0]));

        int a = -1;
        int b = -1;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i< intervals.length;i++){

            if(a==-1 && b==-1){
                a = intervals[i][0];
                b = intervals[i][1];
            }
            else {

                int p = intervals[i][0];
                int q = intervals[i][1];
                if(p<=b){
                    if(q>b){
                        b = q;
                    }
                }
                else{
                    ans.add(Arrays.asList(a,b));
                    a = p;
                    b = q;
                }

            }

        }

        ans.add(Arrays.asList(a,b));
        int [][]ret = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){

            ret[i][0] = ans.get(i).get(0);
            ret[i][1] = ans.get(i).get(1);
        }
        return ret;

    }

    public static void main(String []args){

        int [][]mat = CommonUtil.getMatrixInput();
        int [][] ans = merge(mat);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

}
