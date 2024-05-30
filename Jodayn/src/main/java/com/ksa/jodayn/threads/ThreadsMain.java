package com.ksa.jodayn.threads;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


class ReflectionExample {
    public static void main(String[] args) {
        // Replace YourClass.class with the class you want to inspect
        Class<?> clazz = String.class;

        // Get all methods (public, protected, package-private, and private)
        Method[] methods = clazz.getDeclaredMethods();

        // Print details of each method
        for (Method method : methods) {
            // Method name
            System.out.println("Method Name: " + method.getName());

            // Return type
            System.out.println("Return Type: " + method.getReturnType().getName());

            // Parameter types
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.print("Parameter Types: ");
            for (Class<?> paramType : parameterTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();

            // Modifiers
            int modifiers = method.getModifiers();
            System.out.println("Modifiers: " + Modifier.toString(modifiers));

            System.out.println("---------");
        }
    }
}

///////////////////////////////////////////////////////

class Resource {
    private static final Resource INSTANCE = new Resource();

    private final Object KEY1 = new Object();
    private final Object KEY2 = new Object();

    public static Resource getInstance() {
        return INSTANCE;
    }

    private Resource() {
    }

    private int counter1 = 0;
    private int counter2 = 0;

    public void setCounter1(int counter1) {
        synchronized (KEY1) {
            synchronized (KEY2) {
                this.counter1 = counter1;
            }
        }
    }

    public synchronized void setCounter2(int counter2) {
        synchronized (KEY2) {
            this.counter2 = counter2;
        }
    }

    public synchronized int getCounter1() {
        synchronized (KEY1) {
            return counter1;
        }
    }

    public synchronized int getCounter2() {
        synchronized (KEY2) {
            return counter2;
        }
    }
}


class Worker implements Runnable {
    private final String threadName;

    Worker(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Resource resource = Resource.getInstance();
        for (int i = 0; i < 10; i++) {
            resource.setCounter1(resource.getCounter1() + 1);
            System.out.println(threadName + " => " + i);
            System.out.println(threadName + " Resource value = " + resource.getCounter1());
            Thread.yield();
        }
    }
}

public class ThreadsMain {

    public static void main(String[] args) throws InterruptedException {

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Cores: " + cores);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Worker("T(" + (i + 1) + ")")));
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Hello World");
    }
}
