package com.howtodoinjava.patterns.solid.ocp.noncompliant;

import com.howtodoinjava.patterns.solid.ocp.compliant.ExcelReport;
import com.howtodoinjava.patterns.solid.ocp.compliant.PdfReport;
import com.howtodoinjava.patterns.solid.ocp.compliant.Reportable;

public class ReportGenerator {

  public void generate(Reportable report) {

    if(report instanceof ExcelReport) {
      //create excel report
    } else if(report instanceof PdfReport) {
      //create pdf report
    }
  }
}
