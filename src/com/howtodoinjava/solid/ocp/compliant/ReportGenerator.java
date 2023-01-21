package com.howtodoinjava.solid.ocp.compliant;

public class ReportGenerator {

  public void generate(Reportable report) {
    //pre-processing
    report.generate();
    //post-processing
  }
}
