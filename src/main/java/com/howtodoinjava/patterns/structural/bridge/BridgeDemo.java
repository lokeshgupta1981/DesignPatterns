package com.howtodoinjava.patterns.structural.bridge;

import java.util.Objects;

interface Renderer {
  String render(String title, String body);
}

final class PlainRenderer implements Renderer {
  @Override
  public String render(String title, String body) {
    return title + " | " + body;
  }
}

final class HtmlRenderer implements Renderer {
  @Override
  public String render(String title, String body) {
    return "<h1>" + escape(title) + "</h1><p>" + escape(body) + "</p>";
  }

  private String escape(String value) {
    return value.replace("&", "&amp;").replace("<", "&lt;")
        .replace(">", "&gt;").replace("\"", "&quot;")
        .replace("'", "&#39;");
  }
}

abstract class Report {
  protected final Renderer renderer;

  Report(Renderer renderer) {
    this.renderer = Objects.requireNonNull(renderer);
  }

  abstract String generate();
}

final class ShortReport extends Report {
  ShortReport(Renderer renderer) {
    super(renderer);
  }

  @Override
  String generate() {
    return renderer.render("Orders", "2 orders completed");
  }
}

final class DetailedReport extends Report {
  DetailedReport(Renderer renderer) {
    super(renderer);
  }

  @Override
  String generate() {
    return renderer.render("Orders", "2 orders completed, total 4500 cents");
  }
}

public class BridgeDemo {
  public static void main(String[] args) {
    System.out.println(new ShortReport(new PlainRenderer()).generate());
    System.out.println(new ShortReport(new HtmlRenderer()).generate());
    System.out.println(new DetailedReport(new PlainRenderer()).generate());
    System.out.println(new DetailedReport(new HtmlRenderer()).generate());
  }
}
