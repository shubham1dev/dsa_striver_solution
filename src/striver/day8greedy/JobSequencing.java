package striver.day8greedy;

import java.util.Arrays;

public class JobSequencing {

    class Job {

        public int id, deadline, profit;
        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }

    }

    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b)-> b.profit-a.profit);
        int []slot = new int[101];
        int totalProfit = 0;
        int count = 0;
        for(Job j: arr){

            for(int i=j.deadline;i>0;i--){
                if(slot[i]==0){
                    slot[i]=1;
                    totalProfit+=j.profit;
                    count++;
                    break;
                }
            }

        }

        return new int[]{count, totalProfit};

    }

    public static void main(String []args) {




    }

}
