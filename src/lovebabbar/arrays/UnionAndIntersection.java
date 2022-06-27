package lovebabbar.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class UnionAndIntersection {

    public static void main(String []args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []arr1 = new int[n];
        IntStream.range(0,n).forEach(i->arr1[i] = scanner.nextInt());
        int m = scanner.nextInt();
        int []arr2 = new int[m];
        IntStream.range(0,m).forEach(i->arr2[i] = scanner.nextInt());
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i =0,j=0;
        List<Integer> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        while(i<n && j<m){

            while(i<(n-1)&&(arr1[i]==arr1[i+1])){
                i++;
            }

            while(j<(m-1) &&(arr2[j]==arr2[j+1])){
                j++;
            }


            if(arr1[i]==arr2[j]){
                ans.add(arr1[i]);
                i++;
                j++;
            }

            else if(arr1[i]<arr2[j]){
                ans.add(arr1[i]);
                i++;
            }

            else {
                ans.add(arr2[j]);
                j++;
            }


        }

        while(i<n){
            ans.add(arr1[i]);
            i++;
        }

        while(j<m){

            ans.add(arr2[j]);
            j++;
        }

        i=0;j=0;
        while(i<n && j<m){

            while(j<(m-1) && (arr2[j]==arr2[j+1])){
                j++;
            }

            while(i<(n-1) && (arr1[i]==arr1[i+1])){
                i++;
            }

            if(arr1[i]==arr2[j]){
                ans1.add(arr1[i]);
                i++;
                j++;
            }

            else if(arr1[i]<arr2[j]){
                i++;
            }
            else{
                j++;
            }

        }

        System.out.print("Union of 2 arrays => " );
        IntStream.range(0, ans.size()).forEach(p->System.out.print(ans.get(p)+" "));
        System.out.print("\nIntersection of 2 arrays => ");
        IntStream.range(0, ans1.size()).forEach(p->System.out.print(ans1.get(p)+" "));

    }

}
