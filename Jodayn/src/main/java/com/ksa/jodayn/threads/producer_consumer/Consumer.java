package com.ksa.jodayn.threads.producer_consumer;

import java.io.IOException;

public class Consumer implements Runnable {
    private final SynchronizedResourceQueue<Integer> queue;

    public Consumer(SynchronizedResourceQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take();
                while (item != null) {
                    System.out.println("Consumed: " + item);
                    item = queue.take();
                }
                synchronized (queue) {
                    queue.wait();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (IOException ignore) {

        }
    }
}
