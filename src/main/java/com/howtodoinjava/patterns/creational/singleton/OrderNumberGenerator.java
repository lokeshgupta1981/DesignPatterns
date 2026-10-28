package com.howtodoinjava.patterns.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public enum OrderNumberGenerator {
    INSTANCE;

    private final AtomicInteger next = new AtomicInteger();

    public int nextNumber() {
        return next.incrementAndGet();
    }
}
