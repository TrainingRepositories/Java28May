package com.ksa.jodayn.threads.producer_consumer;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SynchronizedResourceQueue<T> implements Closeable {

    private final List<T> resources = new ArrayList<>();
    private boolean closed = false;

    synchronized T take() throws IOException {
        if (closed){
            throw new IOException("Resource closed");
        }
        if (resources.isEmpty()) {
            return null;
        }
        return resources.remove(0);
    }

    synchronized void put(T value) {
        resources.add(value);
    }

    @Override
    public synchronized void close() {
        closed = true;
    }
}
