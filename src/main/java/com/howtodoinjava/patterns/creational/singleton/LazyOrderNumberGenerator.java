package com.howtodoinjava.patterns.creational.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public final class LazyOrderNumberGenerator {
    private final AtomicInteger next = new AtomicInteger();

    private LazyOrderNumberGenerator() {
    }

    private static class Holder {
        private static final LazyOrderNumberGenerator INSTANCE = new LazyOrderNumberGenerator();
    }

    public static LazyOrderNumberGenerator getInstance() {
        return Holder.INSTANCE;
    }

    public int nextNumber() {
        return next.incrementAndGet();
    }
}
