package com.howtodoinjava.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import com.howtodoinjava.patterns.creational.prototype.Campaign.Section;

public class PrototypeDemo {
    public static void main(String[] args) {
        Campaign template = new Campaign("news@example.com", "Monthly update",
                List.of(new Section("News", "Add this month's news"),
                        new Section("Events", "Add upcoming events")));

        Campaign october = template.copy();
        october.setSubject("October update");
        october.section(0).setBody("Our new store opens Friday");

        System.out.println("Template: " + template);
        System.out.println("Copy: " + october);
        System.out.println("Different campaigns: " + (template != october));
        System.out.println("Different sections: " + (template.section(0) != october.section(0)));
        System.out.println("Sender retained: " + template.getSender().equals(october.getSender()));

        Campaign another = template.copy();
        System.out.println("Another copy: " + another.section(0).getBody());

        List<Section> originalSections = new ArrayList<>();
        originalSections.add(new Section("News", "Original text"));
        List<Section> copiedList = new ArrayList<>(originalSections);
        copiedList.get(0).setBody("Changed through copied list");

        System.out.println("Different lists: " + (originalSections != copiedList));
        System.out.println("Same section: " + (originalSections.get(0) == copiedList.get(0)));
        System.out.println("Original section: " + originalSections.get(0).getBody());
    }
}
