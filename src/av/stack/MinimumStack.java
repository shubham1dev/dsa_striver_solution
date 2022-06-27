package av.stack;

import java.util.Stack;

public class MinimumStack {

    static class MinStack {

        Stack<Integer> astack;
        Stack<Integer> mstack;

        public MinStack() {
            astack = new Stack<>();
            mstack = new Stack<>();
        }

        public void push(int val) {
            astack.push(val);
            if(astack.size()==1){
                mstack.push(val);
            }
            else{
                if(val<=mstack.peek()){

                    mstack.push(val);

                }
            }

        }

        public void pop() {

            if(astack.size()==0){
                return;
            }

            if(astack.peek().intValue()==mstack.peek().intValue()){
                astack.pop();
                mstack.pop();
            }
            else{
                astack.pop();
            }

        }

        public int top() {
            if(astack.size()==0){
                return -1;
            }

            return astack.peek();
        }

        public int getMin() {

            if(mstack.size()==0){
                return -1;
            }
            return mstack.peek();

        }
    }

    static class MinStackWithoutSpace {

        Stack<Long> astack;
        long minelement;

        public MinStackWithoutSpace() {
            astack = new Stack<>();
            minelement = -1;
        }

        public void push(int val) {

            if(astack.size()==0){
                astack.push((long)val);
                minelement = val;
            }
            else{

                if(val<minelement){
                    long flag = (2*(long)val)-minelement;
                    astack.push(flag);
                    minelement = val;
                }
                else{
                    astack.push((long)val);
                }
            }

        }

        public void pop() {

            if(astack.size()==0){
                return;
            }
            else if(astack.peek()<minelement){
                minelement = (2*minelement)-astack.peek();
                astack.pop();
            }
            else{
                astack.pop();
            }
        }

        public int top() {

            if(astack.isEmpty()){
                return -1;
            }
            else if(astack.peek().longValue()<minelement){
                return (int)minelement;
            }
            else{
                return (int)astack.peek().longValue();
            }

        }

        public int getMin() {

            if(astack.size()==0){
                return -1;
            }
            return (int)minelement;
        }
    }


    public static void main(String [] args){

        MinStackWithoutSpace minStack = new MinStackWithoutSpace();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }

}
