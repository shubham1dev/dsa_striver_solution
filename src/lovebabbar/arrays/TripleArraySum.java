package lovebabbar.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class TripleArraySum {

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]A = new int[n];
        IntStream.range(0,n).forEach(x-> A[x]=sc.nextInt());
        int x = sc.nextInt();
        Arrays.sort(A);
        Set<Integer> counter = new HashSet<>();
        IntStream.range(0,n).forEach(i-> counter.add(A[i]));
        for(int i=0;i<n;i++){



        }


    }

}
