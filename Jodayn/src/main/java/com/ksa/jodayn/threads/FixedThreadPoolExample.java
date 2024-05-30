package com.ksa.jodayn.threads;

import java.util.concurrent.*;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        executor.setCorePoolSize(2);
        executor.setMaximumPoolSize(4);
        executor.setKeepAliveTime(10, TimeUnit.SECONDS);


        // Submit tasks for execution
        for (int i = 0; i < 3; i++) {
            Runnable task = new Task("" + i);
            executor.execute(task);
        }

        // Shutdown the executor
        executor.shutdown();
    }
}

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + " is running on " + Thread.currentThread().getName());
    }
}
