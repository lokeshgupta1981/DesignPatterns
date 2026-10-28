package com.howtodoinjava.patterns.behavioral.strategy;

public interface DiscountPolicy {
    long discountCents(long subtotalCents);
}
