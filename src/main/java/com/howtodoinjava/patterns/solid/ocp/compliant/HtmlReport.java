package com.howtodoinjava.patterns.solid.ocp.compliant;

import lombok.Data;

@Data
public class HtmlReport implements Reportable {

  Object[][] data;

  public HtmlReport(Object[][] data) {
    this.data = data;
  }

  @Override
  public void generate() {
    //generate html report
  }
}
