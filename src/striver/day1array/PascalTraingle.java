package striver.day1array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalTraingle {

    public static void main(String [] args){

        List<List<Integer>> traingle = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            if(i==0){
                traingle.add(Arrays.asList(1));
            }
            else{
                List<Integer> temp = new ArrayList<>();
                List<Integer> prev = traingle.get(i-1);
                temp.add(prev.get(0));
                for(int j=0;j<prev.size()-1;j++){
                    temp.add(prev.get(j)+prev.get(j+1));
                }
                temp.add(prev.get(prev.size()-1));
                traingle.add(temp);
            }
        }

        System.out.println(traingle);

    }

}
