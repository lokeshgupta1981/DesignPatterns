package com.howtodoinjava.patterns.solid.ocp.compliant;

public class ReportGenerator {

  public void generate(Reportable report) {
    //pre-processing
    report.generate();
    //post-processing
  }
}
