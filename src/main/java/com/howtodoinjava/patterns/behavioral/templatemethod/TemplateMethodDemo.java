package com.howtodoinjava.patterns.behavioral.templatemethod;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        ShippingQuote standard = new StandardShipping();
        ShippingQuote express = new ExpressShipping();
        Shipment regular = new Shipment(2, false);
        Shipment peak = new Shipment(2, true);
        System.out.println("Standard: " + standard.quote(regular));
        System.out.println("Express: " + express.quote(regular));
        System.out.println("Standard at peak: " + standard.quote(peak));
        System.out.println("Express at peak: " + express.quote(peak));
        try {
            express.quote(new Shipment(0, false));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid shipment: " + e.getMessage());
        }
    }
}
