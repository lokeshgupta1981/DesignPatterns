package com.howtodoinjava.patterns.behavioral.templatemethod;

abstract class House {
    public final void buildHouse() {
        constructFoundation();
        constructWalls();
        constructRoof();
        finishHouse();
        afterBuild();
    }

    private void constructFoundation() {
        System.out.println("Foundation built");
    }

    protected abstract void constructWalls();

    private void constructRoof() {
        System.out.println("Roof built");
    }

    protected abstract void finishHouse();

    protected void afterBuild() {
    }
}

final class ConcreteWallHouse extends House {
    @Override
    protected void constructWalls() {
        System.out.println("Concrete walls built");
    }

    @Override
    protected void finishHouse() {
        System.out.println("Rooms painted");
    }
}

final class GlassWallHouse extends House {
    @Override
    protected void constructWalls() {
        System.out.println("Glass walls built");
    }

    @Override
    protected void finishHouse() {
        System.out.println("Blinds fitted");
    }

    @Override
    protected void afterBuild() {
        System.out.println("Glass inspection scheduled");
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        House concrete = new ConcreteWallHouse();
        concrete.buildHouse();
        System.out.println("---");
        House glass = new GlassWallHouse();
        glass.buildHouse();
    }
}
