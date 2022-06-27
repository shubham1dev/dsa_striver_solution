package lovebabbar.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class CountPairWithGivenSum {

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        IntStream.range(0,n).forEach(x->arr[x]=sc.nextInt());
        int k = sc.nextInt();
        Map<Integer,Integer> counter = new HashMap<>();
        for(int i=0;i<n;i++){
            if(counter.containsKey(arr[i])){
                counter.put(arr[i], counter.get(arr[i])+1);
            }
            else{
                counter.put(arr[i], 1);
            }
        }

        Iterator<Integer> it = counter.keySet().iterator();
        int pair = 0;
        while(it.hasNext()) {


            int key = it.next();
            if(counter.get(key)<0){
                continue;
            }
            int rem = k-key;
            if(rem==key){
                int v = counter.get(key);
                pair+=((v*(v-1))/2);
            }
            else if(counter.containsKey(rem)){
                if(counter.get(rem)>0) {
                    pair+=(counter.get(key)*counter.get(rem));
                    counter.put(rem, -(counter.get(rem)));
                }
            }
        }

        System.out.println(pair);

    }

}
