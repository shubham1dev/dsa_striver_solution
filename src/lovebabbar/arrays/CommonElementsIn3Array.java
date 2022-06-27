package lovebabbar.arrays;


import java.util.*;
import java.util.stream.IntStream;

public class CommonElementsIn3Array {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int []A = new int[n1];
        IntStream.range(0,n1).forEach(x-> A[x]=sc.nextInt());
        int n2 = sc.nextInt();
        int []B = new int[n2];
        IntStream.range(0,n2).forEach(x-> B[x]=sc.nextInt());
        int n3 = sc.nextInt();
        int []C = new int[n3];
        IntStream.range(0,n3).forEach(x-> C[x]=sc.nextInt());

        Map<Integer, Integer> tab1 = new TreeMap<>();
        IntStream.range(0,n1).forEach(x -> tab1.put(A[x],1));
        Map<Integer, Integer> tab2 = new TreeMap<>();
        IntStream.range(0,n2).forEach(x -> tab2.put(B[x],1));
        Map<Integer, Integer> tab3 = new TreeMap<>();
        IntStream.range(0,n3).forEach(x -> tab3.put(C[x],1));

        ArrayList<Integer>ans= new ArrayList<>();
        Iterator<Integer> it = tab1.keySet().iterator();
        while(it.hasNext()){
            int k = it.next();
            if(tab2.containsKey(k) && tab3.containsKey(k)){
                ans.add(k);
            }
        }
        if(ans.isEmpty()){
            ans.add(-1);
        }
        System.out.println(ans);
    }

}
