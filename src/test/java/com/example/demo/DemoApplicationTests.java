package com.example.demo;

import com.example.demo.config.AsyncTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private AsyncTask asyncTask;
    @Test
    void test() {
        for (int i = 0; i < 100; i++) {
            asyncTask.run(i);
        }
        System.out.println("sasdsadsadsads");
    }

}
