package com.howtodoinjava.solid.ocp.compliant;

import lombok.Data;

public interface Reportable {

  public void generate();
}

@Data
class ExcelReport implements Reportable {

  Object[][] data;

  public ExcelReport(Object[][] data) {
    this.data = data;
  }

  @Override
  public void generate() {
    //generate excel report
  }
}

@Data
class PdfReport implements Reportable {

  Object[][] data;

  public PdfReport(Object[][] data) {
    this.data = data;
  }

  @Override
  public void generate() {
    //generate pdf report
  }
}

@Data
class HtmlReport implements Reportable {

  Object[][] data;

  public HtmlReport(Object[][] data) {
    this.data = data;
  }

  @Override
  public void generate() {
    //generate html report
  }
}