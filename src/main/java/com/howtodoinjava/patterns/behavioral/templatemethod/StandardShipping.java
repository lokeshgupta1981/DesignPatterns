package com.howtodoinjava.patterns.behavioral.templatemethod;

import java.math.BigDecimal;

public final class StandardShipping extends ShippingQuote {
    @Override
    protected BigDecimal baseCharge(int weightKg) {
        return new BigDecimal("3.00")
                .add(new BigDecimal("1.50").multiply(BigDecimal.valueOf(weightKg)));
    }
}
