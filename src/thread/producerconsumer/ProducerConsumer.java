package thread.producerconsumer;

import java.util.ArrayList;
import java.util.List;

class MessageQueue {

    List<String> msg;
    int size;
    public MessageQueue(int n){
        this.msg = new ArrayList<>();
        this.size =n;
    }

    public boolean isFull(){
        if(msg.size()==size){
            return true;
        }
        else
            return false;
    }

    public boolean isEmpty(){
        if(msg.size()==0){
            return true;
        }
        return false;
    }


    public void enqueue(String msg){
        if(isFull()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.msg.add(msg);
        this.notify();
    }

    public void dequeue(){

        if(isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }


}


public class ProducerConsumer {
}
