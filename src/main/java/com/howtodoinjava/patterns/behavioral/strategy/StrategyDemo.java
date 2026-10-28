package com.howtodoinjava.patterns.behavioral.strategy;

public final class StrategyDemo {
    public static void main(String[] args) {
        Checkout regular = new Checkout(new RegularDiscount());
        Checkout member = new Checkout(new MemberDiscount());

        System.out.println("Regular customer = " + regular.totalCents(10000));
        System.out.println("Member = " + member.totalCents(10000));
        System.out.println("Member with 99 cents = " + member.totalCents(99));
    }
}
