package com.howtodoinjava.patterns.structural.adapter;

import java.util.Objects;

public class AdapterDemo {
    interface TemperatureSensor {
        double readCelsius();
    }

    static final class LegacyThermometer {
        private final double reading;

        LegacyThermometer(double reading) {
            this.reading = reading;
        }

        double readFahrenheit() {
            return reading; // -999.0 means the legacy sensor failed.
        }
    }

    static final class FahrenheitAdapter implements TemperatureSensor {
        private final LegacyThermometer thermometer;

        FahrenheitAdapter(LegacyThermometer thermometer) {
            this.thermometer = Objects.requireNonNull(thermometer);
        }

        @Override
        public double readCelsius() {
            double fahrenheit = thermometer.readFahrenheit();
            if (fahrenheit == -999.0) {
                throw new IllegalStateException("Sensor reading unavailable");
            }
            return (fahrenheit - 32.0) * 5.0 / 9.0;
        }
    }

    public static void main(String[] args) {
        show(77.0);
        show(32.0);
        show(-999.0);
    }

    private static void show(double fahrenheit) {
        TemperatureSensor sensor = new FahrenheitAdapter(new LegacyThermometer(fahrenheit));
        try {
            System.out.printf("%.1f F -> %.1f C%n", fahrenheit, sensor.readCelsius());
        } catch (IllegalStateException ex) {
            System.out.printf("%.1f F -> %s%n", fahrenheit, ex.getMessage());
        }
    }
}
