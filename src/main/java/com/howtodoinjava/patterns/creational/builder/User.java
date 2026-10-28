package com.howtodoinjava.patterns.creational.builder;

import java.util.Objects;

public final class User {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String phone;

    private User(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        phone = builder.phone;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " age=" + age + " phone=" + phone;
    }

    public static final class Builder {
        private final String firstName;
        private final String lastName;
        private Integer age;
        private String phone;

        public Builder(String firstName, String lastName) {
            this.firstName = requireName(firstName);
            this.lastName = requireName(lastName);
        }

        public Builder age(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.age = age;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = Objects.requireNonNull(phone, "phone");
            return this;
        }

        public User build() {
            return new User(this);
        }

        private static String requireName(String name) {
            Objects.requireNonNull(name, "name");
            if (name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank");
            }
            return name;
        }
    }
}
