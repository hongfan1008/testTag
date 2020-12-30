package com.example.demo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Generator {
    @Test
    public void run() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test.txt");
        byte b[] = new byte[1024];
        int length = 0;
        while (fileInputStream.read(b) != -1){

        }

    }
}
