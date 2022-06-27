package striver.day14stackqueue2;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanner {

    class Pair {
        int val;
        int pos;

        public Pair(int val, int pos) {
            this.pos = pos;
            this.val = val;
        }
    }

    int total = 0;
    Stack<Pair> st;

    public StockSpanner() {

        st = new Stack<>();

    }

    public int next(int price) {

        if(st.empty()){
            st.push(new Pair(price, total));
            total++;
            return total;
        }
        else {

            while((!st.isEmpty()) && st.peek().val<=price){
                st.pop();
            }

            if(st.isEmpty()){
                st.push(new Pair(price, total));
                total++;
                int ans = total;
                return ans;
            }
            else{
                int val = total-st.peek().pos;
                st.push(new Pair(price, total));
                total++;
                return val;

            }

        }

    }

    public static void main(String []args) {

        StockSpanner ss = new StockSpanner();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            System.out.println(ss.next(sc.nextInt()));
        }

    }

}
