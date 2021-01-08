package com.example.demo.thread;

public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {
        MyThread5 t = new MyThread5();
        t.start();
//        Thread.sleep(1); // 暂停1毫t秒
        t.interrupt(); // 中断t线程
//        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread5 extends Thread {
    public void run() {
        int n = 0;
//        System.out.println(n++);
        for (int i = 0; i<5; i++){
            System.out.println(i);
        }
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}

