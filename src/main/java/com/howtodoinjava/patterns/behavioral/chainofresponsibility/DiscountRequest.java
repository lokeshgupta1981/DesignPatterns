package com.howtodoinjava.patterns.behavioral.chainofresponsibility;

import java.math.BigDecimal;
import java.util.Objects;

public record DiscountRequest(BigDecimal subtotal, String couponCode, boolean member) {
    public DiscountRequest {
        Objects.requireNonNull(subtotal, "subtotal is required");
        Objects.requireNonNull(couponCode, "couponCode is required");
        if (subtotal.signum() <= 0) {
            throw new IllegalArgumentException("subtotal must be positive");
        }
    }
}
