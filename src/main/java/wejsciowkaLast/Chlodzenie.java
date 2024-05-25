package wejsciowkaLast;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Chlodzenie implements Runnable{
    private BlockingQueue<Integer> tasmaZTloczni;
    private BlockingQueue<Integer> tasmaDoMontazu;

    public Chlodzenie(BlockingQueue<Integer> tasmaZTloczni, BlockingQueue<Integer> tasmaDoMontazu) {
        this.tasmaZTloczni = tasmaZTloczni;
        this.tasmaDoMontazu = tasmaDoMontazu;
    }

    @Override
    public void run() {
        try{
            while (true){
                int obudowa1 =tasmaZTloczni.take();
                int obudowa2 =tasmaZTloczni.take();
                int obudowa3 =tasmaZTloczni.take();
                int obudowa4 =tasmaZTloczni.take();
                System.out.println("Obudowy nr: " +obudowa1+", "+obudowa2+", "+obudowa3+", "+obudowa4+", "+ "Zostaly wlozone do chlodni(temperatura 250 stopni celsjusza)");
                Thread.sleep(500);
                System.out.println("Obudowy nr: " +obudowa1+", "+obudowa2+", "+obudowa3+", "+obudowa4+", "+ "Opuscily chlodnie(temperatura 30 stopni celsjusza)");
                tasmaDoMontazu.put(obudowa1);
                tasmaDoMontazu.put(obudowa2);
                tasmaDoMontazu.put(obudowa3);
                tasmaDoMontazu.put(obudowa4);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}