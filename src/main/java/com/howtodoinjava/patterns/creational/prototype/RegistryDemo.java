package com.howtodoinjava.patterns.creational.prototype;

import java.util.List;
import java.util.Map;

public class RegistryDemo {
    public static void main(String[] args) {
        Campaign template = new Campaign("news@example.com", "Monthly update",
                List.of(new Campaign.Section("News", "Add this month's news"),
                        new Campaign.Section("Events", "Add upcoming events")));
        Map<String, Campaign> templates = Map.of("newsletter", template);
        Campaign draft = templates.get("newsletter").copy();
        draft.setSubject("November update");
        System.out.println("Template: " + template.getSubject());
        System.out.println("Draft: " + draft.getSubject());
    }
}
