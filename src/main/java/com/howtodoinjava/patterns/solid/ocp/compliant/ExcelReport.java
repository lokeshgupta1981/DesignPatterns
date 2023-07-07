package com.howtodoinjava.patterns.solid.ocp.compliant;

import lombok.Data;

@Data
public class ExcelReport implements Reportable {

  Object[][] data;

  public ExcelReport(Object[][] data) {
    this.data = data;
  }

  @Override
  public void generate() {
    //generate excel report
  }
}
