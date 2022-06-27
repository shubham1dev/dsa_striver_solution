package lovebabbar.matrix;

import util.CommonUtil;

import java.util.Stack;

public class Max1Rectangle {

    public static void main(String []args){

        int[][]arr = CommonUtil.getMatrixInput();
        int n = arr.length;
        int m = arr[0].length;
        solve(arr, n, m);

    }

    public static int maxArea(int[]arr, int n){


        Stack<Integer> st = new Stack<>();
        int []sl = new int[n];
        for(int i=0;i<n;i++){

            if(st.isEmpty()){
                sl[i]=1;
                st.push(i);
            }
            else{
                while((!st.isEmpty()) && arr[st.peek()]>=arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    sl[i]=i+1;
                }
                else{
                    sl[i] = i- st.peek();
                }

                st.push(i);

            }

        }

        st.clear();
        int []sr = new int[n];
        for(int i=n-1;i>=0;i--){

            if(st.isEmpty()){
                sr[i]=1;
                st.push(i);
            }
            else{
                while((!st.isEmpty()) && arr[st.peek()]>=arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    sr[i]=n-i;
                }
                else{
                    sr[i] = st.peek()-i;
                }

                st.push(i);

            }

        }

        int maxa = 0;
        for(int i=0;i<n;i++){

            int val = (sl[i]+sr[i]-1)*arr[i];
            maxa = Math.max(maxa, val);
        }

        return maxa;

    }

    public static void solve(int[][] arr, int n, int m) {

        int ans = 0;
        for(int i=0;i<n;i++){


            int []height = new int[m];
            for(int j=0;j<m;j++){

                int p = i;
                int count = 0;
                while(p>=0 && arr[p][j]==1){
                    count++;
                    p--;
                }
                height[j]=count;

            }
            int ma = maxArea(height, m);
            ans = Math.max(ma, ans);
        }

        System.out.println("Maximum Area in Binary Matrix => "+ ans);

    }

}
