package thread.project1;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class SumOfRange implements Callable<Integer> {

    int i;
    int j;
    int []arr;

    public SumOfRange(int i, int j, int []arr) {
        this.i = i;
        this.j = j;
        this.arr = arr;
    }

    @Override
    public Integer call(){

        int total = 0;
        for(int a=i;a<j;a++){

            total+=arr[a];

        }
        return total;
    }

}

public class Problem1 {

    public static void main(String []args) throws ExecutionException, InterruptedException {

        int []arr= CommonUtil.getArrayInput();
        int n = arr.length;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int m = 3;
        int i = 0;
        int j = 0;
        List<Future<Integer>> result = new ArrayList<>();
        while(true) {
            i=j;
            j+=m;
            if(j>=n){
                Future<Integer> future = executorService.submit(new SumOfRange(i,n,arr));
                result.add(future);
                break;
            }
            Future<Integer> future = executorService.submit(new SumOfRange(i,j,arr));
            result.add(future);
        }


        //wait
        List<Integer> output = new ArrayList<>();
        for(i=0;i<result.size();i++){

            while(!result.get(i).isDone()){

            }
            output.add(result.get(i).get());

        }

        int total = 0;
        for(i=0;i<output.size();i++)
            total+=output.get(i);

        System.out.println(total);

    }

}
