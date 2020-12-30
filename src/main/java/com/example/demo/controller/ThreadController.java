package com.example.demo.controller;

public class ThreadController {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("start new thread!");
        }
    }


    public static void main(String[] args) {

            Thread t = new MyThread();
            t.start(); // 启动新线程
    }
}
