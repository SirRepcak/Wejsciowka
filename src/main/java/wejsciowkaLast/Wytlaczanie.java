package wejsciowkaLast;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Wytlaczanie implements Runnable{

    private BlockingQueue<Integer> tasmaDoChlodni;
    private AtomicInteger possibleSerial;
    private int serial;

    public Wytlaczanie(BlockingQueue<Integer> tasmaDoChlodni, AtomicInteger possibleSerial) {
        this.tasmaDoChlodni = tasmaDoChlodni;
        this.possibleSerial = possibleSerial;
    }

    @Override
    public void run() {
        try{
            while (true){
            Thread.sleep(10);
            serial = possibleSerial.getAndIncrement();
            tasmaDoChlodni.put(serial);
            System.out.println("Obudowa nr: " +serial + " opuscila tlocznie (temp 250 stopni C)");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
