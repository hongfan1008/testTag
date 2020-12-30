package com.example.demo.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TaskService {

    public static Random random = new Random();

    /**
     * 任务一
     */
    @Async
    public void taskOne() throws Exception {

        int time = random.nextInt(1000);
        System.out.println("Task1，预计执行时间:"+ time);
        long start = System.currentTimeMillis();
        Thread.sleep(time);
        String msg = "Task1 Finished，耗时：" + (System.currentTimeMillis() - start) + "ms";
        System.out.println(msg);
        return ;
    }


    /**
     * 任务二
     * @throws Exception
     */
    @Async
    public void taskTwo() throws Exception {

        int time = random.nextInt(1000);
        System.out.println("Task2，预计执行时间:"+ time);
        long start = System.currentTimeMillis();
        Thread.sleep(time);
        String msg = "Task2 Finished，耗时：" + (System.currentTimeMillis() - start) + "ms";
        System.out.println(msg);
        return ;
    }


    /**
     * 任务三
     * @throws Exception
     */
    @Async
    public void taskThree() throws Exception {

        int time = random.nextInt(1000);
        System.out.println("Task3，预计执行时间:{}"+time);
        long start = System.currentTimeMillis();
        Thread.sleep(time);
        String msg = "Task3 Finished，耗时：" + ( System.currentTimeMillis() - start) + "毫秒";
        System.out.println(msg);
        return ;
    }
}
