package com.example.demo.test;

import com.example.demo.domain.Employee;
import com.example.demo.util.SerializationUtil;

import java.io.IOException;

public class SerializationTest {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Administrator\\Desktop\\test.txt";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);
        emp.setPassword("123456");

        //serialize to file
        try {
            SerializationUtil.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("emp Object::" + emp);
        System.out.println("empNew Object::" + empNew);
    }

}
