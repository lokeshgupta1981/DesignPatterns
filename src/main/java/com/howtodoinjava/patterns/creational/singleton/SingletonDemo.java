package com.howtodoinjava.patterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        OrderNumberGenerator first = OrderNumberGenerator.INSTANCE;
        OrderNumberGenerator second = OrderNumberGenerator.INSTANCE;
        System.out.println("enum same instance: " + (first == second));
        System.out.println("enum order numbers: " + first.nextNumber() + ", " + second.nextNumber());

        LazyOrderNumberGenerator lazyFirst = LazyOrderNumberGenerator.getInstance();
        LazyOrderNumberGenerator lazySecond = LazyOrderNumberGenerator.getInstance();
        System.out.println("holder same instance: " + (lazyFirst == lazySecond));
        System.out.println("holder order numbers: " + lazyFirst.nextNumber() + ", " + lazySecond.nextNumber());
    }
}
