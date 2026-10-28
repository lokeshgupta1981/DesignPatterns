package com.howtodoinjava.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrototypeDemo {
    public static void main(String[] args) {
        Movie template = new Movie("Untitled", List.of("draft"));
        Movie release = template.copy();
        release.rename("Night Train");
        release.addTag("thriller");

        System.out.println("Template: " + template);
        System.out.println("Release: " + release);
        System.out.println("Different objects: " + (template != release));

        ShallowMovie shallowTemplate = new ShallowMovie("Untitled", new ArrayList<>(List.of("draft")));
        ShallowMovie shallowCopy = shallowTemplate.copy();
        shallowCopy.addTag("thriller");
        System.out.println("Shallow template tags: " + shallowTemplate.tags());
    }
}

final class Movie {
    private String title;
    private final List<String> tags;

    Movie(String title, List<String> tags) {
        this.title = Objects.requireNonNull(title);
        this.tags = new ArrayList<>(Objects.requireNonNull(tags));
    }

    Movie copy() {
        return new Movie(title, tags);
    }

    void rename(String title) {
        this.title = Objects.requireNonNull(title);
    }

    void addTag(String tag) {
        tags.add(Objects.requireNonNull(tag));
    }

    @Override
    public String toString() {
        return title + " " + tags;
    }
}

// Demonstrates the aliasing bug. Do not use this copy method for independently editable movies.
final class ShallowMovie {
    private final String title;
    private final List<String> tags;

    ShallowMovie(String title, List<String> tags) {
        this.title = title;
        this.tags = tags;
    }

    ShallowMovie copy() {
        return new ShallowMovie(title, tags);
    }

    void addTag(String tag) {
        tags.add(tag);
    }

    List<String> tags() {
        return tags;
    }
}
