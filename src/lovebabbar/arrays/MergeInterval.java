package lovebabbar.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class MergeInterval {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]interval = new int[n][2];
        IntStream.range(0,n).forEach(i-> {
            interval[i][0] = sc.nextInt();
            interval[i][1] = sc.nextInt();
        });

        Arrays.sort(interval, Comparator.comparingDouble(o-> o[0]));

        int min = interval[0][0];
        int max = interval[0][1];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(interval[i][0]<=max){

                if(interval[i][1]>max){
                    max = interval[i][1];
                }

            }
            else{
                ans.add(Arrays.asList(min, max));
                min = interval[i][0];
                max = interval[i][1];
            }
        }

        ans.add(Arrays.asList(min, max));
        int [][]response = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            response[i][0] = ans.get(i).get(0);
            response[i][1] = ans.get(i).get(1);
        }

    }

}
