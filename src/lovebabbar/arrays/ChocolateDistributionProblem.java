package lovebabbar.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class ChocolateDistributionProblem {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        IntStream.range(0,n).forEach(x-> a.add(sc.nextInt()));
        int m = sc.nextInt();
        Collections.sort(a);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<(n-m+1);i++){
            ans = Math.min(a.get(i+m-1)-a.get(i),ans);
        }
        System.out.println(ans);

    }

}
