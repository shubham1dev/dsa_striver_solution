package lovebabbar.matrix;

import util.CommonUtil;

import java.util.*;
import java.util.stream.Collectors;

public class CommonElementInAllRow {



    public static void main(String [] args){

        int [][]mat = CommonUtil.getMatrixInput();
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, Set<Integer>> counter = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(counter.containsKey(mat[i][j])){
                    Set<Integer> rows = counter.get(mat[i][j]);
                    rows.add(i);
                    counter.replace(mat[i][j], rows);
                }
                else{
                    Set<Integer> s = new HashSet<>();
                    s.add(i);
                    counter.put(mat[i][j], s);
                }
            }
        }

        List<Integer> ans = counter.keySet().stream().filter(key -> counter.get(key).size()==n).collect(Collectors.toList());
        System.out.println(ans);


    }

}
