package wejsciowkaLastv2;

import wejsciowkaLast.Chlodzenie;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> formowanieDoChlodzenia = new ArrayBlockingQueue<>(9);
        BlockingQueue<Integer> chlodzenieDoSilnik = new ArrayBlockingQueue<>(12);
        AtomicInteger serial = new AtomicInteger();
        Formowanie f1 = new Formowanie(formowanieDoChlodzenia,serial);
        Formowanie f2 = new Formowanie(formowanieDoChlodzenia,serial);
        Chlodzenie c1 = new Chlodzenie(formowanieDoChlodzenia,chlodzenieDoSilnik);
        Silnik s1 = new Silnik(chlodzenieDoSilnik);
        Silnik s2 = new Silnik(chlodzenieDoSilnik);
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(c1);
        Thread t4 = new Thread(s1);
        Thread t5 = new Thread(s2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
