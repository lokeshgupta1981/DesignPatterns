package com.howtodoinjava.patterns.creational.singleton;

public final class LazyCatalog {
    private LazyCatalog() {
    }

    private static class Holder {
        private static final LazyCatalog INSTANCE = new LazyCatalog();
    }

    public static LazyCatalog getInstance() {
        return Holder.INSTANCE;
    }

    public String currencyCode() {
        return "USD";
    }
}
