package wejsciowkaLastv2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Silnik implements Runnable{

    private BlockingQueue<Integer> tasmaZChlodzenia;

    public Silnik(BlockingQueue<Integer> tasmaZChlodzenia) {
        this.tasmaZChlodzenia = tasmaZChlodzenia;
    }

    @Override
    public void run() {
        try{
            while(true){
                int obudowa = tasmaZChlodzenia.take();
                Thread.sleep(700);
                System.out.println("Obudowa nr: "+obudowa+" zostala zaopatrzona w silnik i trafila do magazynu (temp. 30 stopni celsjusza)");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}