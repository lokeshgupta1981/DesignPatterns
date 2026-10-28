package com.howtodoinjava.patterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        OrderCatalog first = OrderCatalog.INSTANCE;
        OrderCatalog second = OrderCatalog.INSTANCE;
        System.out.println("enum same instance: " + (first == second));
        System.out.println("order currency: " + first.currencyCode());

        LazyCatalog lazyFirst = LazyCatalog.getInstance();
        LazyCatalog lazySecond = LazyCatalog.getInstance();
        System.out.println("holder same instance: " + (lazyFirst == lazySecond));
        System.out.println("holder currency: " + lazyFirst.currencyCode());
    }
}
