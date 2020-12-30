package com.example.demo.thread;

public class Main {
    public static void main(String[] args) {
//        new Thread1().start();
//        new Thread2().start();
//        for (int i = 0; i < 100; i++) {
//            System.out.println("main: running...");
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//            }
//        }
        try {
            Thread t = new MyThread();
            t.start();
            Thread.sleep(1); // 暂停1毫秒
            t.interrupt(); // 中断t线程
            t.join(); // 等待t线程结束
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread-1: running...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Thread2 extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread-2: running...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}

class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}

