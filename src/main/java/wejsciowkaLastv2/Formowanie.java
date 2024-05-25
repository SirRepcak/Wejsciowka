package wejsciowkaLastv2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Formowanie implements Runnable{

    private BlockingQueue<Integer> tasmaDostudzenia;
    private AtomicInteger possibleSerial;

    public Formowanie(BlockingQueue<Integer> tasmaDostudzenia, AtomicInteger possibleSerial) {
        this.tasmaDostudzenia = tasmaDostudzenia;
        this.possibleSerial = possibleSerial;
    }

    @Override
    public void run() {
        try{
            while(true){
                int serial = possibleSerial.getAndIncrement();
                tasmaDostudzenia.put(serial);
                Thread.sleep(550);
                System.out.println("Obudowa nr: "+serial+" zostala uformowania i polozona na tasmie (temp. 150 stopni celsjusza");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
