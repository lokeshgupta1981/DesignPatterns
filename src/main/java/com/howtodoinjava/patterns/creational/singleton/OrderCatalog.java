package com.howtodoinjava.patterns.creational.singleton;

public enum OrderCatalog {
    INSTANCE;

    public String currencyCode() {
        return "USD";
    }
}
