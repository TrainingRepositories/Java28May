package com.ksa.jodayn.threads.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        SynchronizedResourceQueue<Integer> queue = new SynchronizedResourceQueue<>();
        int maxCount = 20;

        Thread producerThread = new Thread(new Producer(queue, maxCount));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
