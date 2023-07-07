package com.howtodoinjava.patterns.structural.bridge;

public interface FileDownloadImplementor {

  Object downloadFile(String path);
  boolean storeFile(Object object);
}
