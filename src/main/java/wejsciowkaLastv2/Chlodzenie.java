package wejsciowkaLastv2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Chlodzenie implements Runnable{

    private BlockingQueue<Integer> tasmaZFormowania;
    private BlockingQueue<Integer> tasmaDoSilnika;

    public Chlodzenie(BlockingQueue<Integer> tasmaZFormowania, BlockingQueue<Integer> tasmaDoSilnika) {
        this.tasmaZFormowania = tasmaZFormowania;
        this.tasmaDoSilnika = tasmaDoSilnika;
    }

    @Override
    public void run() {
        try{
            while(true){
                int obudowa1 = tasmaZFormowania.take();
                int obudowa2 = tasmaZFormowania.take();
                int obudowa3= tasmaZFormowania.take();
                System.out.println("Obudowy nr: "+obudowa1+", "+obudowa2+", "+obudowa3+", "+" trafily do chlodzenia (temp. 150 stopni celsjusza");
                Thread.sleep(350);
                tasmaDoSilnika.put(obudowa1);
                System.out.println("Obudowa nr: "+obudowa1+ "trafila na tasme do montazu silnika po schlodzeniu (temp. 30 stopni celsjusza");
                tasmaDoSilnika.put(obudowa2);
                System.out.println("Obudowa nr: "+obudowa2+ "trafila na tasme do montazu silnika po schlodzeniu (temp. 30 stopni celsjusza");
                tasmaDoSilnika.put(obudowa3);
                System.out.println("Obudowa nr: "+obudowa3+ "trafila na tasme do montazu silnika po schlodzeniu (temp. 30 stopni celsjusza");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }}