package striver.day14stackqueue2;

import util.CommonUtil;

import java.util.Stack;

public class LargestHistogram {

    public int[] solveright(int[] height) {

        int []rs = new int[height.length];
        Stack<Integer> st = new Stack<>();
        for(int i=height.length-1;i>=0;i--){

            if(i==(height.length-1)){
                rs[i]=height.length;
                st.push(i);
            }
            else  {

                while((!st.isEmpty()) && height[st.peek()]>=height[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    st.push(i);
                    rs[i]=height.length;
                }
                else {

                    rs[i] = st.peek();
                    st.push(i);
                }


            }

        }
        return rs;

    }

    public int[] solveleft(int[] height) {
        int []ls = new int[height.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<height.length;i++){

            if(i==0){
                st.push(i);
                ls[i] = -1;
            }
            else {

                while((!st.isEmpty()) && height[st.peek()]>=height[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    st.push(i);
                    ls[i]=-1;
                }
                else {

                    ls[i] = st.peek();
                    st.push(i);
                }

            }

        }
        return ls;
    }

    public int largestRectangleArea(int[] heights) {

        int []ls = solveleft(heights);
        int []rs = solveright(heights);

        int ans = 0;
        for(int i=0;i<heights.length;i++){

            int h = heights[i];
            int len = 0;

            len = (i - ls[i]) + (rs[i] - i) - 1;
            ans = Math.max(ans, h*len);

        }

        return ans;

    }

    public static void main(String []args) {

        int []arr = CommonUtil.getArrayInput();
        int ans = new LargestHistogram().largestRectangleArea(arr);
        System.out.println(ans);
    }

}
