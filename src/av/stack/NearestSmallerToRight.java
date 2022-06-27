package av.stack;

import util.CommonUtil;

import java.util.Stack;

public class NearestSmallerToRight {
    public static void optimal(int[] arr, int n){

        Stack<Integer> stack = new Stack<>();
        int []ans = new int[n];
        for(int i=n-1;i>=0;i--){

            if(stack.isEmpty()){
                stack.push(i);
                ans[i]=-1;
            }
            else{
                while((!stack.isEmpty()) && arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                    stack.push(i);
                }
                else{
                    ans[i] = stack.peek();
                    stack.push(i);
                }
            }

        }

        CommonUtil.printArray(ans,n);

    }

    public static void bruteforce(int []arr, int n){

        //run 2 loops
        //1 from 0, n and inner loop from i to 0

    }

    public static void main(String []args){

        int []arr = CommonUtil.getArrayInput();
        int n = arr.length;
        optimal(arr,n);

    }

}
