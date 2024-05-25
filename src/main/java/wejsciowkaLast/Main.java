package wejsciowkaLast;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> tloczenieDoChlodni = new ArrayBlockingQueue<>(10);
        BlockingQueue<Integer> chlodniaDoWypelnienie = new ArrayBlockingQueue<>(10);
        AtomicInteger serial = new AtomicInteger();
        Wytlaczanie w1 = new Wytlaczanie(tloczenieDoChlodni,serial);
        Wytlaczanie w2 = new Wytlaczanie(tloczenieDoChlodni,serial);
        Wytlaczanie w3 = new Wytlaczanie(tloczenieDoChlodni,serial);
        Chlodzenie c1 = new Chlodzenie(tloczenieDoChlodni,chlodniaDoWypelnienie);
        Wypelnianie wy1 = new Wypelnianie(chlodniaDoWypelnienie);
        Wypelnianie wy2 = new Wypelnianie(chlodniaDoWypelnienie);
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w3);
        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(wy1);
        Thread t6 = new Thread(wy2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

}