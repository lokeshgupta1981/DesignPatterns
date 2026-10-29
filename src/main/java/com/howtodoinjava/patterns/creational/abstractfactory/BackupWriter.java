package com.howtodoinjava.patterns.creational.abstractfactory;

import java.io.IOException;

public interface BackupWriter {
    byte[] write(String text) throws IOException;
}
