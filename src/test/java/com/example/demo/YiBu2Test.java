package com.example.demo;

import com.example.demo.util.TestAsyncBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class YiBu2Test {
    @Autowired
    private TestAsyncBean testAsyncBean;
    @Test
    public void test_sayHello4() throws InterruptedException, ExecutionException {
        System.out.println("你不爱我了么?");
        testAsyncBean.sayHello4();
        System.out.println("回的这么慢, 你肯定不爱我了, 我们还是分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
    }


    @Test
    public void test_sayHello1() throws InterruptedException, ExecutionException {
        Future<String> future = null;
        System.out.println("你不爱我了么?");
        future = testAsyncBean.sayHello1();
        System.out.println("你竟无话可说, 我们分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
        System.out.println(future.get());
    }
}
