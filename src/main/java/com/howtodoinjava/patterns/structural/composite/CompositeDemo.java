package com.howtodoinjava.patterns.structural.composite;

import java.util.List;

interface AccountComponent {
    long balanceCents();
}

record Account(long balanceCents) implements AccountComponent {
}

final class Portfolio implements AccountComponent {
    private final List<AccountComponent> children;

    Portfolio(List<AccountComponent> children) {
        this.children = List.copyOf(children);
    }

    @Override
    public long balanceCents() {
        long total = 0;
        for (AccountComponent child : children) {
            total = Math.addExact(total, child.balanceCents());
        }
        return total;
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        AccountComponent savings = new Account(20_000);
        AccountComponent deposits = new Portfolio(List.of(
                new Account(10_000), new Account(15_000)));
        AccountComponent customer = new Portfolio(List.of(savings, deposits));

        System.out.println("Savings: " + savings.balanceCents());
        System.out.println("Deposits: " + deposits.balanceCents());
        System.out.println("Customer: " + customer.balanceCents());

        AccountComponent repeated = new Portfolio(List.of(savings, savings));
        System.out.println("Repeated account: " + repeated.balanceCents());

        try {
            new Portfolio(List.of(new Account(Long.MAX_VALUE), new Account(1)))
                    .balanceCents();
        } catch (ArithmeticException e) {
            System.out.println("Overflow rejected: " + e.getMessage());
        }
    }
}
