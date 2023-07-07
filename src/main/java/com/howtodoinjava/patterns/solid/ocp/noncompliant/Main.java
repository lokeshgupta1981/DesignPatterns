package com.howtodoinjava.patterns.solid.ocp.noncompliant;

import com.howtodoinjava.patterns.solid.ocp.compliant.ExcelReport;
import com.howtodoinjava.patterns.solid.ocp.compliant.PdfReport;

public class Main {

  public static void main(String[] args) {

    ReportGenerator generator = new ReportGenerator();

    generator.generate(new PdfReport(null));
    generator.generate(new ExcelReport(null));
  }
}
