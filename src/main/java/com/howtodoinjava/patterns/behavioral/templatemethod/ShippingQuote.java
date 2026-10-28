package com.howtodoinjava.patterns.behavioral.templatemethod;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class ShippingQuote {
    public final BigDecimal quote(Shipment shipment) {
        Objects.requireNonNull(shipment, "shipment is required");
        if (shipment.weightKg() <= 0) {
            throw new IllegalArgumentException("weight must be positive");
        }
        BigDecimal base = baseCharge(shipment.weightKg());
        BigDecimal extra = surcharge(shipment);
        return base.add(extra).setScale(2, RoundingMode.HALF_UP);
    }

    protected abstract BigDecimal baseCharge(int weightKg);

    protected BigDecimal surcharge(Shipment shipment) {
        return BigDecimal.ZERO;
    }
}
