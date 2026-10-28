package com.howtodoinjava.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Discount(String rule, BigDecimal amount) {
    public static Discount percentage(String rule, BigDecimal subtotal, String rate) {
        BigDecimal amount = subtotal.multiply(new BigDecimal(rate))
                .setScale(2, RoundingMode.HALF_UP);
        return new Discount(rule, amount);
    }
}
