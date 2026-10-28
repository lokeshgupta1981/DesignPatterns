package com.howtodoinjava.patterns.creational.abstractfactory;

interface Steering {
    String layout();
}

interface Dashboard {
    String layout();
}

record LeftSteering() implements Steering {
    public String layout() { return "Left-hand drive"; }
}

record RightSteering() implements Steering {
    public String layout() { return "Right-hand drive"; }
}

record LeftDashboard() implements Dashboard {
    public String layout() { return "Left-hand drive"; }
}

record RightDashboard() implements Dashboard {
    public String layout() { return "Right-hand drive"; }
}

interface CarPartsFactory {
    Steering createSteering();
    Dashboard createDashboard();
}

final class LeftDriveFactory implements CarPartsFactory {
    public Steering createSteering() { return new LeftSteering(); }
    public Dashboard createDashboard() { return new LeftDashboard(); }
}

final class RightDriveFactory implements CarPartsFactory {
    public Steering createSteering() { return new RightSteering(); }
    public Dashboard createDashboard() { return new RightDashboard(); }
}

final class CarAssembly {
    String assemble(CarPartsFactory factory) {
        Steering steering = factory.createSteering();
        Dashboard dashboard = factory.createDashboard();
        if (!steering.layout().equals(dashboard.layout())) {
            throw new IllegalArgumentException("Steering and dashboard layouts differ");
        }
        return steering.layout() + " steering with " + dashboard.layout() + " dashboard";
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CarAssembly assembly = new CarAssembly();
        System.out.println(assembly.assemble(new LeftDriveFactory()));
        System.out.println(assembly.assemble(new RightDriveFactory()));

        CarPartsFactory brokenFactory = new CarPartsFactory() {
            public Steering createSteering() { return new LeftSteering(); }
            public Dashboard createDashboard() { return new RightDashboard(); }
        };
        try {
            assembly.assemble(brokenFactory);
        } catch (IllegalArgumentException exception) {
            System.out.println("Rejected mismatched parts: " + exception.getMessage());
        }
    }
}
