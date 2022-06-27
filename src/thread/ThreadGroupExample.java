package thread;

class MyThread implements Runnable {

    @Override
    public void run(){

        for(int i=0;i<10;i++){
            System.out.println("Y");
        }

    }

}

public class ThreadGroupExample {

    public static void main(String []args) {

        ThreadGroup ntg = new ThreadGroup("Shubham");
        ntg.setMaxPriority(4);
        MyThread myThread = new MyThread();
        Thread thread = new Thread(ntg,myThread,"thread-1");
        thread.start();

        Thread th = Thread.currentThread();
        ThreadGroup tg = th.getThreadGroup();
        tg.list();

    }

}
