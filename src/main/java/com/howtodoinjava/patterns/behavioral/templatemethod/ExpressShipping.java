package com.howtodoinjava.patterns.behavioral.templatemethod;

import java.math.BigDecimal;

public final class ExpressShipping extends ShippingQuote {
    @Override
    protected BigDecimal baseCharge(int weightKg) {
        return new BigDecimal("6.00")
                .add(new BigDecimal("2.50").multiply(BigDecimal.valueOf(weightKg)));
    }

    @Override
    protected BigDecimal surcharge(Shipment shipment) {
        return shipment.peakPeriod() ? new BigDecimal("2.00") : BigDecimal.ZERO;
    }
}
