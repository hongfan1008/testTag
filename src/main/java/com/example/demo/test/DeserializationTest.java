package com.example.demo.test;

import com.example.demo.domain.Employee;
import com.example.demo.util.SerializationUtil;

import java.io.IOException;

public class DeserializationTest {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Administrator\\Desktop\\test.txt";
        Employee empNew = null;

        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("empNew Object::" + empNew);

    }
}
