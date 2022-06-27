package av.stack;

import util.CommonUtil;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class NearestGreaterToRight {

    public static void bruteforce(int[] arr, int n){

        int []ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    ans[i]=j;
                    break;
                }
            }
        }
        System.out.print("Bruteforce Solution => ");

        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public static void optimal(int[] arr, int n){

        int []ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                st.push(i);
                ans[i]=-1;
            }
            else{
                while((!st.isEmpty()) && arr[st.peek()]<=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i] = -1;
                    st.push(i);
                }
                else{
                    ans[i] = st.peek();
                    st.push(i);
                }
            }
        }

        System.out.print("Optimal Solution => ");
        IntStream.range(0,n).forEach(x-> System.out.print(ans[x]+ " " ));
        System.out.println();



    }

    public static void main(String[] args){

        int[] arr = CommonUtil.getArrayInput();
        int n = arr.length;
        bruteforce(arr,n);
        optimal(arr,n);
    }

}
