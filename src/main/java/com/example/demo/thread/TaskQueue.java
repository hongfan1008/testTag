package com.example.demo.thread;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
//        myThread2.start();
//        System.out.println("4567897899");
        MyThread2 myThread3 = new MyThread2();
        myThread2.setName("窗口1");
        myThread3.setName("窗口2");
        myThread2.start();
        myThread3.start();
    }

}
class MyThread2 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
//        addTask("123");
////        getTask();
//        System.out.println(queue);
        while (true) {
            list();
        }

//        getTask();
    }

    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
    }
    public synchronized String getTask() {
        while (queue.isEmpty()) {
        }
        return queue.remove();
    }

    public synchronized void list(){
        if (ticket > 0){
            try {

                Thread.sleep(100);
            }catch (Exception e){}
            System.out.println(getName() + ": 卖票，票号为："+ ticket);
            ticket -- ;
        }else {

        }
    }
}
