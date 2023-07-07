package com.howtodoinjava.patterns.solid.ocp.compliant;

import lombok.Data;

@Data
public class PdfReport implements Reportable {

  Object[][] data;

  public PdfReport(Object[][] data) {
    this.data = data;
  }

  @Override
  public void generate() {
    //generate pdf report
  }
}