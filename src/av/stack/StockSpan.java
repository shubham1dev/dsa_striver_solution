package av.stack;

import util.CommonUtil;

import java.util.Stack;

public class StockSpan {

    public static void main(String []args){

        int []arr = CommonUtil.getArrayInput();
        int n = arr.length;

        optimal(arr,n);


    }

    public static void optimal(int[] arr, int n) {

        Stack<Integer> st = new Stack<>();
        int []ans = new int[n];
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                ans[i] = 1;
                st.push(i);
            }
            else{

                int count =1;
                while((!st.isEmpty()) && arr[st.peek()]<arr[i]){
                    int val = st.pop();
                    count+=ans[val];
                }

                ans[i] = count;
                st.push(i);

            }
        }

        CommonUtil.printArray(ans, n);

    }

}
