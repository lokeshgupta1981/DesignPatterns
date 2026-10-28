package com.howtodoinjava.patterns.creative.factory;

import java.util.Objects;

public class FactoryDemo {
    public static void main(String[] args) {
        for (CarType type : CarType.values()) {
            Car car = CarFactory.create(type);
            System.out.println(type + " -> " + car.model());
        }

        Car first = CarFactory.create(CarType.SEDAN);
        Car second = CarFactory.create(CarType.SEDAN);
        System.out.println("Two requests create distinct cars: " + (first != second));

        try {
            CarFactory.create(null);
        } catch (NullPointerException exception) {
            System.out.println("Null request: " + exception.getMessage());
        }
    }
}

enum CarType { SMALL, SEDAN, LUXURY }

interface Car {
    String model();
}

final class SmallCar implements Car {
    public String model() { return "Small"; }
}

final class SedanCar implements Car {
    public String model() { return "Sedan"; }
}

final class LuxuryCar implements Car {
    public String model() { return "Luxury"; }
}

final class CarFactory {
    private CarFactory() { }

    static Car create(CarType type) {
        Objects.requireNonNull(type, "car type is required");
        return switch (type) {
            case SMALL -> new SmallCar();
            case SEDAN -> new SedanCar();
            case LUXURY -> new LuxuryCar();
        };
    }
}
