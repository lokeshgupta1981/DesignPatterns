package com.howtodoinjava.patterns.creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        User complete = new User.Builder("Lokesh", "Gupta")
                .age(30).phone("1234567").build();
        User namesOnly = new User.Builder("Jack", "Reacher").build();

        System.out.println(complete);
        System.out.println(namesOnly);

        try {
            new User.Builder("", "Gupta");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid name: " + e.getMessage());
        }
        try {
            new User.Builder("Jane", "Doe").age(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid age: " + e.getMessage());
        }
    }
}
