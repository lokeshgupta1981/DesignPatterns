package com.howtodoinjava.solid.ocp.noncompliant;

public class Main {

  public static void main(String[] args) {

    ReportGenerator generator = new ReportGenerator();

    generator.generate(new PdfReport(null));
    generator.generate(new ExcelReport(null));
  }
}
