package thread.project2;



import java.util.HashMap;
import java.util.Map;

class TicketReservationSystem {

    Map<String, Integer> trainInfo;

    public TicketReservationSystem(HashMap<String, Integer> info){
        this.trainInfo = info;
    }

    public void reserveTicket(String trainName, int ticketCount) {

       synchronized (trainInfo){
           if(trainInfo.containsKey(trainName)) {

               int tc = trainInfo.get(trainName);
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               if(tc>=ticketCount){
                   trainInfo.put(trainName, tc-ticketCount);
                   System.out.println("Tickets Booked");
               }
               else {
                   System.out.println("No Tickets Available");
               }

           }
           else {
               System.out.println("Train Not Available");
           }
       }

    }
}

class MyThread extends Thread {

    String trainName;
    int ticketCount;
    TicketReservationSystem trs;
    public MyThread (String tn, int tc, TicketReservationSystem trs) {
        this.ticketCount=tc;
        this.trainName= tn;
        this.trs=trs;
    }

    @Override
    public void run(){
        this.trs.reserveTicket(trainName,ticketCount);
    }

}


public class Problem2 {

    public static void main(String [] args) throws InterruptedException {

        HashMap<String, Integer> info = new HashMap<>();
        info.put("a",100);
        info.put("b",100);
        TicketReservationSystem trs = new TicketReservationSystem(info);

        MyThread t1 = new MyThread("a",90, trs);
        t1.start();

        MyThread t2 = new MyThread("a",100, trs);
        t2.start();

        t1.join();
        t2.join();

        System.out.println(trs.trainInfo.toString());


    }

}
