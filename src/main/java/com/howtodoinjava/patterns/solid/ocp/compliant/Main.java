package com.howtodoinjava.patterns.solid.ocp.compliant;

import com.howtodoinjava.patterns.solid.ocp.noncompliant.ReportGenerator;

public class Main {

  public static void main(String[] args) {

    com.howtodoinjava.patterns.solid.ocp.noncompliant.ReportGenerator generator = new ReportGenerator();

    generator.generate(new PdfReport(null));
    generator.generate(new ExcelReport(null));

    generator.generate(new HtmlReport(null));
  }
}
