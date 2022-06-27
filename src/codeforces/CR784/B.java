package codeforces.CR784;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class B {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int []arr = new int[n];
            IntStream.range(0,n).forEach(i->arr[i] = sc.nextInt());
            Map<Integer,Integer> counter = new HashMap<>();
            for(int i:arr){

                if(counter.containsKey(i)){
                    counter.put(i,counter.get(i)+1);
                }
                else  {
                    counter.put(i,1);
                }

            }
            boolean fp = true;
            for(int i: counter.keySet()){

                if(counter.get(i)>=3){
                    fp = false;
                    System.out.println(i);
                    break;
                }


            }
            if(fp){
                System.out.println(-1);
            }

        }

    }

}
