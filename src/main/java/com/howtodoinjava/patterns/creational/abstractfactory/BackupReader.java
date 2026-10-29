package com.howtodoinjava.patterns.creational.abstractfactory;

import java.io.IOException;

public interface BackupReader {
    String read(byte[] data) throws IOException;
}
