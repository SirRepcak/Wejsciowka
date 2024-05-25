package wejsciowkaLast;

import java.util.concurrent.BlockingQueue;

public class Wypelnianie implements Runnable{
    private BlockingQueue<Integer> tasmaZChlodni;

    public Wypelnianie(BlockingQueue<Integer> tasmaZChlodni) {
        this.tasmaZChlodni = tasmaZChlodni;
    }

    @Override
    public void run() {
        try{
            while (true){
                int obudowa1 = tasmaZChlodni.take();
                int obudowa2 = tasmaZChlodni.take();
                System.out.println("Obudowy nr: "+obudowa1+", "+obudowa2+" sa teraz wypelniane tuszem");
                Thread.sleep(100);
                System.out.println("Obudowy nr: "+obudowa1+", "+obudowa2+" trafily do magazynu");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
