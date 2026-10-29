package com.howtodoinjava.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Campaign {
    private final String sender;
    private String subject;
    private final List<Section> sections;

    public Campaign(String sender, String subject, List<Section> sections) {
        this.sender = Objects.requireNonNull(sender);
        this.subject = Objects.requireNonNull(subject);
        this.sections = copySections(Objects.requireNonNull(sections));
    }

    private Campaign(Campaign original) {
        this(original.sender, original.subject, original.sections);
    }

    public Campaign copy() {
        return new Campaign(this);
    }

    private static List<Section> copySections(List<Section> source) {
        List<Section> result = new ArrayList<>();
        for (Section section : source) {
            result.add(new Section(Objects.requireNonNull(section)));
        }
        return result;
    }

    public void setSubject(String subject) {
        this.subject = Objects.requireNonNull(subject);
    }

    public String getSender() { return sender; }
    public String getSubject() { return subject; }
    public Section section(int index) { return sections.get(index); }

    @Override
    public String toString() {
        return subject + " | " + sections;
    }

    public static final class Section {
        private final String heading;
        private String body;

        public Section(String heading, String body) {
            this.heading = Objects.requireNonNull(heading);
            this.body = Objects.requireNonNull(body);
        }

        public Section(Section original) {
            this(original.heading, original.body);
        }

        public String getHeading() { return heading; }
        public String getBody() { return body; }

        public void setBody(String body) {
            this.body = Objects.requireNonNull(body);
        }

        @Override
        public String toString() {
            return heading + ": " + body;
        }
    }
}
