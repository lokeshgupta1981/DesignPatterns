package com.howtodoinjava.solid.ocp.noncompliant;

public class ReportGenerator {

  public void generate(Reportable report) {

    if(report instanceof ExcelReport) {
      //create excel report
    } else if(report instanceof PdfReport) {
      //create pdf report
    }
  }
}
