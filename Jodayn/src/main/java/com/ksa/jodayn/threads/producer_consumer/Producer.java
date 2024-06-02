package com.ksa.jodayn.threads.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final SynchronizedResourceQueue<Integer> queue;
    private final int maxCount;

    public Producer(SynchronizedResourceQueue<Integer> queue, int maxCount) {
        this.queue = queue;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < maxCount; i++) {
                System.out.println("Produced: " + i);
                put(i);
                Thread.sleep(100); // Simulate time taken to produce an item
            }
            // End of data signal
            closeQueue();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void closeQueue(){
        queue.close();
        signalNotifyAll();
    }

    private void put(Integer value) {
        queue.put(value);
        signalNotifyAll();
    }

    private void signalNotifyAll(){
        synchronized (queue) {
            queue.notifyAll();
        }
    }

}
