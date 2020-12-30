package com.example.demo.test;

import com.example.demo.util.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskMain {

    @Autowired
    private TaskService task;

    @RequestMapping("/start")
    public void start() throws Exception {
        long begin = System.currentTimeMillis();
        task.taskOne();			//异步调用
        task.taskTwo();			//异步调用
        task.taskThree();		//异步调用
        System.out.println("主线程总执行时间："+ (System.currentTimeMillis() - begin));
    }
}
